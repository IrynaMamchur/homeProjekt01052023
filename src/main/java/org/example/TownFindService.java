package org.example;

import java.io.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class TownFindService {

    public void isTownFindService() throws IOException, FileNotFoundException {

        try {
            ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();
            ScannerChoose scannerChoose = new ScannerChoose();
            System.out.println("Отбор по месту нахождения компании");
            System.out.println("Введите название города");
            FurtherActions furtherActions = new FurtherActions();
            String world =scannerChoose.isScannerString();
            List<Company> companies = readCompanyGenerator.isReadAllCompanies();
            isFindTownCompany(companies, world);
            int choose = scannerChoose.isScannerChoose();
            isChoose(companies, choose);
            furtherActions.isFurtherActions();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }




    public List<Company> isFindTownCompany(List<Company> companies, String world) throws IOException {
        try {
            WriterCompany writerCompany = new WriterCompany();
            String town = world.toUpperCase();

            List<Company> answer = companies.stream()
                    .filter(company -> company.getLocationCity().equals(town))
                    .toList();
            writerCompany.isWriterCompany(answer);
            if (answer.size() == 0) {
                System.out.println("По заданному поиску компаний не найдено");
                writerCompany.isWriterCompanyIfEmpty(companies);
            }

            System.out.println("-------------------------------------------------------------------------------");
        } catch ( IOException e) {
            System.out.println("Неизвестная ошибка");
            isFindTownCompany(companies, world);
        }
        return companies;
    }


    public void isChoose(List<Company> companies, int choose) {
        try {
            WriterCompany writerCompany = new WriterCompany();
            ScannerChoose scannerChoose = new ScannerChoose();
            if (choose == 1) {
                writerCompany.isWriterCompanyIfEmpty(companies);
                isTownFindService();
               choose = scannerChoose.isScannerChoose();
               isChoose(companies, choose);
            }    if (choose ==3){
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isChoose(companies, choose);
        }
    }

}

