package com.bartosz.automationpractise;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class RegistrationTest {
    private HeaderBanner headerBanner;
    private RegistrationPage registrationPage;
    private SignInPage signInPage;
    Faker faker = new Faker();

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerBanner = new HeaderBanner(driver);
        registrationPage = new RegistrationPage(driver);
        signInPage = new SignInPage(driver);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void registerUser() {
        headerBanner.goToLoginProcess();
        signInPage.initiateRegistrationProcess(faker.internet().emailAddress());
        registrationPage.fillPersonalInformation("Tony", "Hawk", "125Jojo");
        registrationPage.fillAddress("White Heart Lane",
                "London", "35005", "+48611208294");
        String actualResult = headerBanner.getLoggedInUserName();
        String expectedResult = "Tony Hawk";
        assertThat(actualResult).isEqualTo(expectedResult);


    }


}
