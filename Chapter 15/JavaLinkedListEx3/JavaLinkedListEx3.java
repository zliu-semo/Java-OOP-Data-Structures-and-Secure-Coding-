/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinkedlistex3;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author ziping
 */
public class JavaLinkedListEx3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Car> listOfCars = new LinkedList<>();
        Car one = new Car("default", "default");
        listOfCars.add(0,one);
        System.out.println("add one car in the list: " + listOfCars);
        listOfCars.add(1,new Car("car1", "red"));
        listOfCars.add(2,new Car("car2", "blue"));  
        listOfCars.add(3,new Car("car3", "green"));
        listOfCars.add(4,new Car("car4", "black"));
        listOfCars.add(1,new Car("car5", "grey"));
        System.out.println("add five more cars in the list: \n"+listOfCars);   
        
        if(listOfCars.contains(new Car("car2", "blue")))
            listOfCars.remove(new Car("car2", "blue"));
        //listOfCars.remove(2);
        one.setCar("newCar", "newColor");
        System.out.println("\nafter removing one car and updating the first car, "
                            + "the list:\n" + listOfCars);
        
        System.out.println("\nthe first car in the list: " + listOfCars.get(0));
        
        System.out.println("\nthe index of the car: " 
                + listOfCars.indexOf(new Car("car1", "red")));

        System.out.println("\nthe list of cars using for each loop:");
        //for-each loop using external iterator implicitly
        for(Object x : listOfCars)
            System.out.print(x + " ");
        System.out.println(); 
        
        System.out.println("\nthe list of cars using iterator for loop:");
        //Iterator itr = listOfCars.iterator();
        ListIterator itr = listOfCars.listIterator(0);
        //explicitly using external iterator to loop
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println(); 

        itr = listOfCars.listIterator(4);
        System.out.println("\nthe list of cars using listIterator reversing for loop:");        
        while(itr.hasPrevious()){
            System.out.print(itr.previous( ) + " "); 
        }
        
        System.out.println("\n\ncall iterator's remove():"); 
        itr = listOfCars.listIterator();
        //explicitly using external iterator to loop
        while(itr.hasNext()){
            Car c = (Car)itr.next();
            if(c.equals(new Car("car5", "grey")))
                itr.remove();
            System.out.print(c + " ");
        }
        System.out.println("\nthe list of cars after iterator's remove():"); 
        System.out.println(listOfCars);  
        
        System.out.println("\ncall iterator's add():"); 
        itr = listOfCars.listIterator();
        //explicitly using external iterator to loop
        while(itr.hasNext()){
            Car c = (Car)itr.next();
            if(c.equals(new Car("car1", "red")))
                itr.add(new Car("newCar2", "newColor2"));           
            System.out.print(c + " ");
        }
        System.out.println("\nthe list of cars after iterator's add():"); 
        System.out.println(listOfCars);          
    }    
}
