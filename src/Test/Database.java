package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Database {
    public String name;
    private HashMap<String, Table> M ;
    public Database( String name ){
        this.name = name;
        this.M = new HashMap<>();
    }
    public Table createTable(String name, ArrayList<Class<?>> schema){
        Table t = new Table(name, schema);
        M.put(name, t);
        return t;
    }
}
