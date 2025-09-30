/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectionsapp;
import java.util.*; 
/**
 *
 * @author zliu
 */
public class Book implements Cloneable{
    public int id;
    public String name;
    
    public Book(int id, String name){
        this.id = id;
        this.name = name;    
    }
    
    public int getID(){return id;}
    
    public String getName(){return name;}
    
    public void set(int id, String name)
    {
        this.id = id;
        this.name = name;           
    }
    
    @Override
    public Object clone()throws CloneNotSupportedException{
        return (Book)super.clone();
    }
    
    @Override
    public String toString(){
        return id + "-" + name;
    }   
    
    @Override
    public boolean equals(Object o){
        Book b = (Book)o;
        return (id == b.id && name.equals(b.name));
    }
}

/*class Sortbyroll implements Comparator<Book> 
{ 
    // Used for sorting in ascending order of id 
    public int compare(Book a, Book b) 
    { 
        return a.id - b.id; 
    } 
} 
  
class Sortbyname implements Comparator<Book> 
{ 
    // Used for sorting in ascending order of name 
    public int compare(Book a, Book b) 
    { 
        return a.name.compareTo(b.name); 
    } 
}*/

class CustomerSortingComparator implements Comparator<Book> { 
  
        @Override
        public int compare(Book customer1, Book customer2) { 
  
            // for comparison 
            int NameCompare = customer1.getName().compareTo(customer2.getName()); 
            int idCompare = new Integer(customer1.getID()).compareTo(customer2.getID()); 
  
            // 2-level comparison using if-else block 
            if (NameCompare == 0) { 
                return ((idCompare == 0) ? NameCompare : idCompare); 
            } else { 
                return NameCompare; 
            } 
        } 
    } 

