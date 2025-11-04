/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashtableex;

import java.util.LinkedList;

/**
 *
 * @author ziping
 * @param <K>
 * @param <V>
 */
public class MyHashTable<K, V> implements JavaHashTable<K, V> {
    private final int capacity;
    
    private final LinkedList<Entry<K, V>>[] buckets;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
    }
    
    @Override
    public boolean Insert(K key, V value) {
        int index = key.hashCode() % capacity;
        if(buckets[index] == null)
            buckets[index] = new LinkedList();
        Entry<K,V> e = Lookup(key);
        if(e != null)
            if(!e.getValue().equals(value)) {
                e.value = value;
                return true;
            }
            else
                return false;
        buckets[index].add(new Entry(key, value));
        return true;
    }
    
    @Override
    public Entry<K,V> Lookup(K key) {
        int index = key.hashCode() % capacity;
        if(buckets[index] == null)
            return null;
        for(Entry<K, V> e : buckets[index])
            if(e.getKey().equals(key))
                return e;
        return null;
    }
    
    @Override
    public Entry<K, V> Remove(K key) {
        int index = key.hashCode() % capacity;
        if(buckets[index] == null)
            return null;
        
        for(Entry<K, V> e : buckets[index])
            if(e.getKey().equals(key)){
                buckets[index].remove(e);
                return e;
            }
        return null;   
    }
    
    @Override
    public String toString() {
        String retStr = "";
        for(LinkedList<Entry<K, V>> e : buckets)
            retStr = retStr + e + "\n";
        return retStr;
    }
}
