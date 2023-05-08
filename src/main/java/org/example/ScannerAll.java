package org.example;

import java.util.Scanner;

public class ScannerAll {
    PrintInfo printInfo = new PrintInfo();

    public int scannerFurtherActions() {
        printInfo.printInfo(printInfo.takeInfo(12));
        printInfo.printInfo(printInfo.takeInfo(13));
        printInfo.printInfo(printInfo.takeInfo(14));
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int scannerChoose() {
        printInfo.printInfo(printInfo.takeInfo(20));
        printInfo.printInfo(printInfo.takeInfo(21));
        printInfo.printInfo(printInfo.takeInfo(22));
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int scannerNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String scannerString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
