package com.devstromo.maps.open_addressing;

import java.lang.reflect.Array;

public class HashTable<K, V> {

    private static final int MAX_MAP_SIZE = 5;
    private HashItem<K, V>[] hashTable;
    private int size;
    private int capacity;

    public HashTable() {
        hashTable = (HashItem<K, V>[]) Array.newInstance(HashItem.class, MAX_MAP_SIZE);
        capacity = MAX_MAP_SIZE;
    }

    // used in resizing
    private HashTable(int capacity) {
        hashTable = (HashItem<K, V>[]) Array.newInstance(HashItem.class, capacity);
        this.capacity = capacity;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        if (size >= capacity * 0.75) {
            resize(2 * capacity);
        }
        var index = hash(key);
        while (hashTable[index] != null) {
            if (hashTable[index].getKey()
              .equals(key)) {
                hashTable[index].setValue(value);
                return;
            }
            index = (index + 1) % capacity;
        }
        hashTable[index] = new HashItem<>(key, value);
        size++;
    }

    public V get(K key) {
        var index = hash(key);
        while (hashTable[index] != null) {
            if (hashTable[index].getKey()
              .equals(key)) {
                return hashTable[index].getValue();
            }
            index = (index + 1) % capacity;
        }
        return null;
    }

    public V remove(K key) {
        var index = hash(key);
        while (!hashTable[index].getKey()
          .equals(key)) {
            index = (index + 1) % capacity;
        }
        V toReturn = hashTable[index].getValue();
        hashTable[index] = null;
        size--;
        while (hashTable[index = (index + 1) % capacity] != null) {
            var nextItem = hashTable[index];
            hashTable[index] = null;
            size--;
            put(nextItem.getKey(), nextItem.getValue());
        }
        return toReturn;
    }

    private void resize(int newCap) {
        var tempMap = new HashTable<K, V>(capacity);
        for (int i = 0; i < capacity; i++) {
            if (hashTable[i] != null) {
                tempMap.put(hashTable[i].getKey(), hashTable[i].getValue());
            }
        }
        this.hashTable = tempMap.hashTable;
        capacity = newCap;
    }

}