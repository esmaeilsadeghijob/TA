package org;

import java.io.IOException;
import java.util.Scanner;

public class Handel {

    public void doAll() throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Please insert the Account number: ");
        String accountNumber = input.nextLine();

        System.out.print("Please insert your first name: ");
        String firstName = input.nextLine();

        System.out.print("Please insert your first name: ");
        String lastName = input.nextLine();

        System.out.print("Please insert the amount of your balance: ");
        String balance = input.nextLine();

        OutputWithFormatter outputWithFormatter = new OutputWithFormatter(accountNumber, firstName, lastName, balance);
        outputWithFormatter.addToList();
        outputWithFormatter.displayFile();

        System.out.println("save...");


    }

}
