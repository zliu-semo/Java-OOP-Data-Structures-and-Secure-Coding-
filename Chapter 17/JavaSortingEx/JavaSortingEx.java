/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasortingex;

/**
 *
 * @author ziping
 */
public class JavaSortingEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyArray<Integer> A = new MyArray(Integer.class);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            A.Insert((int)(Math.random() * (999 - 0)), i);
        System.out.println("BubbleSort");
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(A.get(i) + ", ");
        System.out.println();
        A.BubbleSort();
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(A.get(i) + ", ");
        System.out.println();
        
        MyArray<Integer> B = new MyArray(Integer.class);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            B.Insert((int)(Math.random() * (999 - 0)), i);
        System.out.println("\nInsertionSort");        
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(B.get(i) + ", ");
        System.out.println();        
        B.InsertionSort();
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(B.get(i) + ", ");
        System.out.println();
        
        MyArray<Integer> C = new MyArray(Integer.class);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            C.Insert((int)(Math.random() * (999 - 0)), i);
        System.out.println("\nSelectionSort");         
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(C.get(i) + ", ");
        System.out.println();        
        C.SelectionSort();
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(C.get(i) + ", ");
        System.out.println(); 
        
        /*  MyArray<Integer> D = new MyArray(Integer.class);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            D.Insert((int)(Math.random() * (999 - 0)), i);
        System.out.println("\nShellSort");         
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(D.get(i) + ", ");
        System.out.println();        
        D.ShellSort();
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(D.get(i) + ", ");
        System.out.println();   */   
        MyArray<Integer> D = new MyArray(Integer.class);
        D.Insert(69, 0);
        D.Insert(35, 1);
        D.Insert(18, 2);
        D.Insert(87, 3);
        D.Insert(50, 4);
        D.Insert(58, 5);
        D.Insert(79, 6);
        System.out.println("\nShellSort");         
        for(int i = 0; i < D.size(); i++)
            System.out.print(D.get(i) + ", ");
        System.out.println();        
        D.ShellSort();
        for(int i = 0; i < D.size(); i++)
            System.out.print(D.get(i) + ", ");
        System.out.println();
            
        
        MyArray<Integer> E = new MyArray(Integer.class);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            E.Insert((int)(Math.random() * (999 - 0)), i);
        System.out.println("\nQuickSort");         
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(E.get(i) + ", ");
        System.out.println();        
        E.Quicksort(0, E.size() - 1);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(E.get(i) + ", ");
        System.out.println();  
        
        
        MyArray<Integer> F = new MyArray(Integer.class);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            F.Insert((int)(Math.random() * (999 - 0)), i);
        System.out.println("\nMergeSort");         
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(F.get(i) + ", ");
        System.out.println();        
        F.MergeSort(Integer.class, 0, F.size() - 1);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(F.get(i) + ", ");
        System.out.println(); 
    }

}
