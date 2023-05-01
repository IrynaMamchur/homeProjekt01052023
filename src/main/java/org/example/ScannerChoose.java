package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerChoose {
    public int isScannerChoose() {
        int choose = 0;
        try {
            System.out.println("Если Вы хотите снова произвести поиск по данному критерию-введите 1,");
            System.out.println("если Вы хотите выйти из данной категории с сохранением результата поиска - введите 2");
            System.out.println("если Вы хотите выйти из данной категории без сохранения результат поиска - введите 3");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isScannerChoose();
        }
        return choose;
    }

    public int isScanner(){
        int statusChoose = 0;
        try{Scanner scanner = new Scanner(System.in);
            statusChoose = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isScanner();}
        return statusChoose;
    }

    public String isScannerString() {
        String world = null;
        try {
            Scanner scanner = new Scanner(System.in);
            world = scanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Неправильно введен запрос, используйте при введении запроса только буквы");
            isScanner();
        }
        return world;
    }

}
