/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinkedlistex4;

/**
 *
 * @author ziping
 */
public class Car implements TCloneable{
    private String name, color;
    
    public Car(String name, String color){
        this.name = name;
        this.color = color;        
    }
    
    @Override
    public Object clone(){
        Car cpy = new Car(name, color);
        return cpy;
    }
    
    @Override
    public String toString(){
        return name + "-" + color;
    }
    
    @Override
    public boolean equals(Object o){
        return (name.equals(((Car)o).name) && color.equals(((Car)o).color));
    }
}
