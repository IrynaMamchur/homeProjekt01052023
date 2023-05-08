package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class WriterCompany {
    PrintInfo printInfo = new PrintInfo();

    public List<Company> writerCompany(List<Company> answer, String fileNameWriter) throws IOException {
        try {
            File file = new File(fileNameWriter);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Company company : answer) {
                bufferedWriter.write(String.valueOf(company));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            writerCompany(answer, fileNameWriter);
        }
        return answer;
    }


    public List<Company> writerCompanyIfListEmpty(List<Company> companies, String fileNameWriter) throws IOException {
        try {
            File file = new File(fileNameWriter);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Company company : companies) {
                bufferedWriter.write(String.valueOf(company));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
            writerCompany(companies, fileNameWriter);
        }
        return companies;
    }

}




