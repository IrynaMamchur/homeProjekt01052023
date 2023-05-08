package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class WorkingModeFindService {
    PrintInfo printInfo = new PrintInfo();
    ScannerAll scannerAll = new ScannerAll();
    WriterCompany writerCompany = new WriterCompany();
    String fileName = "resources/findCompany.txt";
    String fileNameWriter = "resources/findCompany.txt";
    ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();


    public void workingModeFindService() throws IOException, FileNotFoundException {
        try {
            printInfo.printInfo(printInfo.takeInfo(40));
            printInfo.printInfo(printInfo.takeInfo(41));
            printInfo.printInfo(printInfo.takeInfo(42));
            printInfo.printInfo(printInfo.takeInfo(43));
            List<Company> companies = readCompanyGenerator.readCompanies(fileName);
            int statusChoose = scannerAll.scannerNumber();
            filterWorkingMode(companies, statusChoose);
            int choose = scannerAll.scannerChoose();
            selectionOfActionsInThisCategory(companies, choose);
            FurtherActions furtherActions = new FurtherActions();
            int stepAgo = scannerAll.scannerFurtherActions();
            furtherActions.choiceFurtherActions(stepAgo);
        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            workingModeFindService();
        }
    }

    public List<Company> filterWorkingMode(List<Company> companies, int statusChoose) throws IOException {
        try {
            List<Company> answer = new ArrayList<>();
            switch (statusChoose) {
                case 1:
                    answer = companies.stream()
                            .filter(company -> company.getWorkingMode().equals(WorkingMode.ON_LINE))
                            .toList();
                    break;
                case 2:
                    answer = companies.stream()
                            .filter(company -> company.getWorkingMode().equals(WorkingMode.OFF_LINE))
                            .toList();
                    break;
                case 3:
                    answer = companies.stream()
                            .filter(company -> company.getWorkingMode().equals(WorkingMode.ON_OFF_LINE))
                            .toList();
                    break;
                default:
                    printInfo.printInfo(printInfo.takeInfo(10));
                    statusChoose = scannerAll.scannerNumber();
                    filterWorkingMode(companies, statusChoose);
            }
            writerCompany.writerCompany(answer, fileNameWriter);
            printInfo.printList(answer);
            if (answer.size() == 0) {
                printInfo.printInfo(printInfo.takeInfo(15));
                writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
            }

        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            statusChoose = scannerAll.scannerNumber();
            filterWorkingMode(companies, statusChoose);
        }
        return companies;
    }


    public void selectionOfActionsInThisCategory(List<Company> companies, int choose) {
        try {
            switch (choose) {
                case 1:
                    writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
                    workingModeFindService();
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

