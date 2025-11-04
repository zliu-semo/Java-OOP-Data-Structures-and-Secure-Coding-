/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashmapschainex;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author ziping
 */
public interface JavaHashMap <K, V> {
    boolean containsKey(K key);
    boolean containsValue(V value);
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    boolean remove(K key, V value);  
    boolean replace(K key, V oldValue, V newValue);    
    Set<JavaHashMap.Entry<K, V>> entrySet();    
    Set<K> keySet();
    Collection<V> values();
    int size();
    boolean isEmpty();   
    void clear();    

    public static class Entry<K, V> {
        K key;
        V value;
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}
