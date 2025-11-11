/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagenericstackex;

/**
 *
 * @author ziping
 */
public class JavaGenericStackEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++)
            stack.push(i); 
        System.out.println("8 is in the stack? " + searchItem(stack,8)); 
        System.out.println("100 is in the stack? " + searchItem2(stack,100));
        System.out.println(stack);
        
        Stack<Double> stackd = new Stack<>();
        for (int i = 0; i < 10; i++)
            stackd.push(i + 0.9); 
        System.out.println("8 is in the stackd? " + searchItem(stackd,8.9)); 
        System.out.println("100 is in the stackd? " + searchItem2(stackd,100.9));
        System.out.println(stackd);        
        
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < 10; i++)
          stack2.push(i);   

        if(stack.compareTo(stack2) == -1)
            System.out.println("stack is smaller");
        else
            System.out.println("stack is not smaller");
        
        String sentence = "Was it a cat I saw?";
        String cleanedSentence = cleanSentence(sentence);
        boolean flag = cleanedSentence.equals(reverseSentence(cleanedSentence));
        System.out.println("the sentence is palindrome? " + flag);   
    }

    //search method won't change the plugged in stack
    @SuppressWarnings("unchecked") //for stackClone = (Stack<? extends Number>)stack.clone();
    public static boolean searchItem(Stack<? extends Number> stack, Number num){
        /*Stack<? extends Number> stackClone; //wildcards type can be used for parameterized type
        try{        	
            stackClone = (Stack<? extends Number>)stack.clone();

            while(!stackClone.empty()){
                if(stackClone.peek().equals(num))
                    return true;
                stackClone.pop();
            }
        }
        catch(CloneNotSupportedException ex){
            System.out.println(ex);
        }
        return false; */ 
        
    	//call copy constructor to create a copy
        Stack<? extends Number> stackClone = new Stack<>(stack); 
        while(!stackClone.empty()){
                if(stackClone.peek().equals(num))
                    return true;
                stackClone.pop();
        }

        return false;          
    }  
    
    public static boolean searchItem2(Stack<? extends Number> stack, Number num){
        for(Number i:stack)
            if(i.equals(num))
                return true;
        return false;  
    }     
    
    public static String cleanSentence(String s){
        StringBuilder retStr = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            if(Character.isLetter(s.charAt(i))||Character.isDigit(s.charAt(i)))
                retStr.append(Character.toLowerCase(s.charAt(i)));
        
        return retStr.toString();            
    }

    public static String reverseSentence(String s){
        Stack<Character> charStack = new Stack<>();
        StringBuilder reverseStr = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            charStack.push(s.charAt(i));
            
        while(!charStack.empty()){
            reverseStr.append(charStack.peek());
            charStack.pop();
        }
        
        return reverseStr.toString();
    }  
}
