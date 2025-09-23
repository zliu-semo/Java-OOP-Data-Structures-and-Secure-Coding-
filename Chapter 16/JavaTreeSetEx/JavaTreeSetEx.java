/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatreesetex;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author ziping
 */
public class JavaTreeSetEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
	System.out.println("Test of TreeSet"); 
	int num;
	TreeSet<Integer> tree = new TreeSet<>();	

        Scanner scanner = new Scanner(new File("intData.txt"));
        while(scanner.hasNextInt())
        {
             num = scanner.nextInt();
             tree.add(num);
        }
           
        // using iterator to traverse
        Iterator<Integer> iterate = tree.iterator();
        System.out.print("TreeSet using Iterator: ");
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
        
        System.out.println("\nThe number of items in the treeset: " + tree.size());
        System.out.println("The first item in the treeset: " + tree.first());
        System.out.println("The last item in the treeset: " + tree.last());
        System.out.println("The lowest number greater than 50: " + tree.higher(50));
        System.out.println("The highest number less than 50: " + tree.lower(50));
        System.out.println("The lowest number greater than or equal to 50: " + tree.ceiling(50));
        System.out.println("The highest number less than or equal to 50: " + tree.floor(50));
        System.out.println("All numbers before 55(not including): " + tree.headSet(55));
        System.out.println("All numbers after 60(including): " + tree.tailSet(60));
        System.out.println("All numbers before 55(including): " + tree.headSet(55, true));
        System.out.println("All numbers after 60(not including): " + tree.tailSet(60, false));
        System.out.println("Numbers between 55 included to 65 excluded:" + tree.subSet(55, 65));
        System.out.println("Numbers between 55 excluded to 65 included:" + tree.subSet(55, false, 65, true));
        
	// Test Delete
	System.out.println("\nTest of Delete operation."); 
        scanner = new Scanner(System.in);
	for (;;){
            System.out.println("Enter positive integer to delete from tree or 0 to quit");
            num = scanner.nextInt();
		
            if (num == 0) break;
		
            if (tree.remove(num))
		System.out.println(num + " deleted from tree.");
            else
                System.out.println(num + " not found in tree.");
			
            // Double check with call to Search
            System.out.println("Double check that number is not in tree.");		
            if (tree.contains(num))
		System.out.println(num + " still in tree.");
            else
		System.out.println(num + " not in tree.");
            
            System.out.println("The tree is:" + tree);
	}
    }
}
