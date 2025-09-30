/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectionmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Demonstrate Map, HashMap, SortedMap, NavigableMap and TreeMap
 * @author ziping
 */
public class JavaCollectionMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // calling methods from Set interface
        Map<Integer, Book> mp = new HashMap<>(); 
        Book[] bkArr = new Book[8];
        bkArr[0] = new Book(111, "bbbb");
        bkArr[1] = new Book(131, "aaaa");
        bkArr[2] = new Book(121, "cccc"); 
        bkArr[3] = new Book(151, "abc1");
        bkArr[4] = new Book(211, "BBBBB"); 
        bkArr[5] = new Book(231, "AAAAA"); 
        bkArr[6] = new Book(221, "CCCCC"); 
        bkArr[7] = new Book(115, "abbb");
        
        for(Book b:bkArr)
            mp.put(b.getID(), b);
        
        System.out.println("The map of books:");
        mp.forEach((i,val)->System.out.println(i + ": " + val));
        
        System.out.println("The map has book with key 115? " + mp.containsKey(115));
        System.out.println("The book with key 115 is: " + mp.get(115));
        System.out.println("The map has book abbb? " + mp.containsValue(new Book(115, "abbb")));
        System.out.println("The book with key 999 is: " + mp.getOrDefault(mp, new Book(1000, "default")));
        Set<Integer> mpSet = mp.keySet();
        System.out.println("The keys are: " + mpSet);
        Collection<Book> mpCl = mp.values();
        System.out.println("The values are: " + mpCl);
        // using lambda expr to update value
        mp.compute(115, (i, val)-> {bkArr[7].set(115, "AAAB");
                                    val = bkArr[7];
                                    return val;});        
        // using lambda expr to insert a new key-value pair
        mp.computeIfAbsent(116, (val)-> new Book(116, "abcde"));
        // the key-value pair already in map, so lambda is called to update value
        mp.merge(116, new Book(116, "abcde9"), (oldVal, newVal)->new Book(116, "abcdeX"));
        // the key-value pair not in map, so the value is taken from the second parameter
        mp.merge(117, new Book(117, "abcde7"), (oldVal, newVal)->new Book(117, "abcdeZ"));
        
        System.out.println("The map of books after updating:");
        // Map.Entry<key, value> is used for map entry
        Set<Map.Entry<Integer,Book>> mpEntry = mp.entrySet();
        for(Map.Entry<Integer, Book> m:mpEntry){
            System.out.println(m.getKey() + ": " + m.getValue());
        }
        
        // create a treemap
        NavigableMap<Integer, Book> trMap = new TreeMap<>(); 
        trMap.putAll(mp);
        System.out.println(trMap);
        
        // create a reversed order treemap
        Map<Integer, Book> trMap2 = new TreeMap<>((k1, k2)-> k2 - k1); 
        trMap2.putAll(mp);
        System.out.println(trMap2);   
        
        System.out.println("The first map entry: " + trMap.firstEntry());
        System.out.println("The last map entry: " + trMap.lastEntry());
        System.out.println("The lowest key greater than 120: " + trMap.ceilingKey(120));
        System.out.println("The lowest key greater than 120 and its map: " + trMap.ceilingEntry(120));
        System.out.println("The highest key less than 120: " + trMap.floorKey(120));
        System.out.println("The highest key less than 120 and its map: " + trMap.floorEntry(120));
        System.out.println("The lowest key greater than 120: " + trMap.higherKey(120));
        System.out.println("The lowest key greater than 120 and its map: " + trMap.higherEntry(120));
        System.out.println("View of map less than key 120: " + trMap.headMap(120));
        System.out.println("View of map greater than key 120: " + trMap.tailMap(120));
        System.out.println("View of map between key 120 to 200: " + trMap.subMap(120, 200));
        trMap.remove(117);
        System.out.println("The map has book with key 117? " + trMap.containsKey(117));
        System.out.println("The descending order of the treemap: " + trMap.descendingMap());
        // Map doesn't have stream() method, but entrySet() returns set
        // hence we can apply aggregation operations here
        System.out.println("Calling collection's stream method to filter out ID > 120:");
        trMap.entrySet().stream().filter(e -> e.getKey() > 120)
                        .map(Map.Entry::getValue)
                        .forEach(e->System.out.println(e + ", "));
        
        // LinkedHashMap preserves the insertion order
        Map<Integer, Book> lMap = new LinkedHashMap<>(); 
        for(Book b:bkArr)
            lMap.put(b.getID(), b);   
        System.out.println("The linkedhashmap of books:");
        lMap.forEach((i,val)->System.out.println(i + ": " + val));     
        
        // LinkedHashMap created with access order
        Map<Integer, Book> lMap2 = new LinkedHashMap<>(20, 0.75f, true); 
        for(Book b:bkArr)
            lMap2.put(b.getID(), b);  
        // key 211 pair is last accessed
        System.out.println("The value of key 211 is: " + lMap2.get(211));
        // map order is updated with key 211 pair moved to last
        // access order: least recently accessed -> most recently accessed
        lMap2.forEach((i,val)->System.out.println(i + ": " + val));   
    }
}
