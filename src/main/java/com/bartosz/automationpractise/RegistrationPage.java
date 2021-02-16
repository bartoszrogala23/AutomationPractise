package com.bartosz.automationpractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.util.Random;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#id_gender1")
    private WebElement genderSelect;
    @FindBy(css = "#customer_firstname")
    private WebElement firstNameInput;
    @FindBy(css = "#customer_lastname")
    private WebElement lastNameInput;
    @FindBy(css = "#passwd")
    private WebElement passwordInput;
    @FindBy(css = "#days [value='1']")
    private Select dayOfBirthSelect;
    @FindBy(css = "#months")
    private Select monthOfBirthSelect;
    @FindBy(css = "#years")
    private Select yearOfBirthSelect;
    @FindBy(css = "#newsletter")
    private WebElement newsletter;
    @FindBy(css = "#optin")
    private WebElement recieveOffersButton;
    @FindBy(css = "#address1")
    private WebElement addressLineFirstInput;
    @FindBy(css = "#city")
    private WebElement cityInput;
    @FindBy(css = "#id_state [value='1']")
    private WebElement state;
    @FindBy(css = "#postcode")
    private WebElement postcodeInput;
    @FindBy(css = "#id_country [value='21']")
    private WebElement country;
    @FindBy(css = "#phone_mobile")
    private WebElement mobilePhoneNumberInput;
    @FindBy(css = "#alias")
    private WebElement assignAddress;
    @FindBy(css = "#submitAccount")
    private WebElement submitAccountButton;
    @FindBy(css = "[title='View my customer account']")
    private WebElement accountTitleButton;

    public void fillPersonalInformation(String userFirstname, String userLastname, String userPassword) {
        genderSelect.click();
        firstNameInput.sendKeys(userFirstname);
        lastNameInput.sendKeys(userLastname);
        passwordInput.sendKeys(userPassword);
        Random random = new Random();
        dayOfBirthSelect = new Select(driver.findElement(By.cssSelector("#days")));
        dayOfBirthSelect.selectByValue(String.valueOf(random.nextInt(25-1)+1));
        monthOfBirthSelect = new Select(driver.findElement(By.cssSelector("#months")));
        monthOfBirthSelect.selectByValue(String.valueOf(random.nextInt(12-1)+1));
        yearOfBirthSelect = new Select(driver.findElement(By.cssSelector("#years")));
        yearOfBirthSelect.selectByValue(String.valueOf(random.nextInt(2020 - 1950) + 1950));
        newsletter.click();
        recieveOffersButton.click();

    }

    public void fillAddress(String addressFirstLine, String city, String postCode, String phoneNumber) {
        addressLineFirstInput.sendKeys(addressFirstLine);
        cityInput.sendKeys(city);
        state.click();
        postcodeInput.sendKeys(postCode);
        mobilePhoneNumberInput.sendKeys(phoneNumber);
        submitAccountButton.click();

    }


}
