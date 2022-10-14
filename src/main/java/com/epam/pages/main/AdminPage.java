package com.epam.pages.main;

import com.epam.helpers.SharedTestData;
import com.epam.jdbc.service.StudentService;
import com.epam.jdbc.service.TeacherService;
import com.epam.pages.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminPage extends CommonPage {
    private final TeacherService teacherService = new TeacherService();
    private final StudentService studentService = new StudentService();

    public boolean checkAllElementsArePresent() {
        logger.info("Check elements: list, role name, name and surname," +
                " sections, settings and create button are present");
        return uiHelper.checkElementsAreDisplayed(
                list,
                roleName,
                nameAndSurname,
                getSectionElementByName("teachers"),
                getSectionElementByName("students"),
                getSectionElementByName("parents"),
                getSectionElementByName("classes"),
                getSectionElementByName("years"),
                getSectionElementByName("subjects"),
                getSectionElementByName("vacations"),
                settingsSection,
                createButton
        );
    }

    public boolean checkUIofStudentsSection() {
        logger.info("Check elements are displayed in students section - list, create button");
        return uiHelper.checkElementsAreDisplayed(
                list,
                createButton
        );
    }

    private WebElement getSectionElementByName(String section) {
        logger.info("Get {} section", section);
        return driver.findElement(By.xpath(String.format("//a[@href='/%s']", section)));
    }

    public boolean checkNewUserIsDisplayedOnAdminsSection() {
        logger.info("Check new user is displayed");
        return getNameOfLastCreatedUser()
                .equals(SharedTestData.getNameField())
                && getSurnameOfLastCreatedUser()
                .equals(SharedTestData.getSurnameField());
    }

    public boolean checkTeacherIsNotAddedInTheDB() {
        return teacherService.findByEmail(SharedTestData.getLastGeneratedEmail()).getEmail() == null;
    }

    public boolean checkStudentIsNotAddedInTheDB() {
        return studentService.findByEmail(SharedTestData.getLastGeneratedEmail()).getEmail() == null;
    }

    public void selectSection(String section) {
        uiHelper.clickOnWebElement(getSectionElementByName(section));
    }

    public boolean passwordIsHashed() {
        logger.info("Check that password is hashed");
        return !teacherService.findByEmail(
                        SharedTestData.getLastGeneratedEmail())
                .getPassword()
                .equals(SharedTestData.getLastGeneratedPassword());
    }

}
