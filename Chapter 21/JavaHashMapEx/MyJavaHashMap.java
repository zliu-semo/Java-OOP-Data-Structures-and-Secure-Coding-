/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashmapex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ziping
 * @param <K>
 * @param <V>
 */
public class MyJavaHashMap<K, V> implements JavaHashMap<K, V> {
    private final int capacity;
    private int size;
    private final JavaHashMap.Entry<K, V>[] table;
    
    public MyJavaHashMap(int capacity) {
        this.capacity = capacity;
        size = 0;
        table = (JavaHashMap.Entry<K, V>[])new JavaHashMap.Entry[this.capacity];
    }
    
    private int hash(K key) {
        return (key.hashCode()  & 0x7fffffff) % capacity;
    }
    
    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    @Override
    public boolean containsValue(V value) {
        for(JavaHashMap.Entry<K, V> e : table)
            if(e != null && e.getValue().equals(value))
                return true;
        return false;
    }
    
    @Override
    public V get(K key) {
        int index = hash(key);        
        if(table[index] == null)
            return null;
        for(int i = index; i < (index + capacity); i++)
            if(table[i % capacity].getKey().equals(key))
                return table[i % capacity].getValue();
        
        return null;
    }
    
    // using linear probing for key collision
    // returns null if newly added key-value pair, or old value if key exists
    @Override
    public V put(K key, V value) {
        int index = hash(key);
        if(table[index] == null) {
            table[index] = new JavaHashMap.Entry<>(key, value);
            size++;
            return null;
        }
        else {
            for(int i = index; i < (index + capacity); i++){
                // if key exists, updates its value
                if(table[i % capacity] != null && table[i % capacity].getKey().equals(key)){
                    V temp = table[i % capacity].value;
                    table[i % capacity].value = value;
                    return temp;
                }
                
                // if key doesn't exist, adds to key-value pair
                if(table[i % capacity] == null) {
                    table[i % capacity] = new JavaHashMap.Entry<>(key, value);
                    size++;
                    //output to trace the overlapped key and linear probing clustering
                    System.out.println(index + ": " + i % capacity + " " + key.toString() + " " + value.toString());
                    return null;
                }
            }
        }
        return null;
    }
    
    @Override
    public V remove(K key) {        
        if(containsKey(key)) {
            int index = hash(key);
            for(int i = index; i < (index + capacity); i++)
                if(table[i % capacity].getKey().equals(key)){
                    V temp = table[i % capacity].getValue();
                    table[i % capacity] = null;
                    size--;
                    return temp;
                }
        }
        return null;
    }
    
    @Override
    public boolean remove(K key, V value) {
        if(containsKey(key)) {
            int index = hash(key);
            for(int i = index; i < (index + capacity); i++)
                if(table[i % capacity].getKey().equals(key) &&
                        table[i % capacity].getValue().equals(value)) {
                    table[i % capacity] = null;
                    size--;
                    return true;
                }
            
        }
        return false;
    }
    
    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if(containsKey(key)) {
            int index = hash(key);
            for(int i = index; i < (index + capacity); i++)
                if(table[i % capacity].getKey().equals(key) &&
                        table[i % capacity].getValue().equals(oldValue)) {
                    table[i % capacity] = new JavaHashMap.Entry<>(key, newValue);
                    return true;
                }
        }
        return false;
    }    
    
    @Override
    public Set<JavaHashMap.Entry<K, V>> entrySet() {
        Set<JavaHashMap.Entry<K, V>> setVar = new HashSet<>();
        for(JavaHashMap.Entry<K, V> e : table)
            if(e != null)
                setVar.add(e);
        return setVar;
    }  
    
    @Override
    public Set<K> keySet() {
        Set<K> setVar = new HashSet<>();
        for(JavaHashMap.Entry<K, V> e : table)
            if(e != null)
                setVar.add(e.getKey());
        return setVar;        
    }
    
    @Override
    public Collection<V> values() {
        Collection<V> clVar = new ArrayList<>();
        for(JavaHashMap.Entry<K, V> e : table)
            if(e != null)
                clVar.add(e.getValue());
        return clVar;
    }
    
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    } 
    
    @Override
    public void clear() {
        for(JavaHashMap.Entry<K, V> e : table)
            if(e != null)
                e = null;
        size = 0;
    }  
}
