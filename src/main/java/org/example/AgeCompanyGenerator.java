package org.example;

import java.io.*;
import java.util.List;

public class AgeCompanyGenerator {

    private static List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    PrintInfo printInfo = new PrintInfo();
    WriterCompany writerCompany = new WriterCompany();
    String fileName = "resources/company.txt";
    String fileNameWriter = "resources/findCompany.txt";
    ReadCompanyGenerator readCompanyGenerator = new ReadCompanyGenerator();

    public void ageCompanyGenerator(int age) throws IOException, FileNotFoundException {

        try {
            List<Company> companies = readCompanyGenerator.readCompanies(fileName);
            List<Company> answer = filterCompaniesForAge(age, companies);
            writerCompany.writerCompany(answer, fileNameWriter);
            printInfo.printList(answer);
        } catch (IOException e) {
            printInfo.printInfo(printInfo.takeInfo(8));
        }
    }

    public List<Company> filterCompaniesForAge(int age, List<Company> companies) throws IOException {
        List<Company> answer = companies.stream()
                .filter(company -> company.getMinAgeLimit() <= age && company.getMaxAgeLimit() >= age)
                .toList();
        return answer;
    }
}




