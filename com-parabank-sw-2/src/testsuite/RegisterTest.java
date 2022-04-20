package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openbrowser(baseurl);

    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //find element to regester filed and clickon it
        WebElement registerfiled = driver.findElement(By.linkText("Register"));
        registerfiled.click();

        //verify the text
        String expectedtext = "Signing up is easy!";
        String actualtext = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        //validate actual and expected
        Assert.assertEquals(expectedtext, actualtext);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find element to register filed and click on it
        WebElement registerfiled = driver.findElement(By.linkText("Register"));
        registerfiled.click();

        //find element to firstname and sending element to filed
        driver.findElement(By.id("customer.firstName")).sendKeys("Shilpa");

        //find element to lastname and sending element to filed
        driver.findElement(By.xpath("//input[@name='customer.lastName']")).sendKeys("Patel");

        //find element to add and sending element to filed
        driver.findElement(By.id("customer.address.street")).sendKeys("11 Eden close");

        //find element to city and sending element to filed
        driver.findElement(By.xpath("//input[@class='input' and @name='customer.address.city']")).sendKeys("London");

        //find elementto state and sending element to filed
        driver.findElement(By.name("customer.address.state")).sendKeys("London");

        //find element to zipcode and sending element to filed
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("NW4 1DD");

        //find element to phonenumber and sending element to filed
        driver.findElement(By.name("customer.phoneNumber")).sendKeys("07867567865");

        //find element to ssn number and sending element to filed
        driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("721-07-1426");

        //find element to username and sending element to filed
        driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("shilpa2@gmail.com");

        //find password to password filed and sending element to filed
        driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("1234556");

        //find element to confirm passoerd and sending element to conform passwordfiled
        driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("1234556");

        //find element to register butooton and click on it
        driver.findElement(By.tagName("input")).click();

        //find
        String expectedresults="Your account was created successfully. You are now logged in.";
        String actualresults=driver.findElement(By.xpath("//p[(text(),'Your account was created successfully. You are now logged in')]")).getText();
        //validate actual and expected text
        Assert.assertEquals(expectedresults,actualresults);
    }
    public void closeBrowser() {

        driver.quit();
    }


}
