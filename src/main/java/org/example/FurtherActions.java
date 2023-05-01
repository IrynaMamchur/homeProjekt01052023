package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FurtherActions {
    public void isFurtherActions() {
        try {
            int stepAgo = isScanner();
            Finish finish = new Finish();
            Start start = new Start();
            switch (stepAgo) {
                case 1:
                    start.isSearchEngine();
                case 2:
                    start.isStart();
                    break;
                case 0:
                    finish.isFinish();
                    break;
                default:
                    System.out.println("Вы ввели некорректную цифру, повторите, пожалуйста, Ваш выбор");
                    isFurtherActions();
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Неправильно введена цифра. Введите, пожалуйста, цифровое значение из указанного выше списка");
            isFurtherActions();
        }

    }

    public int isScanner() {
        System.out.println("Если Вы хотите продолжить отбор по другим критериям - введите 1,");
        System.out.println("если вернуться к началу поиска - введите 2,");
        System.out.println("если выйти из приложения - введите 0.");
        Scanner scanner = new Scanner(System.in);
        int stepAgo = scanner.nextInt();
        return stepAgo;
    }
}
