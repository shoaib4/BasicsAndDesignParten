package dataBase;

import java.util.*;

class Expression {
    Integer indexValue;
    Integer operation;
    Integer value;
    public Expression(Integer f,Integer o,Integer s){
        this.indexValue = f;
        this.value = s;
        this.operation = o;
    }
}
public class RDBTable implements Table{

    private String name;
    private final Integer rowSize;
    public Integer size = 0;
    public ArrayList<ArrayList<Integer>> tableData = new ArrayList<>();
    private Set<Integer> indexList = new HashSet<>();
    private HashMap<Integer, TreeMap<Integer, Set<Integer>>> indexes = new HashMap<>();
    private Queue<Integer> deletedAddress = new LinkedList<Integer>();;
    public void createIndex(Integer col) {
        indexList.add(col);
        indexes.put(col, new TreeMap<>() );
        for( int i = 0; i < tableData.size(); i++) {
            if (!deletedAddress.contains(i))
                addAddressToIndex(col, i);
        }
        System.out.println(indexes.get(col));
    }
    private void addAddressToIndex(Integer colIndex, Integer tableDataAddress) {
        ArrayList<Integer> row = tableData.get(tableDataAddress);
        TreeMap<Integer, Set<Integer>> tM = indexes.get(colIndex);
        if(tM.containsKey(row.get(colIndex))) {
            tM.get(row.get(colIndex)).add(tableDataAddress);
        }
        else
            tM.putIfAbsent(row.get(colIndex), new HashSet<>(List.of(tableDataAddress)));
    }
    private void pushToIndexs(Integer tableDataAddress){
        for(Integer colIndex : indexList){
            addAddressToIndex(colIndex, tableDataAddress);
        }
    }
    private void removeAddressFromIndex(Integer colIndex, Integer tableDataAddress) {
        ArrayList<Integer> row = tableData.get(tableDataAddress);
        indexes.get(colIndex).get(row.get(colIndex)).remove(tableDataAddress);
    }
    private void removeFromIndexs(Integer tableDataAddress){
        for(Integer colIndex : indexList){
            removeAddressFromIndex(colIndex, tableDataAddress);
        }
    }

    public RDBTable(String name, Integer rowSize){
        this.name = name;
        this.rowSize = rowSize;
        createIndex(0);
    }
    @Override
    public void add(ArrayList<Integer> row) {
        int tableDataAddress = tableData.size();
        if(deletedAddress.isEmpty()) {
            tableData.add(row);
        }
        else {
            tableDataAddress = deletedAddress.iterator().next();
            tableData.set(tableDataAddress, row);
            deletedAddress.remove();
        }
        pushToIndexs(tableDataAddress);
    }

    @Override
    public void delete(int id) {
        Integer addressToRemove = indexes.get(0).get(id).iterator().next();
        removeFromIndexs(addressToRemove);
        deletedAddress.add(addressToRemove);
    }

    public ArrayList<ArrayList<Integer>> where(Expression exp) {
        Integer index = exp.indexValue;
        // if not in index search all;
        Integer val = exp.value;
        ArrayList<Integer> addressResult = new ArrayList<>();
        indexes.get(index)
                .tailMap(val)
                .values()
                .forEach(list -> addressResult.addAll(list));
        ArrayList<ArrayList<Integer>> valuesResult = new ArrayList<>();
        addressResult.forEach(address -> valuesResult.add(tableData.get(address)) );
        return valuesResult;
    }
}
