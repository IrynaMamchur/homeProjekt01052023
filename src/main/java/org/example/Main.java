package org.example;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InfoAboutService infoAboutService = new InfoAboutService();
        Start start = new Start();
        infoAboutService.infoAboutServiceFirst();
        start.start();

    }
}