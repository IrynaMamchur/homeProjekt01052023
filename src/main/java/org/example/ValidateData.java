package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateData {
    private int dateOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    private static final int START_OF_YEAR = 1920;
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int LAST_DAY_OF_MONTH = 31;
    private static final int JANUARY = 1;
    private static final int DECEMBER = 12;

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {

        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    PrintInfo printInfo = new PrintInfo();

    public int scannerBathDay() {
        int dateOfBirth;
        try {
            Scanner scanner = new Scanner(System.in);
            dateOfBirth = scanner.nextInt();

        } catch (InputMismatchException e) {
            printInfo.printInfo(printInfo.takeInfo(2));
            return scannerBathDay();
        }
        return dateOfBirth;
    }

    public int validateDay(int dateOfBirth) {
        if (dateOfBirth < FIRST_DAY_OF_MONTH || dateOfBirth > LAST_DAY_OF_MONTH) {
            printInfo.printInfo(printInfo.takeInfo(3));
            return scannerBathDay();
        } else return dateOfBirth;
    }

    public int scannerBathMonth() {
        int monthOfBirth;
        try {
            Scanner scanner = new Scanner(System.in);
            monthOfBirth = scanner.nextInt();

        } catch (InputMismatchException e) {
            printInfo.printInfo(printInfo.takeInfo(2));
            return scannerBathMonth();
        }
        return monthOfBirth;
    }

    public int validateMonth(int monthOfBirth) {
        if (monthOfBirth < JANUARY || monthOfBirth > DECEMBER) {
            printInfo.printInfo(printInfo.takeInfo(5));
            return scannerBathMonth();
        } else return monthOfBirth;
    }

    public int scannerBathYear() {
        int yearOfBirth;
        try {
            Scanner scanner = new Scanner(System.in);
            yearOfBirth = scanner.nextInt();

        } catch (InputMismatchException e) {
            printInfo.printInfo(printInfo.takeInfo(2));
            return scannerBathYear();
        }
        return yearOfBirth;
    }


    public int validateYear(int yearOfBirth) {
        LocalDate localDate = LocalDate.now();
        int thisYear = localDate.getYear();
        if (yearOfBirth < START_OF_YEAR || yearOfBirth > thisYear) {
            printInfo.printInfo(printInfo.takeInfo(7));
            return scannerBathYear();
        } else return yearOfBirth;
    }
}




