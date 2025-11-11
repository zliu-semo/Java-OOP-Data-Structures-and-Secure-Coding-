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
public class JavaGenericEx1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	GenericType<String> g1 = new GenericType<>();
	g1.set("Computer Science hello world");
        //g1.set(100);//will be reported as error
		
	GenericType<String> g2 = new GenericType<>();
	g2.set("Java hello world");
        
	GenericType<Integer> i1 = new GenericType<>();
	i1.set(100);
		
	GenericType<Integer> i2 = new GenericType<>();
	i2.set(200);
        
        /*
        * Knowledge Check 1 for Java Generic Class  
        */   
        GenericType<Boolean> b1 = new GenericType<>();
        b1.set(true);
        System.out.println("b1 is: " + b1.get());

	boolean isEqual = JavaGenericEx1.<String>isEqual(g1, g2);
	System.out.println("g1 is equal to g2: " + isEqual);
        
    isEqual = Util.<String>compare(g1, g2);
    System.out.println("g1 is equal to g2: " + isEqual);        
        
	boolean isEqual2 = isEqual(i1, i2);
	System.out.println("i1 is equal to i2: " + isEqual2);
        
    isEqual2 = Util.compare(i1, i2);
    System.out.println("i1 is equal to i2: " + isEqual2);  
        
        // Test your Knowledge Check 2 (Java Generic Method) method here.   
        update(g2, g1);
        System.out.println("g2 is: " + g2.get());
    }
    
    //Java Generic Method
    public static <T> boolean isEqual(GenericType<T> g1, GenericType<T> g2){
    	return g1.get().equals(g2.get());	
    }    

    /*
     * Knowledge Check 2 for Java Generic Method:
     */
    public static <T> void update(GenericType<T> var1, GenericType<T> var2){
    	var1.set(var2.get());	
    }       
    
}
