package Utils;

/**
 * Created by Paul on 6/01/2015.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Utils
{
    private static WebDriver mWebDriver = null;

    public Utils()
    {
    }

    //Returns a single, persistent instance of the WebDriver object.
    public static WebDriver getWebDriver()
    {
        if(mWebDriver == null)
        {
            mWebDriver = new FirefoxDriver();
        }

        return mWebDriver;
    }

    public static void CloseWebDriver()
    {
        mWebDriver.close();
        mWebDriver = null;
    }


}
