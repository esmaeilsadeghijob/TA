import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        // declaring a variable in String type by the name of 'article'
        String article = "A computer is an electronic device that stores and processes data.";

        // invoking the String class methodes

        // 1- .equals()
        System.out.println("1-" + "\t" + article.equals("this method going to return bollean and compare two string"));
        System.out.println("");

        // 2- It's going to break the string in whatever char or symbol we pass to this mehtod
        System.out.println("2-" + "\t" + article.split(","));
        System.out.println("");

        //3- It's return a boolean that Checks whether a string contains a sequence of characters
        System.out.println("3-" + "\t" + article.contains("hamed"));
        System.out.println("");

        //4- this return th length of our String
        System.out.println("4-" + "\t" + article.length());
        System.out.println("");

        // 5-it's gong to delete all the unused space before or after our String
        String hi = "   Hello There !    ";
        System.out.println("5-" + "\t" + hi.trim());
        System.out.println("");

        //6- It's going to return the specific char at the index of we've been passed to it
        System.out.println("6-" + article.charAt(5));
        System.out.println("");

        //7- Compares two strings lexicographically
        System.out.println("7-" + "\t" + article.compareTo("hamed"));
        System.out.println("");

        //8- Returns the Unicode of the character at the specified index
        System.out.println("8-" + "\t" + article.codePointAt(20));
        System.out.println("");

        //9- Returns the Unicode of the character before the specified index
        System.out.println("9-" + "\t" + article.codePointBefore(20));
        System.out.println("");

        //10- Returns the Unicode in the specified text range of this String
        System.out.println("10-" + "\t" + article.codePointCount(20,30));
        System.out.println("");

        //11- Compares two strings lexicographically, ignoring case differences
        System.out.println("11-" + "\t" + article.compareToIgnoreCase("hamed"));
        System.out.println("");

        //12- Appends a string to the end of another string
        System.out.println("12-" + "\t" + article.concat("hamed khalili"));
        System.out.println("");

        //13- Checks whether a string contains the exact same sequence of characters of the specified CharSequence or StringBuffer
        System.out.println("13-" + "\t" + article.contentEquals("hamed"));
        System.out.println("");

        //14- It's going to returns a String that represents the characters of the character array
        char[] fullName = {'H','A','M','E','D','K','H','A','L','I','L','I'};
        String firstName = "";
        System.out.println("14-" + "\t" + article.copyValueOf(fullName,0,5));
        System.out.println("");

        //15-  ignoring case differences
        String str1 = "HAMED";
        String str2 = "hamed";
        String str3 = "khalili";
        System.out.println("15A-" + "\t" + str1.equalsIgnoreCase(str2));
        System.out.println("15B-" + "\t" + str1.equalsIgnoreCase(str3));
        System.out.println("");

        //16- Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array
        System.out.println("16-" + "\t" + article.getBytes(StandardCharsets.UTF_8));
        System.out.println("");

        //17- Returns the hash code of a string
        System.out.println("17-" + "\t" + article.hashCode());
        System.out.println("");

        //18- Returns the position of the first found occurrence of specified characters in a string
        System.out.println("18-" + "\t" + article.indexOf(33));
        System.out.println("");

        //19- Checks whether a string is empty or not
        System.out.println("19-" + "\t" + article.isEmpty());
        System.out.println("");

        //20- Returns the position of the last found occurrence of specified characters in a string
        System.out.println("20-" + "\t" + article.lastIndexOf("computer"));
        System.out.println("");

        //21- Checks whether a string starts with specified characters
        System.out.println("21-" + "\t" + article.startsWith("A"));
        System.out.println("");

        //22- Converts a string to lower case letters
        System.out.println("22-" + "\t" + article.toLowerCase(Locale.ROOT));
        System.out.println("");

        //23- Converts a string to upper case letters
        System.out.println("23-" + "\t" + article.toUpperCase());
        System.out.println("");





    }
}
