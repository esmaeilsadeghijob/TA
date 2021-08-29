public class StringTest {
    public static void main(String[] args) {
        String string = "fatemeh jafari";

        //return the index element as character
        char ch = string.charAt(4);//m
        System.out.println(ch);

        //compare two Strings if this String was greater return positive value(difference between two unEqual char)
        // if are equals return 0 and else return negative value
        int compare = string.compareTo("zahra jafari");//1(f - z = -20)
        System.out.println(compare);

        //return the index element as unicode
        int codePoint = string.codePointAt(4);//109
        System.out.println(codePoint);

        ////return (the index element - 1) as unicode
        codePoint = string.codePointBefore(5);//109
        System.out.println(codePoint);

        //like compareTo with ignored cases
        compare = string.compareToIgnoreCase("FaTeMeH jAfArI");//0
        System.out.println(compare);

        //concat two Strings
        String concatStr = string.concat(" mapsa camp!");//fatemeh jafari mapsa camp!
        System.out.println(concatStr);

        //check that the String has subString or not
        boolean contain = string.contains("jafari");//true
        System.out.println(contain);

        //check the String ends with a special string or character
        boolean endWith = string.endsWith("ri");//true
        System.out.println(endWith);

        //check that two Strings are equal or not
        boolean equal = string.equals("fatemeh jafarii");//false
        System.out.println(equal);

        //check that two Strings are equal or not with ignored cases
        equal = string.equalsIgnoreCase("FaTeMeH jAfArI");//true
        System.out.println(equal);

        //change String to array of bytes that each element is a ascii code of characters
        System.out.println(string.getBytes()[0]);//102

        //from srcBegin to srcEnd {[src, dst)} copy elements as character in charArray from dstBegin
        char[] charArray = new char[5];
        string.getChars(0, 4, charArray, 0);//fate
        for (int i = 0; i < 5; i++)
            System.out.print(charArray[i] + " ");
        System.out.println();

        //return the first index that found ch
        System.out.println(string.indexOf('e'));//3

        //check String is empty or not
        boolean empty = string.isEmpty();//false
        System.out.println(empty);

        //return the last index that found ch
        System.out.println(string.lastIndexOf('e'));//5

        //return the length of String
        System.out.println(string.length());//14

        //check String is in regex format or not
        boolean match = string.matches("([a-zA-Z]*[\\s][a-zA-Z]*)");//true
        System.out.println(match);

        //replace all old characters with new character
        String newStr = string.replace('e', 'a');//fatamah jafari
        System.out.println(newStr);

        //replace first format regex where found in String with new String
        newStr = string.replaceFirst("[a-zA-Z]*", "zahra");//zahra jafari
        System.out.println(newStr);

        //replace all format regex where found in String with new String
        newStr = string.replaceAll("[\\s]", "   ");//fatamah   jafari
        System.out.println(newStr);

        //split a String with regex format to String[]
        String[] strArray = string.split("[\\s]");
        System.out.println(strArray[0]);//fatemeh
        System.out.println(strArray[1]);//jafari

        //check the String starts with a special string or character
        boolean startWith = string.startsWith("fat");//true
        System.out.println(startWith);

        //change to uppercase all characters in string
        System.out.println(string.toUpperCase());//FATEMEH JAFARI

        //change to lowercase all characters in string
        System.out.println(string.toLowerCase());//fatemeh jafari

        //remove spaces in start and end of string
        string = "   fatemeh jafari   ";
        System.out.println(string.trim());//"fatemeh jafari"
    }
}
