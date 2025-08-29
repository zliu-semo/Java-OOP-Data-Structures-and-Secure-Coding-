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
public class MyArray<T extends Comparable<T>> {
    private T[] arr;
    private int size;
    public static final int CAPACITY = 15;
    
    public MyArray(Class<T> type){
        // needs to use reflect.Array.newInstance( ) to initiate 
        // an array of bounded type
        arr = (T[]) java.lang.reflect.Array.newInstance(type, CAPACITY);
    }
    
    public T get(int index){
        return arr[index];
    }
    
    public int size(){
        return size;
    }
    
    public void Insert(T item, int index){
	if (size + 1 > CAPACITY) 
            throw new ArrayIndexOutOfBoundsException();
	else if (index > size)
            throw new ArrayIndexOutOfBoundsException();
	else{
            for (int i = size; i > index + 1;  i--)
		arr[i] = arr[i-1];
		
            arr[index] = item;
            size++;
	}
    }	
    
    public void Delete(int index){
	if (index > size - 1)
            throw new ArrayIndexOutOfBoundsException();
	else{
            for (int i = index; i < size - 1;  i++)
		arr[i] = arr[i+1];
			
            size--;
	}
    }
    
    public void BubbleSort(){
	boolean Sorted = false;
	
	while (!Sorted){
            Sorted = true;
            for (int i = 0; i < size - 1; i++)
		if (arr[i].compareTo(arr[i+1]) > 0){
                    T temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    Sorted = false;
		}			
	}        
    }
    
    public void SelectionSort(){
	int best;
	for (int i = 0; i < size-1;  i++){
            best = i;
            for (int j = i+1;  j < size;  j++)
		if (arr[best].compareTo(arr[j]) > 0)
                    best = j;
				
            if (i != best){//swap the two items
                T temp = arr[i];
                arr[i] = arr[best];
                arr[best] = temp;
            }
	}        
    }
    
    public void InsertionSort(){
	int key, location;
	T temp;

	for(key = 1; key < size; key++){
            if(arr[key].compareTo(arr[key - 1]) < 0){
		temp = arr[key];
		location = key;

		do //right shift all elements that are greater than key element one slot
		{
                    arr[location] = arr[location - 1];
                    location--;
		}while(location > 0 && arr[location - 1].compareTo(temp) > 0);

		arr[location] = temp;
            }
	}        
    }
    
    public void Quicksort(int first, int last){
	if (first < last){
            int pivotIndex = Split(first, last);
            Quicksort(first, pivotIndex - 1);
            Quicksort(pivotIndex + 1, last);
	}
    }
    
    private int Split(int first, int last){
        int pivotIndex;
	T pivot = arr[first];
	int left = first, right = last;
	
	while (left < right){
            while (arr[right].compareTo(pivot) > 0)
		right--;
			
            while (left < right && arr[left].compareTo(pivot) <= 0)
		left++;
			
            if (left < right){//swap the two items
                T temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }			
        }

        T temp = arr[first];
        arr[first] = arr[right];
        arr[right] = temp;
        
        pivotIndex = right;
        
        return pivotIndex;
    }	
    
    public void ShellSort(){
        int j;

        for( int gap = size / 2; gap > 0; gap /= 2 )
            for( int i = gap; i < size; i++ ){
                T tmp = arr[ i ];
                for( j = i; j >= gap && tmp.compareTo(arr[ j - gap ]) < 0; j -= gap ){
                    arr[ j ] = arr[ j - gap ];                
                }
                arr[ j ] = tmp;
                for(T var: arr)
                    if(var != null)
                        System.out.print(var + ", ");
                System.out.println();                
            }
    }
    
    public void MergeSort(Class<T> type, int low, int high){
        if (low < high){
           int middle = (low + high) / 2;
           MergeSort(type, low, middle);
           MergeSort(type, middle+1, high);
           Merge(type, low, middle, high);
        }
    }
    
    private void Merge(Class<T> type, int low, int middle, int high)
    {
        //merge with low and high
        T[] tem = (T[]) java.lang.reflect.Array.newInstance(type, high-low+1);
        int lowin = low, highin = middle + 1, temin = 0;

        while (lowin <= middle && highin <= high){
            if (arr[lowin].compareTo(arr[highin]) < 0)
                tem[temin++] = arr[lowin++];
            else
                tem[temin++] = arr[highin++];
        }

        while (lowin <= middle){
            tem[temin++] = arr[lowin++];
        }

        while ( highin <= high){
            tem[temin++] = arr[highin++];
        }

        for (int i=0; i < high-low+1; i++)
            arr[low+i] = tem[i]; 
     }    
}
