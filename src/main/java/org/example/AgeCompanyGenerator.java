package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgeCompanyGenerator {

    private static List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public void isAgeCompanyGenerator(int age) throws IOException, FileNotFoundException {

        try {
            ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();
            List<Company> companies = readCompanyGenerator.isReadCompanies();
            isFindFileCompanies(age, companies);
        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }



    public List<Company> isFindFileCompanies(int age, List<Company> companies) throws IOException {
        List<Company> answer = companies.stream()
                .filter(company -> company.getMinAgeLimit() <= age && company.getMaxAgeLimit() >= age)
                .toList();

        File file1 = new File("resources/findCompany.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        for (Company company : answer) {
            System.out.println(company);
            bufferedWriter.write(String.valueOf(company));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        System.out.println("-------------------------------------------------------------------------------");
        return companies;
    }

}




