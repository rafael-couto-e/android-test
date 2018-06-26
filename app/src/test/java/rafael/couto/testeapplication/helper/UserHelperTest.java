package rafael.couto.testeapplication.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rafael.couto.testeapplication.model.User;

import static com.google.common.truth.Truth.*;
import static org.mockito.Mockito.*;

public class UserHelperTest {
    private static User user;
    private static UserHelper helper;

    @BeforeClass
    public static void init(){
        user = mock(User.class);
        when(user.getName()).thenReturn("Test User");
        helper = mock(UserHelper.class);
        when(helper.concat(user)).thenReturn("No mockito é assim");
    }

    @AfterClass
    public static void finish(){
        System.out.println("Test finished :)");
    }

    @Before
    public void setup(){
        System.out.println("Starting test case :)");
    }

    @After
    public void tearDown(){
        System.out.println("Finishing test case :)");
    }

    @Test
    public void concatTest(){
        assertThat(helper.concat(user)).isEqualTo("No mockito é assim");
    }

    @Test
    public void realTest(){
        UserHelper helper = new UserHelper();

        assertThat(helper.concat(user)).isEqualTo("Usuário: Test User default");
    }

    @Test(expected = NullPointerException.class)
    public void concatWithNullUserTest(){
        try{
            UserHelper helper = new UserHelper();
            helper.concat(null);
        }catch (NullPointerException e){
            assertThat(e.getMessage()).isEqualTo("User cannot be null.");
            throw e;
        }
    }
}