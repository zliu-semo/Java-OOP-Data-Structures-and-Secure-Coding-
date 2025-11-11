/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagenericex2;
/**
 *
 * @author ziping
 */
public class measurementGeneric <T, U extends Number> {
    private T type;
    private U measurement;
	
    public T getType(){
    	return this.type;
    }

    public U getMeasurement(){
    	return this.measurement;
    }   
    
    public void setType(T t1){
    	this.type=t1;
    } 
 
    public void setMeasurement(U u1){
    	this.measurement=u1;
    } 

    @Override
    public String toString(){
        return type.toString() + "\t" + measurement.toString();
    }
}
