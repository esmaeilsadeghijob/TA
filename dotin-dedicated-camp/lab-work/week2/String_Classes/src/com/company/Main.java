package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        System.out.println("pls enter the name");
        String name = s.next();
        int i=name.length()-1;
        System.out.println("pls enter the num between 1 and "+i);
        int n = s.nextInt();
        if(name.equals("ali")) System.out.println("yes ali");
        if(name.equalsIgnoreCase("ali")) System.out.println("yes ali ignore case");
        System.out.println("print b horoofe koochak: "+name.toLowerCase());
        System.out.println("print b horoofe bozorg: "+name.toUpperCase());
        System.out.println(name.getBytes(StandardCharsets.UTF_8));
        System.out.println("karaktere "+n+" om "+name+" = "+name.charAt(n-1));
        System.out.println("length of "+name+" = "+name.length());
        System.out.println("pls enter two char");
        String r1=s.next();
        String r2=s.next();
        System.out.println("replace " +r1+" instead of " +r2+ "for name "+name+"=" +name.replace(r1,r2));
        System.out.println("makane voghooe "+r1+" = "+name.indexOf(r1));
        System.out.println("az makane "+n+" om b baade "+name+"="+name.substring(n));
        System.out.println("pls enter the num between 0 and "+i);
        int start=s.nextInt();
        int end=s.nextInt();
        System.out.println("az makane "+start+" om ta "+end+" ome "+name+"="+name.substring(n));
        if (name.isEmpty()==true) System.out.println("name is null");
        if (name.compareTo("ali")!=0) {
            System.out.println("esme vared shode ali nist");
            System.out.println(name.compareTo("ali"));

        }else System.out.println("esme vared shode ali ast");
    }
}
