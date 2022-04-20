package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String url = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openbrowser(url);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //find the element usename and sending element to usename
        driver.findElement(By.xpath("//input[@type='text' and @name='username']")).sendKeys("nailart@gmail.com");

        //find the element password filed and sending data to password filed
        driver.findElement(By.xpath("//input[@type='password' and @class='input']")).sendKeys("123456");

        //find element on login button and click on it
        driver.findElement(By.xpath("//input[@type='submit' and @class='button']")).click();

        //find element text and gettext to element
        String excpectedtext = "Accounts Overview";
        String actualtext = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        //validate both results
        Assert.assertEquals(excpectedtext, actualtext);
    }

    @Test
    public void verifyTheErrorMessage() {
        //find the element usename and sending element to usename
        driver.findElement(By.xpath("//input[@type='text' and @name='username']")).sendKeys("abcdesr");

        //find the element password filed and sending data to password filed
        driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("123");

        //find element on login button and click on it
        driver.findElement(By.xpath("//input[@type='submit' and @class='button']")).click();

        //find element and get  the text
        String expectedtext = "The username and password could not be verified.";
        String actualtext = driver.findElement(By.xpath("//p[@class='error']")).getText();
        //validate both expected and results
        Assert.assertEquals(actualtext, expectedtext);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //find the element usename and sending element to usename
        driver.findElement(By.xpath("//input[@type='text' and @name='username']")).sendKeys("nailart@gmail.com");

        //find the element password filed and sending data to password filed
        driver.findElement(By.xpath("//input[@type='password' and @class='input']")).sendKeys("123456");

        //find element on login button and click on it
        driver.findElement(By.xpath("//input[@type='submit' and @class='button']")).click();

        //find element text and gettext to element
        driver.findElement(By.linkText("Log Out")).click();

        String expectedtext = "Customer Login";
        String actualtext = driver.findElement(By.xpath("//h2[text()='Customer Login']")).getText();
        //validate actual and expectedtext
        Assert.assertEquals(actualtext, expectedtext);
    }


        public void closeBrowser() {
         driver.quit();
    }
}