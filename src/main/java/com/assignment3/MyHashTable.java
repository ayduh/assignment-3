package com.assignment3;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int size;

    public MyHashTable(){
        this(11); // default
        this.size = 0;
    }

    public MyHashTable(int M){
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    public void printBucketSizes(){
        for(int i = 0; i < chainArray.length; i++){
            int counter = 0;
            HashNode<K, V> head = chainArray[i];
            while(head != null){
                counter++;
                head = head.next;
            }
            System.out.println("Bucket size at index " + i + ": " + counter);
        }
    }

    private int hash(K key){
        if (key == null) return 0;
        return(key.hashCode() & 0x7fffffff) % chainArray.length; //0x7fffffff is used to make it be always positive
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        
        while (head != null){
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode<K, V> node = new HashNode<>(key, value);
        node.next = chainArray[index];
        chainArray[index] = node;
        size++;
        
    }

    public V get(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null){
            if (head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> headNext = head.next;

        if(head.key.equals(key)){
            chainArray[index] = headNext;
            size--;
            return head.value;
        }

        while (headNext != null){
            if (headNext.key.equals(key)){
                head.next = headNext.next;
                size--;
                return headNext.value;
            }
            head = head.next;
            headNext = head.next;
        }

        return null;
    }

    public boolean contains(V value){
        for(int i = 0; i < chainArray.length; i++){
            HashNode<K, V> head = chainArray[i];
            while(head != null){
                if(head.value == value) return true;
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < chainArray.length; i++) {
            HashNode<K, V> head = chainArray[i];

            while (head != null) {
                if ((value == null && head.value == null) || 
                    (value != null && value.equals(head.value))) {
                    return head.key;
                }
                head = head.next;
            }
        }

        return null;
    }
}
