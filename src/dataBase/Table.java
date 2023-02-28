package dataBase;

import java.util.ArrayList;

public interface Table {
    void add(ArrayList<Integer> row);

    void delete(int id);
}
