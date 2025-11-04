/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashtableex;

/**
 *
 * @author ziping
 */
public interface JavaHashTable<K, V> {
    boolean Insert(K key, V value);
    Entry<K,V> Lookup(K key);
    Entry<K,V> Remove(K key); 
    
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
