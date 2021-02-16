package com.bartosz.automationpractise;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class FillTheForm {
    private final WebDriver driver;

    public FillTheForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    WebElement firstNameInput;
    @FindBy(css = "#inputLastName3")
    WebElement lastNameInput;
    @FindBy(css = "#inputEmail3")
    WebElement emailInput;
    @FindBy(css = "#gridRadiosOther")
    WebElement sexSelect;
    @FindBy(css = "#inputAge3")
    WebElement ageInput;
    @FindBy(css = "#gridCheckAutomationTester")
    WebElement professionSelect;
    @FindBy(css = "#selectContinents")
    WebElement continentsDropdown;
    @FindBy(css = "[value='europe']")
    WebElement continentSelect;
    @FindBy(css = "#selectSeleniumCommands [value='navigation-commands']")
    WebElement seleniumCommandsSelect;
    @FindBy(css = "#additionalInformations")
    WebElement aditionalInfoTextInput;
    @FindBy(css = "[type='submit']")
    WebElement signInButton;
    @FindBy(css = "#chooseFile")
    WebElement uploadFileButton;
    @FindBy(css = "[role='button']")
    WebElement downloadButton;




    public void fillEmptySpaces(){
        Random random = new Random();
        Faker faker = new Faker();
        firstNameInput.sendKeys(faker.name().firstName());
        lastNameInput.sendKeys(faker.name().lastName());
        emailInput.sendKeys(faker.internet().emailAddress());
        sexSelect.click();
        int age = random.nextInt(65-18)+18;
        String ageToString = Integer.toString(age);
        ageInput.sendKeys(ageToString);
        WebElement ageOfExperienceDropdown = driver.findElement(By.cssSelector(
                "[name='gridRadiosExperience'][value='" + 2 + "']"));
        ageOfExperienceDropdown.click();
        professionSelect.click();
        continentsDropdown.click();
        continentSelect.click();
        seleniumCommandsSelect.click();
        aditionalInfoTextInput.sendKeys("This is the test");
        uploadFileButton.sendKeys("D:\\dane dysk D\\Bartosz\\cv+lm\\rogala bartosz 2x2,5.jpg");
        signInButton.click();
    }

}
