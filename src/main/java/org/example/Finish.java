package org.example;

public class Finish {
    PrintInfo printInfo = new PrintInfo();

    public void finish() {
        printInfo.printInfo(printInfo.takeInfo(11));
        System.exit(0);
    }
}

