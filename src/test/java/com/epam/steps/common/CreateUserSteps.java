package com.epam.steps.common;

import com.epam.pages.main.SuperAdminPage;
import com.epam.pages.popup.CreatePopup;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserSteps {

    private SuperAdminPage superAdminPage;
    private CreatePopup createPopup;

    @Before
    public void initPages() {
        superAdminPage = new SuperAdminPage();
        createPopup = new CreatePopup();
    }

    @Given("Fill in name fill more than 50 symbols")
    public void fillInNameFillMoreThanSymbols() {
        createPopup.fillNameWithMoreSymbols();
    }

    @Given("Fill invalid email")
    public void fillInvalidEmail() {
        createPopup.fillInvalidEmail();
    }

    @Given("Fill all fields but email")
    public void fillFieldsButEmail() {
        createPopup.fillAllFieldsBesidesEmail();
    }

    @When("Fill existed email")
    public void fillExistedEmail() {
        createPopup.fillExistedEmail();
    }

    @And("Fill name {}")
    public void fillName(String name) {
        createPopup.fillName(name);
    }

    @And("Fill surname {}")
    public void fillSurname(String surname) {
        createPopup.fillSurname(surname);
    }

    @And("Fill email {}")
    public void fillEmail(String email) {
        createPopup.fillEmail(email);
    }

    @And("Click on 'Generate password' button")
    public void clickOnGeneratePasswordButton() {
        createPopup.clickOnGeneratePasswordButton();
    }

    @And("Click on 'Save' button")
    public void clickOnSaveButton() {
        createPopup.clickOnSaveButton();
    }

    @When("Click on 'X' button")
    public void clickOnXButton() {
        createPopup.clickOnXButton();
    }

    @And("Popup is closed")
    public void checkPopupIsClosed() {
        assertThat(createPopup.popupIsClosed())
                .isTrue();
    }

    @And("Double click on 'Generate password' button")
    public void doubleClickOnGeneratePasswordButton() {
        createPopup.doubleClickOnGeneratePasswordButton();
    }

    @And("Fill in surname fill more than 50 sybmols")
    public void fillInSurnameFillMoreThanSybmols() {
        createPopup.fillSurnameWithMoreSymbols();
    }

    @And("Fill in email fill more than 50 sybmols")
    public void fillInEmailFillMoreThanSybmols() {
        createPopup.fillEmailWithMoreSymbols();
    }

    @Then("Password is changed")
    public void passwordIsChanged() {
        assertThat(createPopup.passwordIsChanged())
                .isTrue();
    }

    @Then("Click on 'create' button and open popup")
    public void clickOnCreateButtonAndOpenPopup() {
        superAdminPage.clickOnCreateButton();
    }

    @Then("Check all input fields are empty in create popup")
    public void checkAllInputFieldsAreEmptyInCreatePopup() {
        assertThat(createPopup.checkAllInputFieldsAreEmpty()).isTrue();
    }

    @Then("Check all fields are present in create popup")
    public void checkAllFieldsArePresentInCreatePopup() {
        assertThat(createPopup.checkAllFieldsArePresent())
                .isTrue();
    }

    @Then("'Password' field is filled with autogenerated password")
    public void passwordFieldIsFilledWithAutogeneratedPassword() {
        assertThat(createPopup.checkGeneratedPasswordIsFilled())
                .isTrue();
    }

    @Then("Check error messages of more symbols filled input fields")
    public void checkErrorMessagesOfMoreSymbolsFilledInputFields() {
        assertThat(createPopup.checkErrorMessagesOfMoreSymbolsFilledInputFields())
                .isTrue();
    }

    @Then("Check invalid email error message")
    public void checkInvalidErrorMessage() {
        assertThat(createPopup.getInvalidEmailErrorMessage())
                .isEqualTo("Email is invalid");
    }

    @Then("Check error messages of blank input fields")
    public void checkErrorMessagesOfBlankInputFields() {
        assertThat(createPopup.checkErrorMessagesOfBlankInputFields())
                .isTrue();
    }

    @Then("Check the structure of generated password")
    public void checkTheStructureOfGeneratedPassword() {
        assertThat(createPopup.checkGeneratedPasswordStructure())
                .isTrue();
    }

    @Then("Check error message of existed email")
    public void checkErrorMessageOfExistedEmail() {
        assertThat(createPopup.getErrorMessageOfExistedEmail())
                .isEqualTo("A user with the specified email already exists");
    }
}
