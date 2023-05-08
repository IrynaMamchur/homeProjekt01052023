package org.example;

import java.io.IOException;
import java.util.InputMismatchException;


public class FurtherActions {

    ScannerAll scannerAll = new ScannerAll();
    PrintInfo printInfo = new PrintInfo();
    Finish finish = new Finish();
    Start start = new Start();

    public void choiceFurtherActions(int stepAgo) {
        try {
            switch (stepAgo) {
                case 1:
                    start.searchEngine();
                    break;
                case 2:
                    start.start();
                    break;
                case 0:
                    finish.finish();
                    break;
                default:
                    printInfo.printInfo(printInfo.takeInfo(10));
                    stepAgo = scannerAll.scannerFurtherActions();
                    choiceFurtherActions(stepAgo);
            }
        } catch (InputMismatchException | IOException e) {
            printInfo.printInfo(printInfo.takeInfo(2));
            stepAgo = scannerAll.scannerFurtherActions();
            choiceFurtherActions(stepAgo);
        }
    }
}
