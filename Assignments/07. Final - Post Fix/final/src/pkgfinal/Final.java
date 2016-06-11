//
package pkgfinal;
import java.util.Scanner;
public class Final{

    //Main
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);    //creates a scanner "input"
        String phoneNumbOrig;   //Will Hold original user input: UNUSSABLE
        String clean = "";     //Will hold clean fpr nulling
        String clean2 = "";   //Will hold clean string with proper formating.
        int numsTotal=0;     //Will keep track of total numbers found.
        int oppsTotal=0;    //Will keep total opperators found.
        cleanPhone cleanPhoneObject = new cleanPhone(); //CleanPhone Object.
        boolean test = false;   //Will use for Input Validation Test
        int intTemp = 0;
        String strTemp = "";
        
        //Bag Objects
        Bag<String> bag_of_opps = new Bag();
        Bag<Integer> bag_of_ints = new Bag();
        //WIll Use this as a stack: THEORY - MIGHT NOT USE
        Bag<String> bag_of_stack = new Bag();
        Bag<String> bag_of_queue = new Bag();
        
        //Input Validation
        do{//Pass means Numerical Value and Opperator String Arrays waiting in cleanPhone.java
            do{//Pass means Clean Input + Matched Parenthesis
                    //Prompt Input
                    System.out.println("Input Equation with exact Parenthesis.");
                    System.out.println("No negative numbers allowed!!!");
                    System.out.println("Input An Equation:");    
                    phoneNumbOrig=input.nextLine();
                    System.out.println("You Input: "+phoneNumbOrig );
                    
                //Remove all non numbers and punctuations except (^ - + ( ) / *)
                clean = cleanPhoneObject.cleanString(phoneNumbOrig, clean);

                //Test for Matching Parenthesis
                test = cleanPhoneObject.test(clean, test);

                if(test==false){
                System.out.println("You Must have matching Parenthesis, try again...");    
                }
            }while(test==false);
        
            //Begin Cleaning Opperation 1   -   THIS TURNED INTO STACKING VALUES INTO ARRAY OPP
            System.out.println("Clean String Check 1: "+clean);
            //Check for proper signs and fix what looks wrong
            test = cleanPhoneObject.fixNeg(clean, test);
            if(test==false){
            System.out.println("Your operators seem off. Please input again... "+clean);
            }
        }while(test==false);
        
        //Numbers and Opperators are in arrays within cleanPhone, Must throw them in Bag
        System.out.println("\nTest Complete!!! Time to Opperate!!!\n");

            //This is a test to show the arrays in cleanPhone and the values that wait within
                //cleanPhoneObject.show();
        
        //Fill bag of ints
            //get array sizes
            numsTotal = cleanPhoneObject.numArrP();
            oppsTotal = cleanPhoneObject.oppArrP();
            System.out.println("\nNumber Array Size: "+numsTotal);
            System.out.println("Opperator Array Size: "+oppsTotal);
            //Dump Data into Bags
                //Dump arrays into respective bags
                for(int i= 0;i<oppsTotal;i++){
                strTemp = cleanPhoneObject.oppArr(i);
                bag_of_opps.add(strTemp);
                }
            //bag_of_ints.add(numArr(0));
            for(int i= 0;i<numsTotal;i++){
            intTemp = Integer.parseInt(cleanPhoneObject.numArr(i));
            bag_of_ints.add(intTemp);
            }
            //Create Objects to access the array
            Object[] intArr = bag_of_ints.toArray();
            Object[] strArr = bag_of_opps.toArray();
        //Print Contents of bags    
            //Integers Bag
            for(int i=0;i<intArr.length;i++) {
                System.out.printf("INT [%d]=%s\n",i,intArr[i]);
            }
            //Operation bag
            for(int i=0;i<strArr.length;i++) {
                System.out.printf("OPP [%d]=%s\n",i,strArr[i]);
            }
            
    }//Main End
    
}//Final Class End
