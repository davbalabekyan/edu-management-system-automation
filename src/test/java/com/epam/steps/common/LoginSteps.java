package com.epam.steps.common;

import com.epam.pages.main.AdminPage;
import com.epam.pages.main.LoginPage;
import com.epam.steps.BaseSteps;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends BaseSteps {

    private LoginPage loginPage;
    private AdminPage adminPage;

    @BeforeAll
    public static void setupDriver() {
        setup();
    }

    @Before
    public void initPages() {
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        loginPage.goToPage();
    }

    @Given("Enter email {} in login page")
    public void fillEmailInLoginPage(String email) {
        loginPage.fillEmail(email);
    }

    @And("Enter password {} in login page")
    public void fillPasswordInLoginPage(String password) {
        loginPage.fillPassword(password);
    }

    @And("Click on 'login' button")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("The user is on {} page")
    public void theUserIsOnRequestedPage(String roleName) {
        assertThat(roleName).isEqualToIgnoringCase(adminPage.getRoleName());
    }

    @AfterAll
    public static void tearDown() {
        quitDriver();
    }
}
