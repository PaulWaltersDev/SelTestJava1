package PageObjects;

/**
 * Created by Paul on 6/01/2015.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends AbstractPage
{
    private String mCorrectPageURL = "http://store.demoqa.com/products-page/your-account/?login=1";
    private String mHomeURL = "http://store.demoqa.com";

    private By mHTML = By.cssSelector("html a[class=' firefox firefox34 windows js flexbox canvas canvastext no-touch postmessage no-websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients no-cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache']");
    private By mAccountLogout = By.id("account_logout");
    private By mYourAccount = By.className("entry-title");
    private By mMyAccountAdminBar = By.cssSelector("li[id='wp-admin-bar-my-account'][class='menupop with-avatar']");
    private By mDisplayName = By.className("display-name");


    public MyAccountPage()
    {
        IsCurrentURL(GetCorrectPageURL());
    }

    /**By checking the existence and visibility of the Logout Link and the Your Account content div,
     *(checks that login was successful)
     * @return True if Logged In, False if not
     */
    public boolean IsLoggedn()
    {
        WebElement logoutLink =  this.GetElement(mAccountLogout);

        WebElement yourAccountContent = this.GetElement(mYourAccount);

        if(logoutLink != null && logoutLink.isEnabled() && logoutLink.isEnabled())
        {
            if(yourAccountContent != null && yourAccountContent.isEnabled() & yourAccountContent.isDisplayed())
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Click's the Logout link
     * @return A New HomePage Object which inherits the common static WebDriver instance
     */
    public HomePage ClickLogout()
    {
        WebElement logoutLink = this.GetElement(mAccountLogout);
        logoutLink.click();
        GetDriver().navigate().to(mHomeURL);
        return new HomePage();
    }


    /**
     * Returns the Correct URL this page should have. Currently hardcoded.
     * @return Correct URL for the page
     */
    @Override
    public String GetCorrectPageURL()
    {
        return mCorrectPageURL;
    }




}
