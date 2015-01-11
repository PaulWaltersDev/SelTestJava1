package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.lang.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Utils.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract Page. This is the superclass for all pages
 * and contains all functions common to every page tested on DemoQA.
 * Also contains the instance of the static WebDriver used in Utils, which all subpages use.
 * May be spun off into a separate package and made generic in future releases.
 */
public abstract class AbstractPage
{
    private WebDriver mDriver;
    private By mNoCheckoutItems = By.cssSelector("em[class='count']");

    public AbstractPage()
    {
        mDriver = Utils.getWebDriver();
        mDriver.manage().window().maximize();
//
//        if(this.PageURL() != null)
//        {
//            if(!this.PageURL().contains("about:blank")) IsCurrentURL(GetCorrectPageURL());
//        }
    }

    /**
     * Returns the current PageURL for the current page displayed by the browser launched by the WebDriver;
     * @return PageURL
     */
    public String PageURL()
    {
        return mDriver.getCurrentUrl();
    }

    /**
     * Returns the Page Title for the current page displayed by the browser launched by the WebDriver;
     * @return Page Title
     */
    public String PageTitle()
    {
        return mDriver.getTitle();
    }

    /**
     * Returns a Select object for the page's menu. Included in the Abstract class as all pages in this test have the same menu.
     * @return A select object that can be used to access the Menu.
     */
    public Select GetMenu()
    {
        Select menu = new Select(mDriver.findElement(By.id("menu-main-menu")));

        if(menu == null)
        {
            throw new NoSuchElementException("Menu not present on page.");
        }

        return menu;
    }

    /**
     * Returns a WebElement corresponding to the passed in "By" object
     *  - only if it exists, is visible and enabled.
     * Otherwise throws a NotFoundException
     * For single objects only
     * @param ElementBy
     * @return The associated WebElement
     */
    protected WebElement GetElement(By ElementBy)
    {
        WebDriverWait wait = new WebDriverWait(mDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ElementBy));
        WebElement webElement = mDriver.findElement(ElementBy);
        if(webElement != null && webElement.isDisplayed() && webElement.isEnabled())
        {
            return webElement;
        }
        else
        {
            throw new NoSuchElementException("WebElement either nonexistent, hidden or disabled");
        }
    }

    /**
     * Exposes the WebDriver for subpages only
     * @return the WebDriver object used by Selenium in this test
     */
    protected WebDriver GetDriver()
    {
        return mDriver;
    }

    /**
     * Closes the Page and quits the underlying driver
     */

    public void Close()
    {
        Utils.CloseWebDriver();
    }

    /**
     * Returns the number X in  'X item | Checkout'
     * @return the number o items checkout as seen in the text above.
     */
    public int GetNoOfCheckoutItems()
    {
        WebElement noCheckoutItems = this.GetElement(mNoCheckoutItems);
        int i = Integer.parseInt(noCheckoutItems.getText());
        return i;
    }

    /**
     * Returns the Correct Page URL. This must be implemented in all subclasses.
     */
    public abstract String GetCorrectPageURL();

    /**
     * Checks if the CurrentURL (as specified in the underlying WebDriver) matches the entered URL.
     * Called by the constructor when th ePage is first created but the Driver has already been instantiated (i.e. not the first page that was opened)
     */
    public boolean IsCurrentURL(String PageURL)
    {
        if(PageURL.equals(this.GetCorrectPageURL())) { return true; }
        else
        {
            throw new WebDriverException("Current Page URL does not match the expected Page URL for this page");
        }
    }
}
