package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintInfo {
    public int print;
    public List<String> result;

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public int getPrint(int print) {
        return print;
    }

    public void setPrint(int print) {
        this.print = print;
    }

    public List<String> takeInfo(int print) {
        List<String> result = new ArrayList<>();
        switch (print) {
            case 1 -> result.add("Введите день рождения");
            case 2 -> result.add("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            case 3 -> result.add("Вы ввели некорректную дату. Дата рождения не может быть меньше 1 или больше 31");
            case 4 -> result.add("Введите месяц рождения");
            case 5 -> result.add("Вы ввели некорректный месяц. Месяц не может быть меньше 1 или больше 12");
            case 6 -> result.add("Введите год рождения");
            case 7 ->
                    result.add("Вы ввели некорректный год. Год не может быть меньше 1920, а также не может  быть больше текущего года");
            case 8 -> result.add("Неизвестная ошибка");
            case 9 -> result.add("-------------------------------------------------------------------------------");
            case 10 -> result.add("Вы ввели некорректную цифру, повторите, пожалуйста, Ваш выбор");
            case 11 -> result.add("Спасибо, что воспользовались нашим приложением");
            case 12 -> result.add("Если Вы хотите продолжить отбор по другим критериям - введите 1");
            case 13 -> result.add("если вернуться к началу поиска - введите 2,");
            case 14 -> result.add("если выйти из приложения - введите 0.");
            case 15 -> result.add("По заданному поиску компаний не найдено");
            case 16 -> result.add("Отбор по сфере деятельности компании");
            case 17 -> result.add("Укажите поисковые слова деятельности компании, такие как: ");
            case 18 ->
                    result.add("'дети', 'детское', 'для детей', 'языковые', 'язык', 'английский', 'искусство', 'изобразительное', 'рисование', ");
            case 19 -> result.add("'йога', 'спорт', 'прыжки', 'парашют', 'вождения', 'вождение'");
            case 20 -> result.add("Если Вы хотите снова произвести поиск по данному критерию-введите 1,");
            case 21 ->
                    result.add("если Вы хотите выйти из данной категории с сохранением результата поиска - введите 2");
            case 22 ->
                    result.add("если Вы хотите выйти из данной категории без сохранения результат поиска - введите 3");
            case 23 -> result.add("Неправильно введен запрос, используйте при введении запроса только буквы");
            case 24 -> result.add("Выбор по половому признаку");
            case 25 -> result.add("Если Вам нужны компании:");
            case 26 -> result.add(" для лиц только мужского пола - введите 1,");
            case 27 -> result.add(" для лиц только женского пола - введите 2,");
            case 28 -> result.add(" для всех лиц - введите 3.");
            case 29 -> result.add("Если Вы хотите произвести отбор по месту нахождению компании, введите 1; ");
            case 30 -> result.add("Если Вы хотите произвести отбор по форме собственности компании, введите 2; ");
            case 31 -> result.add("Если Вы хотите произвести отбор по половому признаку, введите 3; ");
            case 32 -> result.add("Если Вы хотите произвести отбор по сфере деятельности компании, введите 4; ");
            case 33 -> result.add("Если Вы хотите произвести отбор по форме работы компании, введите 5; ");
            case 34 -> result.add("Если Вы хотите выйти из приложения, введите 0; ");
            case 35 -> result.add("Выбор по форме собственности компании");
            case 36 -> result.add("Если Вас интересуют государственные учреждения - введите 1,");
            case 37 -> result.add(" если коммерческие - введите 2.");
            case 38 -> result.add("Отбор по месту нахождения компании");
            case 39 -> result.add("Введите название города");
            case 40 -> result.add("Выбор по форме работы компании");
            case 41 -> result.add("Если Вас интересуют компании, которые работают только ОН-ЛАЙН,введите 1,");
            case 42 -> result.add("если компании, которые работают только ОФФ-ЛАЙН,введите 2,");
            case 43 -> result.add("ecли компании, которые работают, как ОН-ЛАЙН, так и ОФФ-ЛАЙН, введите 3.");
            default -> result.add("");
        }
        return result;
    }


    public void printInfo(List<String> result) {
        System.out.println(result);
    }


    public void printList(List<Company> answer) {
        for (Company company : answer) {
            System.out.println(company);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "PrintInfo{" +
                "result=" + result +
                '}';
    }
}
