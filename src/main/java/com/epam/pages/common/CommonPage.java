package com.epam.pages.common;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class CommonPage extends BasePage {

    @FindBy(xpath = "//a[@href='#']")
    protected WebElement roleName;
    @FindBy(xpath = "//*[@class='topnav-right-side']//a")
    protected WebElement nameAndSurname;
    @FindBy(id = "show-btn")
    protected WebElement createButton;
    @FindBy(className = "list")
    protected List<WebElement> list;
    @FindBy(linkText = "Settings")
    protected WebElement settingsSection;

    public String getRoleName() {
        return roleName.getText();
    }

    public boolean checkRoleNameIsPresent() {
        return roleName.isDisplayed();
    }

    public String getNameAndSurname() {
        return nameAndSurname.getText();
    }

    public void clickOnCreateButton() {
        uiHelper.clickOnWebElement(createButton);
    }

    public boolean checkCreateButtonIsPresent() {
        return createButton.isDisplayed();
    }

    public boolean checkListIsEmpty() {
        return list.size() == 1;
    }

    public boolean checkSettingsSectionIsPresent() {
        return settingsSection.isDisplayed();
    }

    public void goToLoginPage() {
        driver.get("http://localhost:8082/");
    }
}
