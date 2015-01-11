package PageObjects;

/**
 * The Home Page in the Page Object Model.
 * Inherits from AbstractPage
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage
{
    private String mCorrectPageURL = "http://store.demoqa.com/";
    private By mMyAccountLink = By.className("account_icon");
    private By mCheckoutLink =  By.className("cert_icon");

    public HomePage()
    {
        //super();
        if (this.GetDriver().getCurrentUrl() == null || this.GetDriver().getCurrentUrl().contains("about:blank"))
        {
            this.GetDriver().navigate().to(GetCorrectPageURL());
        }
        else
        {
            IsCurrentURL(GetCorrectPageURL());
        }
    }

    /**
     * Clicks the My Account link
     * @return a MyAccountLoginPage which inherits the common static WebDriver instance
     */
    public MyAccountLoginPage ClickMyAccount()
    {
        WebElement myAccountLink = this.GetElement(mMyAccountLink);
        myAccountLink.click();
        return new MyAccountLoginPage();
    }

    public void ClickCheckoutLink()
    {
        WebElement checkoutLink = this.GetElement(mCheckoutLink);
        checkoutLink.click();
    }


    @Override
    public String GetCorrectPageURL()
    {
        return mCorrectPageURL;
    }




}
