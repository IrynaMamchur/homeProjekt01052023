package org.example;

import java.io.IOException;
import java.time.LocalDate;

public class AgeCalculation {

    PrintInfo printInfo = new PrintInfo();
    ValidateData validateData = new ValidateData();

    public int ageCalculation() throws IOException {
        printInfo.printInfo(printInfo.takeInfo(1));
        int dateOfBirth = validateData.validateDay(validateData.scannerBathDay());
        printInfo.printInfo(printInfo.takeInfo(4));
        int monthOfBirth = validateData.validateMonth(validateData.scannerBathMonth());
        printInfo.printInfo(printInfo.takeInfo(6));
        int yearOfBirth = validateData.validateYear(validateData.scannerBathYear());
        LocalDate localDate = LocalDate.now();
        LocalDate newDate = localDate.minusDays(dateOfBirth).minusMonths(monthOfBirth).minusYears(yearOfBirth);
        int age = newDate.getYear();
        return age;
    }
}
