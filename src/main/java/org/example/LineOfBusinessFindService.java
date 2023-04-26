package org.example;

import java.io.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class LineOfBusinessFindService {


    public void isLineOfBusinessFindService() throws IOException, FileNotFoundException {

        try {
            LineOfBusinessFindService lineOfBusinessFindService= new LineOfBusinessFindService();
            ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();
            ScannerChoose scannerChoose = new ScannerChoose();
            System.out.println("Отбор по сфере деятельности компании");
            System.out.println("Укажите поисковые слова деятельности компании, такие как: ");
            System.out.println("'дети', 'детское', 'для детей', 'языковые', 'язык', 'английский', 'искусство', 'изобразительное', 'рисование', ");
            System.out.println("'йога', 'спорт', 'прыжки', 'парашют', 'вождения', 'вождение'");
            FurtherActions furtherActions = new FurtherActions();
            List<Company> companies = readCompanyGenerator.isReadAllCompanies();
            String world = scannerChoose.isScannerString();
            lineOfBusinessFindService.isFindLineOfBusinessCompany(companies, world);
            int choose = scannerChoose.isScannerChoose();
            lineOfBusinessFindService.isChoose(companies, choose);
            furtherActions.isFurtherActions();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isLineOfBusinessFindService();

        }
    }




    public List<Company> isFindLineOfBusinessCompany(List<Company> companies, String world) throws IOException {

        try {
            WriterCompany writerCompany = new WriterCompany();
            String line = world.toLowerCase();
            String business = null;
            switch (line) {
                case "дети", "детское", "для детей" -> business = "детское_развитие";
                case "языковые", "язык", "английский" -> business = "языковые_курсы";
                case "искусство", "изобразительное", "рисование" -> business = "изобразительное_искусство";
                case "вождения", "вождение" -> business = "курсы_вождения";
                case "спорт", "прыжки", "парашют" -> business = "прыжки_с_парашютом";
                case "йога" -> business = "йога";
            }
            String finalBusiness = business;
            List<Company> answer = companies.stream()
                    .filter(company -> company.getLineOfBusiness().equals(finalBusiness))
                    .toList();
            writerCompany.isWriterCompany(answer);
            if (answer.size() == 0) {
                System.out.println("По заданному поиску компаний не найдено");
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
            System.out.println("-------------------------------------------------------------------------------");


        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isFindLineOfBusinessCompany(companies, world);
        }
        return companies;
    }


    public void isChoose(List<Company> companies, int choose) {
        try {
            WriterCompany writerCompany = new WriterCompany();
            ScannerChoose scannerChoose = new ScannerChoose();
            if (choose == 1) {
                writerCompany.isWriterCompanyIfEmpty(companies);
                isLineOfBusinessFindService();
//                choose = scannerChoose.isScannerChoose();
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
