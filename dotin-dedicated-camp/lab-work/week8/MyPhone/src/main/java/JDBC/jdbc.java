package JDBC;

import java.util.ArrayList;
import java.util.List;

public interface jdbc<T> {
     void save(ArrayList<T> P);
     void update(int id);
     List<T> findAll();
     T findById(int id);
    void deleteP(int id);
}
