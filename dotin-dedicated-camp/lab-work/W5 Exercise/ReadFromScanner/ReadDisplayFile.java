/*
 *    Filename:  ReadDisplayFile.java
 *    Description:  W4 or W5 exercise  _ this program read an information file with txt or csv file and display
 *                                       that information into the console
 *
 *       Created:  08/23/2021 10:05:00
 *       Revision:  .................
 *
 *    Author:  Mehdi Ghomsheh
 *
 *
 * =====================================================================================
 */
package com.company.mahdi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadDisplayFile {

    // create an object from class File and assign it to file to load a txt file into our program
    private final File file = new File("File.txt");

    /**
     * in this method we read txt file, and we read this file with help of File class and then use the object of that
     * to Scanner class object to read the txt file.
     * after that we display table in the console with simple command System.out.print()
     */
    public void displayTable() throws IOException {


        // create scanner object and read file
        Scanner input = new Scanner(file);

        input.useDelimiter(","); // set the delimiter pattern

        while (input.hasNext()) {

            System.out.print(input.next());

        }

        input.close();

    }

}
