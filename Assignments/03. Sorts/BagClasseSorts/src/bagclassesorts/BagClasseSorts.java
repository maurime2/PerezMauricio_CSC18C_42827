/*
http://visualgo.net/sorting.html#

Implement in your Bag class, the Selection Sort and Merge Sort 
(10 points extra credit - implement a third sorting algorithm of your choice).

In all of the sorting algorithms you implement:
	- make sure to have them pass a boolean parameter that dictates the sorting order 
		(	true - sort in ascending order from smallest to largest, 
			false - sort in descending order from largest to smallest ).

	- Provide a main program, that is a test driver, demonstrating the sorting 
		algorithms working for Bags of:
			String
			Integers
			Float
			
		( primitive types such as int and float, you need to use the their 
			respective wrapper classes Integer and Float ).

	- Be sure to document your code very well, and also provide your properly
		filled out PSP Excel Spreadsheet.

This assignment is due no later than 11:59PM on 4/8/16 for 50 points.

*/

//Libraries
package bagclassesorts;
import java.util.Scanner;   //Scanner input from terminals

//Bag Class Sorts
public class BagClasseSorts {

public static void main(String[] args) {
        //Declare Objects and Variables
        Scanner input = new Scanner(System.in); //For Scanner Input
        Bag<String>     bag_of_strings  = new Bag();
        Bag<Integer>    bag_of_ints     = new Bag();
        Bag<Float>      bag_of_floats   = new Bag();

        
        //Boolean to be passed
        boolean dBasara = false;          // Deshi Basara = true when he rises!
                                         // True = Ascennding, False = Decending
        String option = null;           // For option choice
       
        
        //BAGS FILLED
            //Bag of Strings Filled
                bag_of_strings.add("Hello");            //Added to the bag
                bag_of_strings.add("World!");
                bag_of_strings.add("Structures1");
                bag_of_strings.add("Data");
                bag_of_strings.add("Structures2");
                bag_of_strings.remove("Structures1");   //Removed from bag

            //Bag Of Ints Add
                bag_of_ints.add(5);
                bag_of_ints.add(1);
                bag_of_ints.add(4);
                bag_of_ints.add(3);
                bag_of_ints.add(2);

            //Bag Of Ints Add
                bag_of_floats.add(5.02f);
                bag_of_floats.add(21.03f);
                bag_of_floats.add(64.24f);
                bag_of_floats.add(3.65f);
                bag_of_floats.add(42.23f);

        //Bag Objects - To Acess Contents Added
        Object[]a = bag_of_strings.toArray();  //String Object
        Object[]b = bag_of_ints.toArray();     //Object for ints
        Object[]c = bag_of_floats.toArray();   //Object for floats
                
        //Output for Bag of Strings
        System.out.println("Size of bag_of_strings = " + bag_of_strings.getSize() );
        System.out.println("Contents of bag_of_strings:");
        for(int i=0;i<a.length;i++) {
            System.out.printf("a[%d] = %s\n",i,a[i]);
        }
                   
    //Assignment 3 Code: Int Outputs
        //Output for Bag of Strings
        System.out.println("\nSize of bag_of_ints = " + bag_of_ints.getSize() );
        System.out.println("Contents of bag_of_ints:"); 
        for(int i=0;i<b.length;i++) {
            System.out.printf("b[%d] = %s\n",i,b[i]);
        }
        
        //Output for Bag of Floats
        System.out.println("\nSize of bag_of_floats = " + bag_of_floats.getSize() );
        System.out.println("Contents of bag_of_floats:");
        for(int i=0;i<c.length;i++) {
            System.out.printf("c[%d] = %s\n",i,c[i]);
        }
    //Assignment 3 Code: Int Outputs
        //Prompt user for option
        option = "n";
        System.out.println("\nSort in Ascending order?\n'y' for yes, else for Descending Order: ");       
        option = input.nextLine();
        
        if(option.startsWith("y")==true){
        System.out.println("You Chose to displey in Ascending Order. Deshi Basara!");      
            dBasara = true;
        }
        else {
        System.out.println("You Chose to displey in Descending Order");      
            dBasara = false;
        }
        
        //Pass Bags with Asc/Dec Boolean
        //Object[] mergeSort = bag_of_ints.mergeSort(dBasara);   //Object for floats
        
       Object[] mergeSort = bag_of_floats.mergeSort(dBasara);   //Object for floats
        mergeSort = bag_of_strings.mergeSort(dBasara);   //Object for floats
        
        
        
        
    }//Main End
    
}//Class BagClasseSorts End
