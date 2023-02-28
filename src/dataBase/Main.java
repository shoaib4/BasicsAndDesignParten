package dataBase;

import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        DataBase DB = new DataBase("DB");
        RDBTable T = (RDBTable) DB.createTable("table1", 4);
        System.out.println(DB.M);

        System.out.println(T.tableData);
        T.add(new ArrayList<>( List.of(1,2,3,4)) );
        T.add(new ArrayList<>( List.of(2,2,1,3)) );
        T.add(new ArrayList<>( List.of(3,1,1,5)) );
        System.out.println(T.tableData);
        T.delete(1);
        System.out.println(T.tableData);
        T.add(new ArrayList<>( List.of(4,2,1,3)) );
        T.add(new ArrayList<>( List.of(5,1,4,5)) );
        System.out.println(T.tableData);
        Expression exp = new Expression(0, 1, 4);
        System.out.println(T.where(exp));
        T.createIndex(1);
        Expression exp2 = new Expression(1, 1, 2);
        System.out.println(T.where(exp2));
        RDBTable Tt = (RDBTable) DB.M.get("table1");
        System.out.println(Tt.tableData);

    }
}