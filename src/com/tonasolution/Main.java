package com.tonasolution;

public class Main {

    public static void main(String[] args) {

        Employee zouhaire = new Employee("zouhaire", "elakioui", 123);
        Employee jack = new Employee("jack", "ali", 1234);
        Employee kali = new Employee("kali", "maeckel", 12345);
        Employee mary = new Employee("Mary", "smith", 12345);
        Employee kamal = new Employee("kamal", "loli", 12395);

        ChainedHashTable chainedHashTable = new ChainedHashTable();
        chainedHashTable.put("zouhaire", zouhaire);
        chainedHashTable.put("jack", jack);
        chainedHashTable.put("kali", kali);
        chainedHashTable.put("mary", mary);
        chainedHashTable.put("mary", kamal);

        chainedHashTable.print();

        System.out.println("Retrieve key  kali" + chainedHashTable.get("mary"));

        System.out.println("Deleting ---> ");
        chainedHashTable.remove("mary");
        chainedHashTable.remove("jack");
        chainedHashTable.print();
    }
}
