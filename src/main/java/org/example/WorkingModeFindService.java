package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class WorkingModeFindService {

    public void isWorkingModeFindService() throws IOException, FileNotFoundException {
        try {
            ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();
            ScannerChoose scannerChoose = new ScannerChoose();
            System.out.println("Выбор по форме работы компании");
            System.out.println("Если Вас интересуют компании, которые работают только ОН-ЛАЙН,введите 1,");
            System.out.println("если компании, которые работают только ОФФ-ЛАЙН,введите 2,");
            System.out.println("ecли компании, которые работают, как ОН-ЛАЙН, так и ОФФ-ЛАЙН, введите 3.");
            FurtherActions furtherActions = new FurtherActions();
            List<Company> companies = readCompanyGenerator.isReadAllCompanies();
            int statusChoose = scannerChoose.isScanner();
            isFindWorkingMode(companies, statusChoose);
            int choose = scannerChoose.isScannerChoose();
            isChoose(companies, choose);
            furtherActions.isFurtherActions();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }



    public List<Company> isFindWorkingMode(List<Company> companies, int statusChoose) throws IOException {
        try {
            WriterCompany writerCompany = new WriterCompany();
            ScannerChoose scannerChoose = new ScannerChoose();
            List<Company> answer = new ArrayList<>();
            if (statusChoose == 1) {
                answer = companies.stream()
                        .filter(company -> company.getWorkingMode().equals(WorkingMode.ON_LINE))
                        .toList();
            } else if (statusChoose == 2) {
                answer = companies.stream()
                        .filter(company -> company.getWorkingMode().equals(WorkingMode.OFF_LINE))
                        .toList();
            } else if (statusChoose == 3) {
                answer = companies.stream()
                        .filter(company -> company.getWorkingMode().equals(WorkingMode.ON_OFF_LINE))
                        .toList();
            } else {
                System.out.println("Вы ввели некорректную цифру, повторите, пожалуйста, Ваш выбор");
                statusChoose = scannerChoose.isScanner();
                isFindWorkingMode(companies, statusChoose);
            }
            writerCompany.isWriterCompany(answer);

            if (answer.size() == 0) {
                System.out.println("По заданному поиску компаний не найдено");
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
            System.out.println("-------------------------------------------------------------------------------");

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isFindWorkingMode(companies, statusChoose);
        }
        return companies;
    }


    public void isChoose(List<Company> companies, int choose) {
        try {
            WriterCompany writerCompany = new WriterCompany();
            ScannerChoose scannerChoose = new ScannerChoose();
            if (choose == 1) {
                writerCompany.isWriterCompanyIfEmpty(companies);
                isWorkingModeFindService();
//                int statusChoose = scannerChoose.isScanner();
//                isFindWorkingMode(companies, statusChoose);
//                choose = scannerChoose.isScannerChoose();
//                isChoose(companies, choose);
            }    if (choose ==3){
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isChoose(companies, choose);
        }
    }
}

