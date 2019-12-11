package com.tonasolution;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {

    // == fields ==
    private LinkedList<StoreEmployee>[] hashTable;

    // == constructors ==
    public ChainedHashTable() {
        this.hashTable = new LinkedList[10];

        for (int i = 0; i < hashTable.length; i++ ) {
            hashTable[i] = new LinkedList<>();
        }
    }

    // == public methods ==
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashTable[hashedKey].add(new StoreEmployee(key, employee));
    }

    public Employee get(String key) {

        int hashedKey = hashKey(key);
        ListIterator<StoreEmployee> iterator = hashTable[hashedKey].listIterator();

        while (iterator.hasNext()) {

            StoreEmployee storeEmployee = iterator.next();
            if (storeEmployee.key.equals(key)) {
                return storeEmployee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoreEmployee> iterator = hashTable[hashedKey].listIterator();

        while (iterator.hasNext()) {
            StoreEmployee storeEmployee = iterator.next();

            if (storeEmployee.key.equals(key)) {
                iterator.remove();
                return storeEmployee.employee;
            }
        }

        return null;
    }

    public void print(){

        for(int i = 0; i < hashTable.length; i++) {

            if(hashTable[i].isEmpty()) {
                System.out.println("Position " + i + "is empty");
                System.out.println("This linkedList is empty");
            }
            else {
                ListIterator<StoreEmployee> iterator = hashTable[i].listIterator();
                System.out.println("Position " + i + " --> ");

                while (iterator.hasNext()) {
                    System.out.println(iterator.next().employee);
                    System.out.print("-->");
                }

                System.out.println("null");
            }
        }
    }

    // == private methods ==
    private int hashKey(String key) {
        return Math.abs(key.hashCode() % hashTable.length);
    }
}
