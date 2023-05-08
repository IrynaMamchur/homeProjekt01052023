package org.example;

import java.io.IOException;
import java.util.InputMismatchException;

public class Start {
    PrintInfo printInfo = new PrintInfo();
    LineOfBusinessFindService lineOfBusinessFindService = new LineOfBusinessFindService();
    StatusFindService statusFindService = new StatusFindService();
    TownFindService townFindService = new TownFindService();
    WorkingModeFindService workingModeFindService = new WorkingModeFindService();
    Finish finish = new Finish();
    SexFindService sexFindService = new SexFindService();
    ScannerAll scannerAll = new ScannerAll();

    public void start() throws IOException {
        try {
            AgeCalculation ageCalculation = new AgeCalculation();
            int age = ageCalculation.ageCalculation();
            AgeCompanyGenerator ageCompanyGenerator = new AgeCompanyGenerator();
            ageCompanyGenerator.ageCompanyGenerator(age);
            searchEngine();
        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
        }
    }

    public void searchEngine() throws IOException {
        try {
            printInfo.printInfo(printInfo.takeInfo(29));
            printInfo.printInfo(printInfo.takeInfo(30));
            printInfo.printInfo(printInfo.takeInfo(31));
            printInfo.printInfo(printInfo.takeInfo(32));
            printInfo.printInfo(printInfo.takeInfo(33));
            printInfo.printInfo(printInfo.takeInfo(34));
            int choose = scannerAll.scannerNumber();
            switch (choose) {
                case 1 -> townFindService.townFindService();
                case 2 -> statusFindService.statusFindService();
                case 3 -> sexFindService.sexFindService();
                case 4 -> lineOfBusinessFindService.lineOfBusinessFindService();
                case 5 -> workingModeFindService.workingModeFindService();
                case 0 -> finish.finish();
                default -> {
                    printInfo.printInfo(printInfo.takeInfo(10));
                    ;
                    searchEngine();
                }
            }
        } catch (InputMismatchException | IOException e) {
            printInfo.printInfo(printInfo.takeInfo(2));
            searchEngine();
        }
    }

}
