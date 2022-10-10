package com.epam.pages.popup;

import com.epam.helpers.SharedTestData;
import com.epam.pages.common.CommonPopup;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class CreatePopup extends CommonPopup {

    @FindBy(id = "name")
    protected WebElement nameInput;
    @FindBy(id = "surname")
    protected WebElement surnameInput;
    @FindBy(id = "email")
    protected WebElement emailInput;
    @FindBy(id = "password")
    protected WebElement passwordInput;
    @FindBy(id = "btn")
    protected WebElement generatePasswordButton;
    @FindBy(xpath = "//*[@id='email']/following-sibling::div/p")
    protected WebElement emailInvalidAndExistedErrorMessage;
    @FindBy(xpath = "//input/following-sibling::div[@class='error']")
    protected List<WebElement> errorMessagesOfBlankInputFields;
    @FindBy(xpath = "//input[not(@id='password')]/following-sibling::div[@class='error']")
    protected List<WebElement> errorMessagesOfMoreSymbols;
    @FindBy(id = "popup-container")
    protected WebElement popupWindow;
    private String password;

    public void fillName(String name) {
        uiHelper.sendKeys(nameInput, name);
        SharedTestData.setNameField(name);
    }

    public void fillNameWithMoreSymbols() {
        String generatedString = RandomStringUtils.random(50, true, true);
        uiHelper.sendKeys(nameInput, generatedString);
        logger.info("50 symbols in name field are {}", generatedString);
    }

    public void fillSurname(String surname) {
        uiHelper.sendKeys(surnameInput, surname);
        SharedTestData.setSurnameField(surname);
    }

    public void fillSurnameWithMoreSymbols() {
        String generatedString = RandomStringUtils.random(50, true, true);
        uiHelper.sendKeys(surnameInput, generatedString);
        logger.info("50 symbols in surname field are {}", generatedString);
    }

    public void fillEmail(String email) {
        uiHelper.sendKeys(emailInput, email);
        SharedTestData.setLastGeneratedEmail(email);
    }

    public void fillEmailWithMoreSymbols() {
        String generatedString = RandomStringUtils.random(50, true, true);
        uiHelper.sendKeys(emailInput, generatedString);
        logger.info("50 symbols in email input are {}", generatedString);
    }

    public void fillInvalidEmail() {
        uiHelper.sendKeys(emailInput, SharedTestData.getInvalidEmail());
    }

    public void fillExistedEmail() {
        uiHelper.sendKeys(emailInput, SharedTestData.getExistedEmail());
    }

    public void fillAllFields() {
        fillName("Davit");
        fillSurname("Balabekyan");
        fillEmail(System.currentTimeMillis() + "@gmail.com");
    }

    private void clickOnGeneratePasswordButtonInternal() {
        uiHelper.clickOnWebElement(generatePasswordButton);
    }

    public void clickOnGeneratePasswordButton() {
        clickOnGeneratePasswordButtonInternal();
        SharedTestData.setLastGeneratedPassword(passwordInput.getDomProperty("value"));
    }

    public void doubleClickOnGeneratePasswordButton() {
        clickOnGeneratePasswordButtonInternal();
        password = passwordInput.getDomProperty("value");
        clickOnGeneratePasswordButton();
    }

    public boolean checkAllFieldsArePresent() {
        logger.info("Check fields name, surname, email, password, save button," +
                "generate password button, X button are displayed in create popup");
        return uiHelper.checkElementsAreDisplayed(nameInput,
                surnameInput,
                emailInput,
                passwordInput,
                saveButton,
                generatePasswordButton,
                xButton);
    }

    public boolean checkAllInputFieldsAreEmpty() {
        logger.info("Check fields name, surname, email, password are displayed in create popup");
        return uiHelper.checkElementsAreEmpty(nameInput,
                surnameInput,
                emailInput,
                passwordInput);
    }

    public boolean checkGeneratedPasswordIsFilled() {
        return !passwordInput.getDomProperty("value").isEmpty();
    }

    public boolean checkGeneratePasswordButtonIsEnabled() {
        return generatePasswordButton.isEnabled();
    }

    public boolean checkGeneratedPasswordStructure() {
        return passwordInput.getDomProperty("value")
                .matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#!%*?&])[A-Za-z\\d@$!#%*?&]{9,50}");
    }

    public boolean checkThePasswordFieldIsDisabled() {
        return Boolean.parseBoolean(passwordInput.getAttribute("readonly"));
    }

    public boolean passwordIsChanged() {
        return !password.equals(SharedTestData.getLastGeneratedPassword());
    }

    public String getInvalidEmailErrorMessage() {
        return emailInvalidAndExistedErrorMessage.getText();
    }

    public boolean checkErrorMessagesOfBlankInputFields() {
        return errorMessagesOfBlankInputFields
                .stream()
                .allMatch(errMessage -> errMessage.getText()
                        .equals("Please, fill the required fields"));
    }

    public boolean checkErrorMessagesOfMoreSymbolsFilledInputFields() {
        return errorMessagesOfMoreSymbols
                .stream()
                .allMatch(errMessage -> errMessage.getText()
                        .equals("Symbols cant be more than 50"));
    }

    public String getErrorMessageOfExistedEmail() {
        return emailInvalidAndExistedErrorMessage.getText();
    }

    public boolean popupIsClosed() {
        return !popupWindow.isDisplayed();
    }
}
