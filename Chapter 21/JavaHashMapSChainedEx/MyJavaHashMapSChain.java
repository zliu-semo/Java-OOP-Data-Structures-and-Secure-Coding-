/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashmapschainex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author ziping
 * @param <K>
 * @param <V>
 */
public class MyJavaHashMapSChain <K, V> implements JavaHashMap<K, V> {
    private final int capacity;
    private int size;
    private final LinkedList<JavaHashMap.Entry<K, V>>[] table;
    
    public MyJavaHashMapSChain(int capacity) {
        this.capacity = capacity;
        size = 0;
        table = (LinkedList<JavaHashMap.Entry<K, V>>[])new LinkedList[this.capacity];
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
        for(LinkedList<JavaHashMap.Entry<K, V>> l : table)
            if(l != null && l.size() > 0) {
                for(JavaHashMap.Entry<K, V> e : l)
                    if(e != null && e.getValue().equals(value))
                        return true;
            }
        return false;
    }
    
    @Override
    public V get(K key) {
        int index = hash(key);
        if(table[index] == null || table[index].size() == 0)
            return null;
        
        for(JavaHashMap.Entry<K, V> e : table[index]) {
            if(e != null && e.getKey().equals(key))        
                return e.getValue();
        }  
        
        return null;        
    }
    
    // using separate chaining for key collision
    // returns null if newly added key-value pair, or old value if key exists    
    @Override
    public V put(K key, V value) {
        int index = hash(key);
        // if key-value pair exists, updates the value
        if(containsKey(key))
            for(JavaHashMap.Entry<K, V> e : table[index])
                if(e.getKey().equals(key)){
                    V var = e.value;
                    e.value = value;
                    return var;
                }
         
        // if no such key, creates a new linkedlist
        if(table[index] == null) 
            table[index] = new LinkedList();

        // add the new key-value pair to the respective linkedlist
        JavaHashMap.Entry<K, V> e = new JavaHashMap.Entry<>(key, value);
        table[index].add(e);
        size++;
        return null;
    }
    
    // removes the first entry with the matching key
    @Override
    public V remove(K key) {
        if(containsKey(key)) {
            int index = hash(key);
            for(JavaHashMap.Entry<K, V> e : table[index]) {
                if(e != null && e.getKey().equals(key)){
                    size--;
                    V temp = e.getValue();
                    table[index].remove(e);
                    return temp;
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean remove(K key, V value) {
        if(containsKey(key)) {
            int index = hash(key);
            for(JavaHashMap.Entry<K, V> e : table[index]) {
                if(e != null && e.getKey().equals(key) && e.getValue().equals(value)){
                    size--;
                    table[index].remove(e); 
                    return true;
                }
            }           
        }
        return false;
    }
    
    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if(containsKey(key)) {
            int index = hash(key);
            for(JavaHashMap.Entry<K, V> e : table[index]) {
                if(e != null && e.getKey().equals(key) && e.getValue().equals(oldValue))
                {
                    e.value = newValue;
                    return true;
                }
            }
        }
        return false;
    }    
    
    @Override
    public Set<JavaHashMap.Entry<K, V>> entrySet() {
        Set<JavaHashMap.Entry<K, V>> setVar = new HashSet<>();
        for(LinkedList<JavaHashMap.Entry<K, V>> l : table)
            if(l != null) {
                for(JavaHashMap.Entry<K, V> e : l)
                    if(e != null)
                        setVar.add(e);
            }        

        return setVar;
    }  
    
    @Override
    public Set<K> keySet() {
        Set<K> setVar = new HashSet<>();
        for(LinkedList<JavaHashMap.Entry<K, V>> l : table)
            if(l != null)
                for(JavaHashMap.Entry<K, V> e : l)
                    if(e != null)
                        setVar.add(e.getKey());     
        return setVar;        
    }
    
    @Override
    public Collection<V> values() {
        Collection<V> clVar = new ArrayList<>();
        for(LinkedList<JavaHashMap.Entry<K, V>> l : table)
            if(l != null) {
                for(JavaHashMap.Entry<K, V> e : l)
                    if(e != null)
                        clVar.add(e.getValue());
            }         

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
        for(LinkedList<JavaHashMap.Entry<K, V>> l : table)
            if(l != null)
                l.clear();

        size = 0;
    } 
    
    // utility method to output all chains
    public void outputChains(){
        int index = 0;
        for(LinkedList<JavaHashMap.Entry<K, V>> l : table){
            if(l != null && l.size() > 1)
                System.out.println(index + ": " + l); 
            index++;
        }
    }
}
