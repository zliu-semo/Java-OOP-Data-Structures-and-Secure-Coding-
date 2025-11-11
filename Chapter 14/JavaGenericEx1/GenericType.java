/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagenericex1;

/**
 *
 * @author ziping
 */
public class GenericType<T> {
    private T t;
	
    public T get(){
    	return this.t;
    }
	
    public void set(T t1){
    	this.t=t1;
    }    
}

