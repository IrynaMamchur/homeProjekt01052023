package example;

import org.example.InfoAboutService;
import org.example.Start;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        InfoAboutService infoAboutService = new InfoAboutService();
        Start start = new Start();
        infoAboutService.isInfoAboutServiceFirst();
        start.start();

    }
}


