/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagenericboundedwildcardsex3;
import java.util.ArrayList;
import animal.Animal;
import animal.Pet;
import animal.Wildlife;
/**
 *
 * @author ziping
 */
public class JavaGenericBoundedWildcardsEx3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Animal> arr1 = new ArrayList<>();        
        Animal a1 = new Animal("Eagle", 19.9, 3.8, 55.5);
        arr1.add(a1);
        arr1.add(new Wildlife());
        
        //arr1 is of Animal type List, and Animal is super type of Wildlife
        addAnimals(arr1, new Wildlife());
        Wildlife w1 = new Wildlife("Wolf", 10.9, 3.0, 15.5, "forest");
        addAnimals(arr1, w1);
        System.out.println("after calling addAnimals( ):");
        //print allows any type
        printList(arr1);
        
        ArrayList<Pet> arr2 = new ArrayList<>();
        arr2.add(new Pet());
        Pet p1 = new Pet("Gold fish", 0.1, 0.1, 0.1, "Mary");      
        Pet p2 = new Pet("Gold fish2", 0.11, 0.11, 0.11, "Mary2"); 
        arr2.add(p1);
        arr2.add(p2);
        //arr2 is of Pet type List, and Pet is sub type of Animal
        removeAnimals(arr2, p1);
        System.out.println("after calling removeAnimals( ):");        
        //print allows any type
        printList(arr2);
        
        //Knowledge check 1: wildcards type
        arr1.addAll(arr2);
        findAnimals(arr1,p2);
        
        //addAnimals2(arr2, new Wildlife());     
    }

    //lower bounded wildcards: allows any type of Wildlife or its super type
    public static void addAnimals(ArrayList<? super Wildlife> list, Wildlife w){
        list.add(w);
    }
    
    //upper bounded wildcards: allows any type of Animal or its sub type
    public static void removeAnimals(ArrayList<? extends Animal> list, Pet p){
        list.remove(p);
    }     
    
    //public static void printList(ArrayList<Object> list){//option 1: only allows Object instances
    //unbounded wildcards
    public static void printList(ArrayList<?> list){//option 2: allows any type
        for(Object e: list)
            System.out.println(e + " ");
        System.out.println();
    } 
    
    public static void addAnimals2(ArrayList<Animal> list, Wildlife w){
        list.add(w);
    }   
    
    //Knowledge check 1: wildcards type
    public static void findAnimals(ArrayList<? extends Animal> list, Pet p){
        System.out.printf("Faster than %s%n", p.getName());
        for(Animal a:list){
            if(a.getMaxSpeed() > p.getMaxSpeed())
                System.out.print(a.getName());
        }
        
    } 
}
