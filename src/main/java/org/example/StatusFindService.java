package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class StatusFindService {
    public void isStatusFindService() throws IOException, FileNotFoundException {

        try {
            ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();
            ScannerChoose scannerChoose = new ScannerChoose();
            FurtherActions furtherActions = new FurtherActions();
            System.out.println("Выбор по форме собственности компании");
            System.out.println("Если Вас интересуют государственные учреждения - введите 1,");
            System.out.println(" если коммерческие - введите 2.");
            List<Company> companies = readCompanyGenerator.isReadAllCompanies();
            int statusChoose =scannerChoose.isScanner();
            isFindStatusCompany(companies, statusChoose);
            int choose = scannerChoose.isScannerChoose();
            isChoose(companies,choose);
            furtherActions.isFurtherActions();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }

    public List<Company> isFindStatusCompany(List<Company> companies, int statusChoose) throws IOException {
        try {
            WriterCompany writerCompany = new WriterCompany();
            ScannerChoose scannerChoose = new ScannerChoose();
            List<Company> answer = new ArrayList<>();
            if (statusChoose == 1) {
                answer = companies.stream()
                        .filter(company -> company.getStatus().equals(TypeOfCompany.STATE))
                        .toList();
            } else if (statusChoose == 2) {
                answer = companies.stream()
                        .filter(company -> company.getStatus().equals(TypeOfCompany.COMMERCIAL))
                        .toList();
            } else {
                System.out.println("Вы ввели некорректную цифру, повторите, пожалуйста, Ваш выбор");
                statusChoose = scannerChoose.isScanner();
                isFindStatusCompany(companies, statusChoose);
            }
            writerCompany.isWriterCompany(answer);
            if (answer.size() == 0) {
                System.out.println("По заданному поиску компаний не найдено");
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
            System.out.println("-------------------------------------------------------------------------------");
        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isFindStatusCompany(companies,statusChoose);
        }
        return companies;
    }

    public void isChoose(List<Company> companies, int choose) {
        try {
            WriterCompany writerCompany = new WriterCompany();
            ScannerChoose scannerChoose = new ScannerChoose();
            if (choose == 1) {
                writerCompany.isWriterCompanyIfEmpty(companies);
                isStatusFindService();
            }
            if (choose ==3){
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Неизвестная ошибка");
            isChoose(companies, choose);
        }
    }

}
