package Test;

import java.util.ArrayList;
import java.util.Objects;

public class Table implements ITable {
    private String name;
    private ArrayList<Class<?>> schema;
    public Integer rowSize;
    public Integer size;

    private ArrayList<ArrayList<Object>> tabelData;

    public Table(String name, ArrayList<Class<?>> schema){
        this.name = name;
        this.schema = schema;
        this.rowSize = schema.size();
        this.tabelData = new ArrayList<>();
        this.size = 0;
    }
    private Boolean validateRow(ArrayList<Object> row) {
        int n = row.size();
        if(n != rowSize) return false;
        for( int i  = 0; i < rowSize; i++){
            if(row.get(i).getClass() != schema.get(i)) return false;
        }
        return true;
    }
    private void addToTable(ArrayList<Object> row) {
        this.tabelData.add(row);
    }

    @Override
    public void add(ArrayList<Object> row) {
        if(validateRow(row)) addToTable(row);
    }

    @Override
    public void delete(int i) {

    }

    @Override
    public void printTable() {
        System.out.println(tabelData);
    }
}
