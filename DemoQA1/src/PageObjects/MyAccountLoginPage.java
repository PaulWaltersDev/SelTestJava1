package PageObjects;

/**
 * Created by Paul on 6/01/2015.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountLoginPage extends AbstractPage
{
    private String mCorrectPageURL = "http://store.demoqa.com/products-page/your-account/";
    private By mUserNameBox = By.cssSelector("input[id='log'][class='text']");
    private By mPasswordBox = By.cssSelector("input[id='pwd'][class='text']");
    private By mLoginButton = By.cssSelector("input[id='login'][type='submit']");

    public MyAccountLoginPage()
    {
        IsCurrentURL(GetCorrectPageURL());
    }

    /**
     * Adds a Login Name to the Login box on the page
     * @param Login
     */
    public void AddLogin(String Login)
    {
        WebElement userNameBox = this.GetElement(mUserNameBox);
        userNameBox.sendKeys(Login);
    }

    /**
     * Adds a Password to the Password box on the page
     * @param Password
     */
    public void AddPassword(String Password)
    {
        WebElement passwordBox = this.GetElement(mPasswordBox);
        passwordBox.sendKeys(Password);
    }

    /**
     * Clicks the page's Logout Link (top right hand corner)
     * @return A MyAccountPage object which inherits the common static WebDriver instance
     */
    public MyAccountPage ClickLoginButton()
    {
        WebElement loginButton  = this.GetElement(mLoginButton);
        loginButton.click();
        return new MyAccountPage();
    }

    /**
     * Gets the correct Page URL that this page have to if working.
     * Currently hard coded. This will be addressed in future work.
     * @return Correct Page URL
     */
    @Override
    public String GetCorrectPageURL()
    {
        return mCorrectPageURL;
    }
}
