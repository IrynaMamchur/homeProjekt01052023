package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ReadCompanyGenerator {
    public  List<Company> isReadAllCompanies() throws IOException {
        List<Company> companies = new ArrayList<>();
        File file = new File("resources/findCompany.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String companyString = "";
        while (companyString != null) {
            companyString = bufferedReader.readLine();
            if (companyString != null) {
                String[] data = companyString.split(" ");
                String name = data[0];
                int yearOfCreation = Integer.parseInt(data[2]);
                String locationCity = data[4];
                TypeOfCompany status = TypeOfCompany.valueOf(data[6]);
                String lineOfBusiness = data[8];
                WorkingMode workingMode = WorkingMode.valueOf(data[10]);
                Sex sex = Sex.valueOf(data[12]);
                int minAgeLimit = Integer.parseInt(data[14]);
                int maxAgeLimit = Integer.parseInt(data[16]);
                Company company = new Company(name, yearOfCreation, locationCity, status, lineOfBusiness, workingMode, sex, minAgeLimit, maxAgeLimit);
                companies.add(company);
            }
        }
        bufferedReader.close();
        return companies;
    }


    public List<Company> isReadCompanies() throws IOException {
        List<Company> companies = new ArrayList<>();
        File file = new File("resources/company.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String companyString = "";
        while (companyString != null) {
            companyString = bufferedReader.readLine();
            if (companyString != null) {
                String[] data = companyString.split(" ");
                String name = data[0];
                int yearOfCreation = Integer.parseInt(data[1]);
                String locationCity = data[2];
                TypeOfCompany status = TypeOfCompany.valueOf(data[3]);
                String lineOfBusiness = data[4];
                WorkingMode workingMode = WorkingMode.valueOf(data[5]);
                Sex sex = Sex.valueOf(data[6]);
                int minAgeLimit = Integer.parseInt(data[7]);
                int maxAgeLimit = Integer.parseInt(data[8]);
                Company company = new Company(name, yearOfCreation, locationCity, status, lineOfBusiness, workingMode, sex, minAgeLimit, maxAgeLimit);
                companies.add(company);
            }
        }
        bufferedReader.close();
        return companies;
    }
}