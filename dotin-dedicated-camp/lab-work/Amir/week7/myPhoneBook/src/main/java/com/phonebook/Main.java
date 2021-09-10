package com.phonebook;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Console console = new Console();
        console.showMenu();
        console.userChoice();
    }
}
