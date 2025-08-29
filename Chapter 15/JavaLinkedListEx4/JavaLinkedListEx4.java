/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinkedlistex4;

import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author ziping
 */
public class JavaLinkedListEx4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Car> listOfCars = new LinkedList<>();
        Car one = new Car("default", "default");
        listOfCars.add(one);
        System.out.println(listOfCars);
        listOfCars.add(new Car("car1", "red"));
        listOfCars.add(new Car("car2", "blue"));  
        listOfCars.add(new Car("car3", "green"));
        listOfCars.add(new Car("car4", "black"));
        listOfCars.add(new Car("car5", "grey"));
        System.out.println(listOfCars);   
        
        //collection's linkedlist clone( ) is a deep copy
        LinkedList<Car> listOfCars2 = (LinkedList<Car>)listOfCars.clone();
        if(listOfCars2.equals(listOfCars))
            System.out.println("\nsecond list: " + listOfCars2);
        
        if(listOfCars.contains(new Car("car4","black")))
            listOfCars.remove(new Car("car4","black"));
        System.out.println("\nafter removing one car, the original list: " + listOfCars);
        System.out.println("\nafter removing one car, the cloned list: " + listOfCars2);
        
        System.out.println("\nthe first car: " + listOfCars.get(0));
        
        System.out.println("\nthe list of cars using iterator for loop:");
        Iterator itr = listOfCars2.iterator();
        //explicitly using external iterator to loop
        while(itr.hasNext()){
            Car x = (Car)itr.next();
            System.out.print(x + " ");
            if(x.equals(new Car("car3", "green")))
                itr.remove();  //loop will not be terminated  */          
        }
        System.out.println();

        System.out.println("\nthe list of cars using for each loop:");
        //for-each loop using external iterator implicitly
        for(Object x : listOfCars2){
            System.out.print(x + " ");
            if(x.equals(new Car("car3", "green"))){
                System.out.println("car 3 is not removed");
                listOfCars2.remove(x); //loop will not be terminated
            }                
        }
        System.out.println(); 
        
        // java.util.stream: A sequence of elements supporting sequential 
        // and parallel aggregate operations.
        System.out.println("\nthe list of cars using forEach:");
        listOfCars.stream().forEach(e -> System.out.printf("%s, ", e));  
        
        System.out.println("\n\nthe list of cars that is grey color:");
        listOfCars.stream().filter(
                e -> e.equals(new Car("car5", "grey"))).forEach(
                e -> System.out.printf("%s, \n", e.toString().toUpperCase()));     
    }
}
