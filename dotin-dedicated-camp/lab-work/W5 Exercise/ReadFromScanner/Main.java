package com.company.mahdi;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            ReadDisplayFile readDisplayFile = new ReadDisplayFile();
            readDisplayFile.displayTable();
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
