package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;




public class SexFindService {

    public void isSexFindService() throws IOException, FileNotFoundException {

        try {
            ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();
            ScannerChoose scannerChoose = new ScannerChoose();
            FurtherActions furtherActions = new FurtherActions();
            System.out.println("Выбор по половому признаку");
            System.out.println("Если Вам нужны компании:");
            System.out.println(" для лиц только мужского пола - введите 1,");
            System.out.println(" для лиц только женского пола - введите 2,");
            System.out.println(" для всех лиц - введите 3.");
            List<Company> companies = readCompanyGenerator.isReadAllCompanies();
            int  statusChoose =scannerChoose.isScanner();
            isFindSexCompany(companies, statusChoose);
            int choose = scannerChoose.isScannerChoose();
            isChoose(companies, choose);
            furtherActions.isFurtherActions();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }



    public List<Company> isFindSexCompany(List<Company> companies, int statusChoose) throws IOException {

        try {
            WriterCompany writerCompany = new WriterCompany();
            ScannerChoose scannerChoose = new ScannerChoose();
            List<Company> answer = new ArrayList<>();
            if (statusChoose == 1) {
                answer = companies.stream()
                        .filter(company -> company.getSex().equals(Sex.MALE))
                        .toList();
            } else if (statusChoose == 2) {
                answer = companies.stream()
                        .filter(company -> company.getSex().equals(Sex.FEMALE))
                        .toList();
            } else if (statusChoose == 3) {
                answer = companies.stream()
                        .filter(company -> company.getSex().equals(Sex.ALL))
                        .toList();
            } else {
                System.out.println("Вы ввели некорректную цифру, повторите, пожалуйста, Ваш выбор");
                statusChoose =scannerChoose.isScanner();
                isFindSexCompany(companies, statusChoose);
            }
            writerCompany.isWriterCompany(answer);

            if (answer.size() == 0) {
                System.out.println("По заданному поиску компаний не найдено");
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
            System.out.println("-------------------------------------------------------------------------------");

        } catch (InputMismatchException | IOException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isFindSexCompany(companies, statusChoose);
        }
        return companies;
    }

    public void isChoose(List<Company> companies, int choose) {
        try {
            WriterCompany writerCompany = new WriterCompany();
            ScannerChoose scannerChoose = new ScannerChoose();
            if (choose == 1) {
                writerCompany.isWriterCompanyIfEmpty(companies);
                isSexFindService();
//                choose =  scannerChoose.isScannerChoose();
//                isChoose(companies, choose);
            }    if (choose ==3){
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isChoose(companies, choose);
        }
    }

}
