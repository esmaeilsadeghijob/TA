package com.mapsa;

import com.mapsa.database.CrudGenerator;
import com.mapsa.database.JdbcCrud;
import com.mapsa.model.User;

public class Main {
    public static void main(String[] args) {
        JdbcCrud<User> jdbcCrud = new CrudGenerator<>();
        try {
            jdbcCrud.create(new User());
            User user = new User().setId(1).setUsername("fatemeh").setPassword("batooei");
            jdbcCrud.save(user);
           // jdbcCrud.update(new User().setId(1).setUsername("zahra").setPassword("abasi"));
           // jdbcCrud.delete(new User().setId(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
