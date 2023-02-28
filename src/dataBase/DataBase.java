package dataBase;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public String name;
    public Map<String, Table> M = new HashMap<>();
    public DataBase(String name){
        this.name = name;
    }
    Table createTable(String name, Integer sizeOfRow){
        Table T = new RDBTable(name, sizeOfRow);
        M.put(name, T);
        return T;
    }

}
