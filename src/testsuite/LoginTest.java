package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find username and Enter username in username field: 'tomsmith'
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        //Enter valid password in password field:SuperSecretPassword!
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        //Click on the Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //verify the text Secure Area
        String expectedMessage = "Secure Area";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='example']//h2"));
        String actualMessage1 = actualMessage.getText();
        Assert.assertEquals("Text Not matched", actualMessage1, expectedMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Find username and Enter invalid username in username field: 'tomsmith1'
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith1");
        //Enter valid password in password field:SuperSecretPassword!
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        //Click on the Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //verify the error message
        String expectedMessage = "Your username is invalid!\n" + "×";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage1 = actualMessage.getText();
        Assert.assertEquals("Error message not found", actualMessage1, expectedMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Find username and Enter username in username field: 'tomsmith'
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith1");
        //Enter invalid password in password field:SuperSecretPassword!
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");

        //Click on the Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //verify the error message
        String expectedMessage = "Your username is invalid!\n" + "×";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage1 = actualMessage.getText();
        Assert.assertEquals("Error message not found", actualMessage1, expectedMessage);

    }

    @After
    public void TearDown() {
        closeBrowser();
    }

}
