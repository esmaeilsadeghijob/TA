
public class Main {
    public static void main(String[] args) {
        String test = "helooo";
        String myString = "My Name Is niloofar";
 //charAt equals
        boolean b= myString.equals(test);
         char a=test.charAt(2);
        System.out.println(myString + b + a);
//length
        String sentence = "This is a short sentence.";
        System.out.println(sentence.length());

//toLowercase and toUppercare
        String name = "niloofar azizi";
        System.out.println(name.toLowerCase() + name.toUpperCase());

//substring and concat and contains
        String str = "java like   ";
        String tempString = str.substring(4);
        System.out.println(tempString);
        System.out.println("My name is ".concat("nilooooooo"));
        System.out.println("aya j darad " + "   " + str.contains("j"));

//index equalsIgnoreCase replace lastIndexOf
     int index= name.indexOf("o");
      int index2 = myString.lastIndexOf("o");
     Boolean tasavi= name.equalsIgnoreCase(myString);
     String str2 =name.replace("n","m");
        System.out.println(index  + "   " + str2 + index2);

//trim  compareTo
        String tempString2 = str.trim();
        int tempString3 =   str.compareTo("niloo");
        System.out.println(tempString2  + "   " +  tempString3);

    }

}
