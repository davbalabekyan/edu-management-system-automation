package com.epam.pages.popup;

import com.epam.helpers.ErrorMessagesProvider;
import com.epam.helpers.SharedTestData;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AcademicClassPopup extends CreatePopup {

    @FindBy(xpath = "//div[@class='list-items']/a")
    protected List<WebElement> listItems;
    @FindBy(id = "classNumber")
    private WebElement classNumber;
    @FindBy(xpath = "//input/following-sibling::div[@class='error']")
    protected WebElement errorMessagesOfExistedClass;
    @FindBy(tagName = "h1")
    private WebElement title;

    public boolean checkUIOfCreatePopupClassesSection() {
        logger.info("Check UI of create popup in academic classes section");
        return uiHelper.checkElementsAreDisplayed(
                classNumber,
                xButton,
                saveButton,
                title
        );
    }

    public void fillExistedAcademicClass() {
        /////// Get existed academic class from data provider
        logger.info("Fill existed academic class from list.");
        if (this.listItems.isEmpty()) {
            logger.error("No elements in the list, please create one class and return");
        } else {
            uiHelper.sendKeys(classNumber, listItems.get(0).getText());
        }
    }

    public boolean checkExistedClassErrorMessage() {
        logger.info("Get error message of existed class");
        return errorMessagesOfExistedClass.getText()
                .equals(ErrorMessagesProvider.getExistedAcademicClassErrMessage());
    }

    public void fillAcademicClass() {
        String generateClass = RandomStringUtils.random(10,true,true);
        logger.info("Fill academic class with value - {}", generateClass);
        uiHelper.sendKeys(classNumber, generateClass);
    }

    public void saveAcademicClassValue() {
        SharedTestData.setAcademicClass(classNumber.getDomProperty("value"));
    }

    public boolean checkAcademicClassIsDisplayedInTheList() {
        logger.info("Get last created academic class and check if it is added to the list");
        return (listItems.get(listItems.size() - 1).getText())
                .equals(SharedTestData.getAcademicClass());
    }
}
