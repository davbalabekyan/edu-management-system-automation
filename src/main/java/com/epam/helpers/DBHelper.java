package com.epam.helpers;

import com.epam.jdbc.service.serviceimpl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public final class DBHelper {

    private final UserServiceImpl userService = new UserServiceImpl();
    private final AdminServiceImpl adminService = new AdminServiceImpl();
    private final TeacherServiceImpl teacherService = new TeacherServiceImpl();
    private final StudentServiceImpl studentService = new StudentServiceImpl();
    private final ParentServiceImpl parentService = new ParentServiceImpl();
<<<<<<< HEAD

    private final AcademicClassesServiceImpl classesServiceImpl = new AcademicClassesServiceImpl();

=======
>>>>>>> 6404f16d240aaf9fab9529664ffe7e1fb48bb912
    private final AcademicYearsServiceImpl academicYearsService = new AcademicYearsServiceImpl();
    private final Logger logger = LoggerFactory.getLogger(DBHelper.class);


    public boolean isUserAddedInTheDB() {
        return userService.findUserByEmail(SharedTestData.getLastEmail()).getEmail() == null;
    }

    public boolean isAdminPasswordHashed() {
        logger.info("Check password is encrypted");
        return !adminService.findUserByEmail(SharedTestData.getLastEmail()).getPassword()
                .equals(SharedTestData.getLastGeneratedPassword());
    }

    public boolean isTeacherPasswordHashed() {
        logger.info("Check password is encrypted");
        return !teacherService.findUserByEmail(
                        SharedTestData.getLastEmail()).getPassword()
                .equals(SharedTestData.getLastGeneratedPassword());
    }

    public boolean isStudentPasswordHashed() {
        logger.info("Check password is encrypted");
        return !studentService.findUserByEmail(
                        SharedTestData.getLastEmail()).getPassword()
                .equals(SharedTestData.getLastGeneratedPassword());
    }

    public boolean isParentPasswordHashed() {
        logger.info("Check password is encrypted");
        return !parentService.findUserByEmail(
                        SharedTestData.getLastEmail()).getPassword()
                .equals(SharedTestData.getLastGeneratedPassword());
    }

    public boolean isAcademicYearAddedToTheDB(LocalDate start, LocalDate end) {
        logger.info("Get id of academic year from the DB.");
<<<<<<< HEAD
        return academicYearsService.findIDByStartAndEndDays(start, end) != -1;
    }

    public boolean isClassAddedToTheDB(String academicClass) {
        return classesServiceImpl.findIDByAcademicClass(academicClass) != -1;
=======
        return academicYearsService.getIDByStartAndEndDays(start, end) != -1;
>>>>>>> 6404f16d240aaf9fab9529664ffe7e1fb48bb912
    }
}
