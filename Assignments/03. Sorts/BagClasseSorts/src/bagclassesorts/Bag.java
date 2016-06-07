/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagclassesorts;
import java.lang.*;

public final class Bag<T> implements BagInterface<T> {
    private T[] bag_items;
    private int numberOfEntries;
    
    public Bag() {
        bag_items = (T[])new Object[10]; // default 10 item bag
        this.numberOfEntries=0;
    }
    
    public Bag(int startSize)
    {
        bag_items = (T[])new Object[startSize];
        this.numberOfEntries=0;
    }
    
    // return the current size of the bag, or the number of elements in the bag
    public int getSize(){
        return this.numberOfEntries;
    }
    
    // returns true if bag is empty or false if bag is not empty
    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }
    
    // add item to bag, returns true if successful, false if not
    public boolean add(T item) {
        if ( this.numberOfEntries >= bag_items.length ) return false; // cannot add more items
        bag_items[numberOfEntries++] = item;
        return true;
    }
    
    // returns true if item is removed from bag
    public boolean remove(T item) {
        for(int i=0;i<this.numberOfEntries;i++)
        {
            if ( this.bag_items[i]==item )
            {
                for(int j=i+1;j<this.numberOfEntries;j++)
                    this.bag_items[j-1]=this.bag_items[j];
                this.numberOfEntries--;
                return true;
            }
        }
        return false;
    }
    
    // clear the bag of all items
    public void clear()
    {
        this.numberOfEntries=0; // just reset numberOfEntries to zero and overwrite old data when we add new data
    }
    
    // returns true if item found in bag
    public boolean contains(T item) {
        for(int i=0;i<this.numberOfEntries;i++) if ( bag_items[i]==item ) return true;
        return false;
    }
    
    public T[] toArray() {
        T[] arr = (T[])new Object[this.numberOfEntries];
        for(int i=0;i<this.numberOfEntries;i++) arr[i]=this.bag_items[i];
        return arr;
    }
        //My Code - Resizes Array
        public T[] toArrayResize() {
        T[] arr = (T[])new Object[this.numberOfEntries];
        for(int i=0;i<this.numberOfEntries;i++) arr[i]=this.bag_items[i];
        return arr;
    }
        
        //SORTS: MERGE SORT, Selection Sort, Bubble Sort
        //Merge Sort
        public T[] mergeSort(boolean dBasara){
        //this method is for merge-sorting current bag
        T[] bag = this.toArray();
        
        return mergeSort(bag, dBasara);
        
        }
        //New Bag to be Merge Sorted. Output in asc or dec order depending on Batman
        public T[] mergeSort(T[] newBag, boolean dBasara){
            //Declare Method Variables
            
            //If newBag is less than 1 element, return.
            if(newBag.length <= 1) return newBag;
            
            //Split elements to halves
                //create halves
                T[] topHalf    = (T[]) new Object[newBag.length/2];                 //Bottom Half
                T[] bottomHalf = (T[]) new Object[newBag.length - topHalf.length]; //Top Half
                
                //copy into halves : [http://stackoverflow.com/questions/5785745/make-copy-of-array-java]
                System.arraycopy(newBag, 0              , topHalf   , 0, topHalf.length);
                System.arraycopy(newBag, topHalf.length , bottomHalf, 0, bottomHalf.length);
                
                //sort halves - Call Itself
                mergeSort(topHalf, dBasara);
                mergeSort(bottomHalf, dBasara);
        
                //merge the halves, send type of sort to be used
                merge(topHalf, bottomHalf, newBag, dBasara);
                
            //byte[] bytes = newString[0].getBytes("US-ASCII");
            //Return Sorted
            return newBag;
        }
        
        
        private void merge(T[] first, T[] second, T[] result, boolean sort_type){
        //Index Position in first array - starting with first element
        int idx_top = 0;
         
        //Index Position in second array - starting with first element
        int idx_bottom = 0;
         
        //Index Position in merged array - starting with first position
        int idx_merged = 0;
         
        //Compare elements at idx_top and idx_bot, 
        //and move smaller element at idx_merged
        
        if(sort_type == true){
            while (idx_top < first.length && idx_bottom < second.length){
                //made this to avoid using Comparable[]
                Integer top = Integer.valueOf(first[idx_top].toString().replace(".", ""));
                Integer bot = Integer.valueOf(second[idx_bottom].toString().replace(".", ""));
                int comparator = top - bot;
                if (comparator < 0){
                    result[idx_merged] = first[idx_top];
                    idx_top++;
                } 
                else{
                    result[idx_merged] = second[idx_bottom];
                    idx_bottom++;
                }
                idx_merged++;
            }
        }
        //Compare elements at idx_top and idx_bot, 
        //and move larger element at idx_merged
        else if(sort_type == false){
            while (idx_top < first.length && idx_bottom < second.length){
                //made this to avoid using Comparable[]
                Integer top = Integer.valueOf(first[idx_top].toString().replace(".", ""));
                Integer bot = Integer.valueOf(second[idx_bottom].toString().replace(".", ""));
                int comparator = top - bot;
                if (comparator > 0){
                    result[idx_merged] = first[idx_top];
                    idx_top++;
                } 
                else{
                    result[idx_merged] = second[idx_bottom];
                    idx_bottom++;
                }
                idx_merged++;
            }
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, idx_top, result, idx_merged, first.length - idx_top);
        System.arraycopy(second, idx_bottom, result, idx_merged, second.length - idx_bottom);
    }
        
        
        
        
        //OTHERS
        
        public T[] selectionSort(T[] newBag, boolean x){
        //
            
        //Return Sorted
        return newBag;
        }
        
        public T[] bubbleSort(T[] newBag, boolean x){
        //
            
        //Return Sorted
        return newBag;
        }
        
}
