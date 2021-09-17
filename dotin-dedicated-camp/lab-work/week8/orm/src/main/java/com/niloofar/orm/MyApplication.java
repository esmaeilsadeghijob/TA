package com.niloofar.orm;

import com.niloofar.orm.JDBC.DaoImplementation;
import com.niloofar.orm.JDBC.JDBCSingleton;


public class MyApplication {
    public static void main(String[] args){

        JDBCSingleton jdbc = JDBCSingleton.getInstance();
        DaoImplementation generator = new DaoImplementation();
        MyScanner scanner=new MyScanner();

    }
}
