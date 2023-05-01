package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AgeCalculation {
    private int dateOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private int age;

//    public AgeCalculation(int dateOfBirth, int monthOfBirth, int yearOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//        this.monthOfBirth = monthOfBirth;
//        this.yearOfBirth = yearOfBirth;
//    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int isAgeCalculation() throws IOException {
        try {
            dateOfBirth = isScannerBathDay();
            isBathDay(dateOfBirth);
            monthOfBirth = isScannerBathMonth();
            isBathMonth(monthOfBirth);
            yearOfBirth = isScannerBathYear();
            isBathYear(yearOfBirth);

            LocalDate localDate = LocalDate.now();
            LocalDate newDate = localDate.minusDays(dateOfBirth).minusMonths(monthOfBirth).minusYears(yearOfBirth);
            int age1 = newDate.getYear();
            System.out.println(age1);
            return age1;
        } finally {
        }
    }

    public int isScannerBathDay(){
    Scanner scanner = new Scanner(System.in);
            System.out.println("Введите день рождения");
    int dateOfBirth = scanner.nextInt();
    return dateOfBirth;
    }


    public int isBathDay(int dateOfBirth) {
        try {
            if (dateOfBirth < 1 || dateOfBirth > 31) {
                System.out.println("Вы ввели некорректную дату. Дата рождения не может быть меньше 1 или больше 31");
                return isScannerBathDay();
            } else return dateOfBirth;
        } catch (InputMismatchException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            return isScannerBathDay();
        }
    }
    public int isScannerBathMonth(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите месяц рождения");
        int monthOfBirth = scanner.nextInt();
        return monthOfBirth;
    }
    public int isBathMonth(int monthOfBirth) {
        try {
            if (monthOfBirth <= 0 || monthOfBirth > 12) {
                System.out.println("Вы ввели некорректный месяц. Месяц не может быть меньше 1 или больше 12");
                return isScannerBathMonth();
            } else return monthOfBirth;
        } catch (InputMismatchException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            return isScannerBathMonth();
        }
    }


    public int isScannerBathYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год рождения");
        int yearOfBirth = scanner.nextInt();
        return yearOfBirth;
    }

    public int isBathYear(int yearOfBirth) {
        try {
            LocalDate localDate = LocalDate.now();
            int thisYear = localDate.getYear();
            if (yearOfBirth < 1920 || yearOfBirth > thisYear) {
                System.out.println("Вы ввели некорректный год. Год не может быть меньше 1920, а также не может  быть больше текущего года");
                return isScannerBathYear();
            } else return yearOfBirth;
        } catch (InputMismatchException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            return isScannerBathYear();
        }
    }

}
