/**
 * Created by Paul on 6/01/2015.
 **/
import PageObjects.MyAccountLoginPage;
import PageObjects.MyAccountPage;
import org.junit.*;
import PageObjects.HomePage;


public class SelTests
{
    /**
     *      Checks that the number of items stated in the Home Page Checkout is always 0
     */

    @Test
    public void WhenNotLoggedIn_NoCheckoutItemsZero()
    {
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.GetNoOfCheckoutItems(),0);
        homePage.Close();
    }

    /**
     *      Checks that the MyAccount Login Page is accessible and that a user can log in
     */
    @Test
    public void LogInSuccessful()
    {
        HomePage homePage = new HomePage();
        MyAccountLoginPage myAccountLoginPage = homePage.ClickMyAccount();
        myAccountLoginPage.AddLogin("testuser_1");
        myAccountLoginPage.AddPassword("Test@123");
        MyAccountPage myAccountPage =  myAccountLoginPage.ClickLoginButton();

        boolean loggedIn = myAccountPage.IsLoggedn();
        Assert.assertTrue("Page not logged in",loggedIn);
        if(loggedIn) myAccountPage.ClickLogout();
        homePage.Close();
    }


    /**
     *     The default number of Checkout items for this login in demoqa.com is 4. This checks for that.
     */
    @Test
    public void WhenLoggedIn_NoCheckoutItemsFour()
    {
        HomePage homePage = new HomePage();
        MyAccountLoginPage myAccountLoginPage = homePage.ClickMyAccount();
        myAccountLoginPage.AddLogin("testuser_1");
        myAccountLoginPage.AddPassword("Test@123");
        MyAccountPage myAccountPage =  myAccountLoginPage.ClickLoginButton();

        boolean loggedIn = myAccountPage.IsLoggedn();

        if(loggedIn)
        {
            Assert.assertEquals(homePage.GetNoOfCheckoutItems(),4);
            myAccountPage.ClickLogout();
        }
        else
        {
            Assert.fail("Login Failed. Test aborted");
        }

        homePage.Close();
    }



}
