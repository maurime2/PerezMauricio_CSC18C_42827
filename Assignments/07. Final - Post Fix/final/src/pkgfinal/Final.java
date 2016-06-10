//
package pkgfinal;
import java.util.Scanner;
public class Final{

    //Main
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);    //creates a scanner "input"
        String phoneNumbOrig;
        String clean = "";
        cleanPhone cleanPhoneObject = new cleanPhone();
        boolean test = false;
        Bag<String> bag_of_strings = new Bag();
        Bag<Integer> bag_of_ints = new Bag();
        int strings = 0;
        int ints = 0;
        
        do{
            do{
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
        
        //Begin Stacking and Queing operation
        System.out.println("Clean String Check 1: "+clean);
        //Check for proper signs and fix what looks wrong
        test = cleanPhoneObject.fixNeg(clean, test);
        if(test==false){
        System.out.println("Your operators seem off. Please input again... "+clean);
        }
        
        }while(test==false);
    }//Main End
    
}//Final Class End
