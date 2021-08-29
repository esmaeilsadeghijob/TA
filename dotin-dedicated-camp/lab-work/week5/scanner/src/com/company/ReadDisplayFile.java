package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadDisplayFile {


     File file = new File("E:\\4.txt");

    public void displayTable() throws IOException {

        Scanner input = new Scanner(file);

        input.useDelimiter(",");

        while (input.hasNext()) {

            System.out.print(input.next());

        }

        input.close();

    }

}
