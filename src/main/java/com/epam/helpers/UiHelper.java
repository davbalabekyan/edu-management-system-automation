package com.epam.helpers;

import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class UiHelper {

    private final WaitHelper waitHelper = new WaitHelper();

    public void clickOnWebElement(final WebElement target) {
        waitHelper.waitElementToBeClickable(target);
        target.click();
    }

    public void sendKeys(final WebElement target, final String text) {
        waitHelper.waitElementToBeVisible(target);
        target.sendKeys(text);
    }

    public boolean checkElementsAreDisplayed(WebElement... elements) {
        return Arrays.stream(elements).allMatch(WebElement::isDisplayed);
    }

    public boolean checkElementsAreEmpty(WebElement... elements) {
        return Arrays.stream(elements).allMatch(element -> element.getText().isEmpty());
    }

    public boolean checkElementsAreDisplayed(List<WebElement> list, WebElement... elements) {
        return !list.isEmpty()
                && list.stream().allMatch(WebElement::isDisplayed)
                && Arrays.stream(elements).allMatch(WebElement::isDisplayed);
    }
}
