package org.example;

import java.io.*;
import java.util.InputMismatchException;
import java.util.List;


public class LineOfBusinessFindService {
    PrintInfo printInfo = new PrintInfo();
    WriterCompany writerCompany = new WriterCompany();
    ScannerAll scannerAll = new ScannerAll();
    String fileNameWriter = "resources/findCompany.txt";
    String fileName = "resources/findCompany.txt";

    ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();

    public void lineOfBusinessFindService() throws IOException, FileNotFoundException {

        try {
            printInfo.printInfo(printInfo.takeInfo(16));
            printInfo.printInfo(printInfo.takeInfo(17));
            printInfo.printInfo(printInfo.takeInfo(18));
            printInfo.printInfo(printInfo.takeInfo(19));
            List<Company> companies = readCompanyGenerator.readCompanies(fileName);
            String world = scannerAll.scannerString();
            filterLineOfBusinessCompany(companies, world);
            int choose = scannerAll.scannerChoose();
            selectionOfActionsInThisCategory(companies, choose);
            FurtherActions furtherActions = new FurtherActions();
            int stepAgo = scannerAll.scannerFurtherActions();
            furtherActions.choiceFurtherActions(stepAgo);

        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            lineOfBusinessFindService();

        }
    }

    public List<Company> filterLineOfBusinessCompany(List<Company> companies, String world) throws IOException {

        try {
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
            writerCompany.writerCompany(answer, fileNameWriter);
            printInfo.printList(answer);
            if (answer.size() == 0) {
                printInfo.printInfo(printInfo.takeInfo(15));
                writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
            }

        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            world = scannerAll.scannerString();
            filterLineOfBusinessCompany(companies, world);
        }
        return companies;
    }

    public void selectionOfActionsInThisCategory(List<Company> companies, int choose) {
        try {
            switch (choose) {
                case 1:
                    writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
                    lineOfBusinessFindService();
                    break;
                case 2:
                    break;
                case 3:
                    writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
                    break;
                default:
                    printInfo.printInfo(printInfo.takeInfo(10));
                    choose = scannerAll.scannerChoose();
                    selectionOfActionsInThisCategory(companies, choose);
            }
        } catch (InputMismatchException | IOException e) {
            printInfo.printInfo(printInfo.takeInfo(10));
            choose = scannerAll.scannerChoose();
            selectionOfActionsInThisCategory(companies, choose);
        }
    }

}
