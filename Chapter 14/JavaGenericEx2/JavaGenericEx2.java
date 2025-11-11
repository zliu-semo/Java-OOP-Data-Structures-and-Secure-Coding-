/*
    Bounded type
 */
package javagenericex2;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author ziping
 */
public class JavaGenericEx2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        measurementGeneric<String, Integer> var1 = new measurementGeneric<String, Integer>();
        var1.setMeasurement(100); 
        //var1.setMeasurement(new Integer(100)); 
        var1.setType("Books");
        System.out.println(var1);
        
        measurementGeneric<Boolean, Integer> var2 = new measurementGeneric<Boolean, Integer>();
        var2.setMeasurement(new Integer(1)); 
        var2.setType(true);
        System.out.println(var2);         

        //measurementGeneric<Integer, String> var3; //error, second type argument is not a subclass/class of Number
        measurementGeneric<String, Float> var3 = new measurementGeneric<String, Float>();
        var3.setMeasurement(new Float(9.99)); 
        var3.setType("Price");
        System.out.println(var3); 
        
        Integer[] intArr = {100, 200, 500, 400, 300, 600, 800, 700};
        System.out.println("ascending order? " + isAscending(intArr));

        String[] strArr = {"aaa", "AAA", "BBB", "bbb", "cba", "CBA"};
        System.out.println("ascending order? " + isAscending(strArr));

        //knowledge checks 1 for Bounded Generic Type        
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(strArr));  
        outputOneByOne(arrayList);
    }
    
    //public static<T> int countGreaterThan(T[] anArray, T elem){//option #1
    //following is option #2: bounded type, then error went away
    public static<T extends Comparable<T>> boolean isAscending(T[] anArray){
        for(int i = 0; i < anArray.length - 1; i++)
            //if(anArray[i] > anArray[i+1])//with option #1, generic type can cause compiling error
            if(anArray[i].compareTo(anArray[i+1])>0){
                return false;
            }
        
        return true;
    }
    
    //knowledge checks 1 for Bounded Generic Type
    public static<U,T extends Iterable<U>> void outputOneByOne(T var){
        for(U s:var){
            System.out.print(s+" ");
        }
    }
}
