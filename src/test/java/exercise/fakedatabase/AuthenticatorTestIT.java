package exercise.fakedatabase;

import Utils.Mailer;
import exercise.Authenticator;
import exercise.AuthenticatorTest;
import exercise.realdatabase.UserFacadeRealDB;

import static org.mockito.Mockito.mock;

/**
 * Created by CosticaTeodor on 19/04/2017.
 */
public class AuthenticatorTestIT extends AuthenticatorTest {

    @Override
    public Authenticator makeAuthenticator(){
        Mailer mailer = mock(Mailer.class);

        if (System.getenv("TRAVIS") != null) {
            return new Authenticator(new UserFacadeRealDB("pu_mySql_travis_Integration"), mailer);
        }
        return new Authenticator(new UserFacadeRealDB("pu_localDB"), mailer);
    }

}
