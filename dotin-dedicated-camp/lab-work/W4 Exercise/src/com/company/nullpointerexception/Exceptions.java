package com.company.nullpointerexception;

public class Exceptions {

    private String inputString;

    public Exceptions(String inputString) {

        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {

        this.inputString = inputString;
    }

    public boolean isFive() {

        boolean result = false;


        try {

            if (getInputString() == null) {

                throw new NullPointerException("Input string must be not null");

            }

            if (getInputString().length() > 5) {

                System.out.printf("%s have more than 5 character", getInputString());
                result = true;
            }


        } catch (NullPointerException e) {

            System.err.println(e);

        }

        return result;

    }

}