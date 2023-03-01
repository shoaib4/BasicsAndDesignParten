package Test;

import java.util.ArrayList;
import java.util.Objects;

public interface ITable {
    public void add(ArrayList<Object> row);

    public void delete(int i);

    public void printTable();
}
