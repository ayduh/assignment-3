package com.assignment3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class AppTest 
{
    // ---> PART 1.2 TESTING <---
    @Test
    public void testMyHashTable(){
        int size = 20;
        MyHashTable<MyTestingClass, Integer> a = new MyHashTable(size);

        for(int i = 0; i < 10000; i++){
            a.put(new MyTestingClass(i), i);
        }

        a.printBucketSizes();
    }


    // ============================================= //
    @Test
    public void testRemoveMethod(){
        int size = 11;
        MyHashTable<MyTestingClass, Integer> a = new MyHashTable(size);

        for(int i = 0; i < 100; i++){
            a.put(new MyTestingClass(i), i);
        }

        MyTestingClass element = new MyTestingClass(2);
        System.out.println(a.remove(element));
        System.out.println(a.get(element));
    }

    @Test
    public void testContainsMethod(){
        int size = 11;
        MyHashTable<MyTestingClass, Integer> a = new MyHashTable(size);

        a.put(new MyTestingClass(0), 100);
        a.put(new MyTestingClass(2), 3);

        System.out.println(a.get(new MyTestingClass(2)));

        System.out.println(a.contains(3));
    }

    @Test
    public void testBSTUpdateValue() {
        BST<String, Integer> tree = new BST<>();
        tree.put("Apple", 1);
        tree.put("Apple", 2);

        System.out.println(tree.get("Apple"));
        assertEquals(Integer.valueOf(2), tree.get("Apple"));
        assertEquals(1, tree.size());
    }
}