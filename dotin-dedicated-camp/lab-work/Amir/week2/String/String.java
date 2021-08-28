
public class String {
    public static void main(String[] args) {

        /*
        String is a class implemented in java
        string is immutable
        any assignment value will create new object of string
         */

        // strings are immutable
        String message = "Hello, world";
        String message2 = message;
        // message2 and message both have same reference
        System.out.println(message == message2);
        // now change the value
        // so the new object of message created
        message = "Hello, world!";
        System.out.println(message == message2);

        System.out.println("--------------------");

        System.out.println(message);
        System.out.println("--------------------");

        // length of string
        System.out.println(message.length());
        System.out.println("--------------------");

        // remove the white spaces
        message = " Hello, world! ";
        System.out.println(message);
        message = message.trim();
        System.out.println(message);
        System.out.println("--------------------");

        // replace letter or word
        System.out.println(message.replace("world", "dolly"));
        System.out.println("--------------------");

        // to upper and lowerCase
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println("--------------------");

        // compare equality
        String comp = "hello, world!";
        System.out.println(message.equals(comp));
        System.out.println(message.equalsIgnoreCase(comp));
        System.out.println("--------------------");












    }
}
