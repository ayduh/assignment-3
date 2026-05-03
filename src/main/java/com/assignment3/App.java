package com.assignment3;

public class App{
    public static void main( String[] args ){
    // PART 1.2 TESTING
        int size = 20;
        MyHashTable<MyTestingClass, Integer> a = new MyHashTable(size);

        for(int i = 0; i < 10000; i++){
            a.put(new MyTestingClass(i), i);
        }

        a.printBucketSizes();
    }
}
