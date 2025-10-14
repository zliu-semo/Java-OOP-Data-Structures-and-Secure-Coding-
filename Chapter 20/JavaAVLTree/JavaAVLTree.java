/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaavltree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author ziping
 */
public class JavaAVLTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
	System.out.println("Test of AVL Tree"); 
	int num;
	AVLTree<Integer> tree = new AVLTree<>();	

        Scanner scanner = new Scanner(new File("intData.txt"));
        while(scanner.hasNextInt())
        {
             num = scanner.nextInt();
             tree.Insert(num);
        }

        System.out.println("Inorder traversal result:");
        tree.Inorder();
        
        System.out.println("\nPreorder traversal result:");
 	tree.Preorder();
        
        System.out.println("\nPostorder traversal result:");
 	tree.Postorder(); 
        
        System.out.println("\nThe tree is:");
        tree.print();
        
	// Test Delete
	System.out.println("\nTest of Delete operation."); 
        scanner = new Scanner(System.in);
	for (;;){
            System.out.println("\n\nEnter positive integer to delete from tree or 0 to quit");
            num = scanner.nextInt();
		
            if (num == 0) break;

            if(tree.Search(num)){
		System.out.println(num + " deleted from tree.");
                tree.Delete(num);
            }
            else
                System.out.println(num + " not found in tree.");
			
            // Double check with call to Search
            System.out.println("\nDouble check that number is not in tree.");		
            if (tree.Search(num))
		System.out.println(num + " still in tree.");
            else
		System.out.println(num + " not in tree.");
            
            tree.print();
	}
	
	System.out.println("Test of AVL Tree terminated normally.");
        
        tree.printLevelOrder();

    }  
}
