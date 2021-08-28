import java.util.Locale;

public class Tamrin1 {
    public static void main(String[] args) {
        String a = "my name is ana";
        System.out.println(a.replaceAll("ana","anahita"));
        System.out.println(a.replace("a","A"));
        System.out.println(a.replace("na","an"));
        System.out.println(a.charAt(0));
        System.out.println(a.chars());
        System.out.println(a.codePointAt(2));
        System.out.println(a.codePointBefore(2));
        System.out.println(a.codePointCount(2,6));
        System.out.println(a.codePoints());
        System.out.println(a.compareTo("ana"));
        System.out.println(a.compareToIgnoreCase("ANA"));
        System.out.println(a.concat(" and my family is makvandi"));
        System.out.println(a.contains("ana"));
        System.out.println(a.contentEquals("j"));
        System.out.println(a.contentEquals("ana"));
        System.out.println(a.contentEquals("my name is ana"));
        System.out.println(a.endsWith("na"));
        System.out.println(a.equals("a"));
        System.out.println(a.equalsIgnoreCase("my name is ana"));
        System.out.println(a.getBytes());
        //in chejoorie? System.out.println(a.getBytes(""));
        System.out.println(a.hashCode());
        System.out.println(a.indexOf(5));
        System.out.println(a.indexOf(4));
//        index of chio bar migardoone?
        System.out.println(a.indexOf("a"));
        System.out.println(a.indexOf(0,4));
        System.out.println(a.indexOf(4,1));
        System.out.println(a.indexOf("a",4));
        System.out.println(a.intern());
        System.out.println(a.lastIndexOf(5));
        System.out.println(a.lastIndexOf("a"));
        System.out.println(a.lastIndexOf(7,4));
        System.out.println(a.lastIndexOf("a",7));
        System.out.println(a.length());
        System.out.println(a.matches("my name is ana"));
        System.out.println(a.offsetByCodePoints(5,7));
        System.out.println(a.regionMatches(3,"name",7,4));
        System.out.println(a.regionMatches(true,0,"my",2,2));
        System.out.println(a.replaceFirst("ana","asdf"));
        System.out.println(a.split("a"));
        System.out.println(a.split(" ",1));
        System.out.println(a.toString());
        System.out.println(a.startsWith("m"));
        System.out.println(a.startsWith("a",4));
        System.out.println(a.substring(4));
        System.out.println(a.substring(4,8));
        System.out.println(a.toLowerCase());
        System.out.println(a.toLowerCase(Locale.forLanguageTag("l")));
        System.out.println(a.isEmpty());
        System.out.println(a.toCharArray());
        System.out.println(a.toUpperCase());
        System.out.println(a.trim());
        System.out.println(a.subSequence(4,8));
        System.out.println(a.getClass());
       // System.out.println(a.getChars(4,8,'a',9));
        a.notify();
        a.getChars(4,8, new char[]{'a'},9);
        a.notifyAll();
        try {
            a.wait(1000,40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
