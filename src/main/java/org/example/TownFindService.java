package org.example;

import java.io.*;
import java.util.InputMismatchException;
import java.util.List;


public class TownFindService {
    PrintInfo printInfo = new PrintInfo();
    ScannerAll scannerAll = new ScannerAll();
    WriterCompany writerCompany = new WriterCompany();

    String fileName = "resources/findCompany.txt";
    String fileNameWriter = "resources/findCompany.txt";
    ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();

    public void townFindService() throws IOException, FileNotFoundException {

        try {
            printInfo.printInfo(printInfo.takeInfo(38));
            printInfo.printInfo(printInfo.takeInfo(39));

            String world = scannerAll.scannerString();
            List<Company> companies = readCompanyGenerator.readCompanies(fileName);
            filterTownCompany(companies, world);
            int choose = scannerAll.scannerChoose();
            isChoose(companies, choose);
            FurtherActions furtherActions = new FurtherActions();
            int stepAgo = scannerAll.scannerFurtherActions();
            furtherActions.choiceFurtherActions(stepAgo);

        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
        }
    }


    public List<Company> filterTownCompany(List<Company> companies, String world) throws IOException {
        try {
            String town = world.toUpperCase();
            List<Company> answer = companies.stream()
                    .filter(company -> company.getLocationCity().equals(town))
                    .toList();
            writerCompany.writerCompany(answer, fileNameWriter);
            printInfo.printList(answer);
            if (answer.size() == 0) {
                printInfo.printInfo(printInfo.takeInfo(15));
                writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
            }
        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            filterTownCompany(companies, world);
        }
        return companies;
    }


    public void isChoose(List<Company> companies, int choose) {
        try {
            switch (choose) {
                case 1:
                    writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
                    townFindService();
                    break;
                case 2:
                    break;
                case 3:
                    writerCompany.writerCompanyIfListEmpty(companies, fileNameWriter);
                    break;
                default:
                    printInfo.printInfo(printInfo.takeInfo(10));
                    choose = scannerAll.scannerChoose();
                    isChoose(companies, choose);
            }
        } catch (InputMismatchException | IOException e) {
            printInfo.printInfo(printInfo.takeInfo(10));
            choose = scannerAll.scannerChoose();
            isChoose(companies, choose);
        }
    }

}

