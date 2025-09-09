/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabigohex;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author ziping
 */
public class JavaBigOhEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        int size;
        int i;
        double preTime = 0;

        for(i=5;i <= 1280; i=2*i)
        {
            size = 100 * i;
            MyArray<Integer> A = new MyArray(Integer.class, size);
            for(int j = 0; j < MyArray.CAPACITY; j++)
                A.Insert((int)(Math.random() * (90000 - 0)), j);  
            
            long start = Instant.now().toEpochMilli();
            //A.BubbleSort();
            //A.SelectionSort();
            //A.InsertionSort();
            //A.ShellSort();
            A.MergeSort(Integer.class, 0, A.size() - 1);
            //A.Quicksort(0, A.size() - 1);
            long end = Instant.now().toEpochMilli();
            long elapsed = (end - start);
            System.out.println("Elapsed time in milliseconds: " + elapsed);

            if (i > 5){
                System.out.println("N = " + size + ": time for sort was " + elapsed);

                if (preTime > 0)  
                    System.out.println("            time(N) / time(N/2) is: " + elapsed / preTime);
                else
                    System.out.println("            time(N) / time(N/2) is: 1");
            }

            preTime = elapsed;
          }

          System.out.println("\nTest of sorts ended normally.\n");
    }

                    

}
