package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {

    public void isStart() throws IOException {
        try {
            AgeCalculation ageCalculation = new AgeCalculation();
            int age = ageCalculation.isAgeCalculation();
            AgeCompanyGenerator ageCompanyGenerator = new AgeCompanyGenerator();
            ageCompanyGenerator.isAgeCompanyGenerator(age);
           isSearchEngine();
        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }

    public void isSearchEngine() throws IOException {
        try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Если Вы хотите произвести отбор по месту нахождению компании, введите 1; ");
        System.out.println("Если Вы хотите произвести отбор по форме собственности компании, введите 2; ");
        System.out.println("Если Вы хотите произвести отбор по половому признаку, введите 3; ");
        System.out.println("Если Вы хотите произвести отбор по сфере деятельности компании, введите 4; ");
        System.out.println("Если Вы хотите произвести отбор по форме работы компании, введите 5; ");
        System.out.println("Если Вы хотите выйти из приложения, введите 0; ");

        int choose = scanner.nextInt();
        LineOfBusinessFindService lineOfBusinessFindService = new LineOfBusinessFindService();
        StatusFindService statusFindService = new StatusFindService();
        TownFindService townFindService = new TownFindService();
        WorkingModeFindService workingModeFindService = new WorkingModeFindService();
        Finish finish = new Finish();
        SexFindService sexFindService = new SexFindService();
            switch (choose) {
                case 1 -> townFindService.isTownFindService();
                case 2 -> statusFindService.isStatusFindService();
                case 3 -> sexFindService.isSexFindService();
                case 4 -> lineOfBusinessFindService.isLineOfBusinessFindService();
                case 5 -> workingModeFindService.isWorkingModeFindService();
                case 0 -> finish.isFinish();
                default -> {
                    System.out.println("Вы ввели некорректную цифру, повторите, пожалуйста, Ваш выбор");
                    isSearchEngine();
                }
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isSearchEngine();
        }
    }

}
