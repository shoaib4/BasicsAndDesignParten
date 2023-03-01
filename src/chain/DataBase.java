package chain;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public String name;
    public Map<String, Chair> M = new HashMap<>();
    public DataBase(String name){
        this.name = name;
    }
    Chair createTable(String name, Integer sizeOfRow){
        Chair T = new RDBChair(name, sizeOfRow);
        M.put(name, T);
        return T;
    }

}
