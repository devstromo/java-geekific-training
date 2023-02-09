package com.devstromo.maps.chaining;

import java.lang.reflect.Array;

public class HashTable<K, V> {

    private static final int MAX_MAP_SIZE = 5;
    private final HashItem<K, V>[] hashTable;
    private int size;

    public HashTable() {
        hashTable = (HashItem<K, V>[]) Array.newInstance(HashItem.class, MAX_MAP_SIZE);
    }

    private int hash(K key) {
        return key.hashCode() % MAX_MAP_SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        var item = hashTable[index];
        while (item != null) {
            if (item.getKey()
              .equals(key)) {
                item.setValue(value);
                return;
            }
            item = item.getNextHashItem();
        }
        var hashItem = new HashItem<K, V>(key, value);
        hashItem.setNextHashItem(hashTable[index]);
        hashTable[index] = hashItem;
        size++;
    }

    public V get(K key) {
        var index = hash(key);
        var item = hashTable[index];
        while (item != null) {
            if (item.getKey()
              .equals(key)) {
                return item.getValue();
            }
            item = item.getNextHashItem();
        }
        return null;
    }

    public V remove(K key) {
        var index = hash(key);
        var item = hashTable[index];
        HashItem<K, V> prev = null;
        while (item != null) {
            if (item.getKey()
              .equals(key)) {
                break;
            }
            prev = item;
            item = item.getNextHashItem();
        }
        if (item == null)
            return null;
        if (prev == null) {
            hashTable[index] = item.getNextHashItem();
        } else {
            prev.setNextHashItem(item.getNextHashItem());
        }
        size--;
        return item.getValue();
    }

}
