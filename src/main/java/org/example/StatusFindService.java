package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class StatusFindService {
    PrintInfo printInfo = new PrintInfo();
    WriterCompany writerCompany = new WriterCompany();
    ScannerAll scannerAll = new ScannerAll();
    String fileName = "resources/findCompany.txt";
    String fileNameWriter = "resources/findCompany.txt";
    ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();


    public void statusFindService() throws IOException, FileNotFoundException {
        try {
            printInfo.printInfo(printInfo.takeInfo(35));
            printInfo.printInfo(printInfo.takeInfo(36));
            printInfo.printInfo(printInfo.takeInfo(37));
            List<Company> companies = readCompanyGenerator.readCompanies(fileName);
            int statusChoose = scannerAll.scannerNumber();
            filterStatusCompany(companies, statusChoose);
            int choose = scannerAll.scannerChoose();
            selectionOfActionsInThisCategory(companies, choose);
            FurtherActions furtherActions = new FurtherActions();
            int stepAgo = scannerAll.scannerFurtherActions();
            furtherActions.choiceFurtherActions(stepAgo);

        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            statusFindService();
        }
    }

    public List<Company> filterStatusCompany(List<Company> companies, int statusChoose) throws IOException {
        try {
            List<Company> answer = new ArrayList<>();
            switch (statusChoose) {
                case 1:
                    answer = companies.stream()
                            .filter(company -> company.getStatus().equals(TypeOfCompany.STATE))
                            .toList();
                    break;
                case 2:
                    answer = companies.stream()
                            .filter(company -> company.getStatus().equals(TypeOfCompany.COMMERCIAL))
                            .toList();
                    break;
                default:
                    printInfo.printInfo(printInfo.takeInfo(10));
                    ;
                    statusChoose = scannerAll.scannerNumber();
                    filterStatusCompany(companies, statusChoose);
            }
            writerCompany.writerCompany(answer, fileNameWriter);
            printInfo.printList(answer);
            if (answer.size() == 0) {
                printInfo.printInfo(printInfo.takeInfo(15));
                writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
            }
        } catch (InputMismatchException e) {
            printInfo.printInfo(printInfo.takeInfo(2));
            statusChoose = scannerAll.scannerNumber();
            filterStatusCompany(companies, statusChoose);
        }
        return companies;
    }

    public void selectionOfActionsInThisCategory(List<Company> companies, int choose) {
        try {
            switch (choose) {
                case 1:
                    writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
                    statusFindService();
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
