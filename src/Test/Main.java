package Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // validate data
        // ==
        // lld implementation question -
        //  Design and execute in memory db
        //   - write db and table contracts[create table, drop table, insert data in table, drop row in table ]
        //   - add validation layer while data insertion
        //   - implement complete contract using in memory data structures
        //  - where pk > 1
        Database db = new Database("db1");
        ArrayList<Class<?>> schema = new ArrayList<>(List.of(
                Integer.class,
                String.class,
                Integer.class,
                Integer.class
        ));
        Table table =  db.createTable("table1", schema);
        table.add(new ArrayList<>(List.of(1,"dff",1,4)));
        table.add(new ArrayList<>(List.of(2,1,3,4)));
        table.printTable();
        Object o = 1;
        System.out.println(o.getClass().getName());
//        table.add();


    }
}