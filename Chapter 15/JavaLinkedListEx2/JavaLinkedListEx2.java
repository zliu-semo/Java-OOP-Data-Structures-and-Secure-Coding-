/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinkedlistex2;

import java.util.Iterator;
/**
 *
 * @author ziping
 */
public class JavaLinkedListEx2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Car> listOfCars = new LinkedList<>();
        Car one = new Car("default", "default");
        listOfCars.insertAfter(null, one);
        System.out.println(listOfCars);
        listOfCars.insertAfter(one, new Car("car1", "red"));
        listOfCars.insertAfter(one, new Car("car2", "blue"));  
        listOfCars.insertAfter(one, new Car("car3", "green"));
        listOfCars.insertAfter(one, new Car("car4", "black"));
        listOfCars.insertAfter(one, new Car("car5", "grey"));
        System.out.println(listOfCars);   
        
        LinkedList<Car> listOfCars2 = listOfCars.copylist();
        if(listOfCars2.equals(listOfCars))
            System.out.println("\nsecond list: " + listOfCars2);
        
        if(listOfCars.contains(new Car("car4","black")))
            listOfCars.remove(new Car("car4","black"));
        one.setCar("newCar", "newColor");
        System.out.println("\nafter removing one car and updating the first car, the first list:\n" + listOfCars);
        System.out.println("second list: " + listOfCars2);
        
        System.out.println("\nthe first car in the first list: " + listOfCars.get(0));
        
        System.out.println("\nthe list of cars using iterator for loop:");
        Iterator itr = listOfCars.iterator();
        //explicitly using external iterator to loop
        while(itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();

        System.out.println("\nthe list of cars using for each loop:");
        //for-each loop using external iterator implicitly
        for(Object x : listOfCars)
            System.out.print(x + " ");
        System.out.println();   
 
        /*
        * Knowledge Check 1 for Java LinkedList Class Using Iterable 
        */        
        listOfCars.insertAsSecond(new Car("car6", "purple"));
        System.out.println(listOfCars);
     }
}
