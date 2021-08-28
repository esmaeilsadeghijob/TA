package org;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            Handel handel = new Handel();
            handel.doAll();
        } catch (IOException e) {

            System.err.println(e.getMessage());

        }


    }

}
