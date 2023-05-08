package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class SexFindService {
    PrintInfo printInfo = new PrintInfo();
    ScannerAll scannerAll = new ScannerAll();
    WriterCompany writerCompany = new WriterCompany();
    String fileName = "resources/findCompany.txt";
    String fileNameWriter = "resources/findCompany.txt";
    ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();


    public void sexFindService() throws IOException, FileNotFoundException {

        try {
            printInfo.printInfo(printInfo.takeInfo(24));
            printInfo.printInfo(printInfo.takeInfo(25));
            printInfo.printInfo(printInfo.takeInfo(26));
            printInfo.printInfo(printInfo.takeInfo(27));
            printInfo.printInfo(printInfo.takeInfo(28));
            List<Company> companies = readCompanyGenerator.readCompanies(fileName);
            int statusChoose = scannerAll.scannerNumber();
            filterSexCompany(companies, statusChoose);
            int choose = scannerAll.scannerChoose();
            selectionOfActionsInThisCategory(companies, choose);
            FurtherActions furtherActions = new FurtherActions();
            int stepAgo = scannerAll.scannerFurtherActions();
            furtherActions.choiceFurtherActions(stepAgo);

        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            sexFindService();
        }
    }


    public List<Company> filterSexCompany(List<Company> companies, int statusChoose) throws IOException {
        try {
            List<Company> answer = new ArrayList<>();
            switch (statusChoose) {
                case 1:
                    answer = companies.stream()
                            .filter(company -> company.getSex().equals(Sex.MALE))
                            .toList();
                    break;
                case 2:
                    answer = companies.stream()
                            .filter(company -> company.getSex().equals(Sex.FEMALE))
                            .toList();
                    break;
                case 3:
                    answer = companies.stream()
                            .filter(company -> company.getSex().equals(Sex.ALL))
                            .toList();
                    break;
                default:
                    printInfo.printInfo(printInfo.takeInfo(10));
                    statusChoose = scannerAll.scannerNumber();
                    filterSexCompany(companies, statusChoose);
            }
            writerCompany.writerCompany(answer, fileNameWriter);
            printInfo.printList(answer);
            if (answer.size() == 0) {
                printInfo.printInfo(printInfo.takeInfo(15));
                writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
            }
        } catch (InputMismatchException | IOException e) {
            printInfo.printInfo(printInfo.takeInfo(2));
            statusChoose = scannerAll.scannerNumber();
            filterSexCompany(companies, statusChoose);
        }
        return companies;
    }

    public void selectionOfActionsInThisCategory(List<Company> companies, int choose) {
        try {
            switch (choose) {
                case 1:
                    writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
                    sexFindService();
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
