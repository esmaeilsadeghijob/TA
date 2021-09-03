package org;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OutputWithFormatter {

    private String accountNumber;
    private String firstName;
    private String lastName;
    private String balance;

    public OutputWithFormatter(){}

    public OutputWithFormatter(String accountNumber, String firstName, String lastName, String balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


    public static void display(List list) throws IOException {

        File file = new File("Text.txt");

        String output = String.format("%s \t %s \t %s \t %s\n", list.get(0), list.get(1), list.get(2), list.get(3));
        FileOutputStream out = new FileOutputStream(file);
        Writer outputStreamWriter = new OutputStreamWriter(out);
        outputStreamWriter.write(output);
        outputStreamWriter.close();


    }

    public List addToList() {

        List<String> list = new ArrayList<>();

        list.add(getAccountNumber());
        list.add(getFirstName());
        list.add(getLastName());
        list.add(getBalance());

        return list;

    }

    public void displayFile() throws IOException{

        display(addToList());

    }


}
