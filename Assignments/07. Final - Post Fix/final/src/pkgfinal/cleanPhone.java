/*
    This Class takes 10 digit phone number and formats it to (XXX)XXX-XXXX
    format.
    
    By this point, NPA and 10 digits have been confirmed in the string. We need 
    to reformat the string to look like (XXX)XXX-XXXX.

        We will remove:
        -SPACES
        -CHARACTERS
        -PUNCTUATION
        
    Once thats done, we will copy the string with parenthasies and its "-" sign
    so that we can manipulate further.

*/

//Libraries
package pkgfinal;
import java.util.Arrays;    //to create arrays in Java

//class cleanPhone Start
public class cleanPhone {
    //Declare global variables
    int numTotal = 0;
    int oppTotal = 0;
    int perTotal = 0;
    String valTotal = "";
    String [] numArr = new String[20];
    int numArrP = 0;
    String [] oppArr = new String[20];
    int oppArrP = 0;
    
    //Method Clean String
    public String cleanString(String phoneNum, String cleanPhoneNum){
        //Declare Variables
        String temp = phoneNum;

        
        //http://regexr.com/ 
        //Prepare String Array to be manipulated
        temp = temp.replaceAll("[A-Za-z]", "");   //Removes All Punctuation w/reg expressions.
        temp = temp.replaceAll("[!@#$%&_=]", "");   //Removes All Punctuation w/reg expressions.
        temp = temp.replaceAll("[`~<>,.?\"'{}]", "");   //Removes All Punctuation w/reg expressions.
        temp = temp.replaceAll("[\\.\\r\\t\\n:|]", "");   //Removes All Punctuation w/reg expressions.
        //Removes all expressions followed by closed parentesies and replaces them with )
        int times = 0;
        do{
        temp = temp.replaceAll("(-\\))"     , ")");      //Removes All "-)" replaces with )
        temp = temp.replaceAll("(\\+\\))"   , ")");     //Removes All "+)" replaces with )
        temp = temp.replaceAll("(\\*\\))"   , ")");    //Removes All "*)" replaces with )
        temp = temp.replaceAll("(\\/\\))"   , ")");   //Removes All "/)" replaces with )
        temp = temp.replaceAll("(\\^\\))"     , ")");  //Removes All "^)" replaces with )
        temp=temp;
        
        //Replaces open parentasies and + * ^ / with (
        temp = temp.replaceAll("(\\(\\^)", "(");        //Removes All "^)" replaces with (
        temp = temp.replaceAll("(\\(\\+)", "(");     //Removes All "+)" replaces with (
        temp = temp.replaceAll("(\\(\\*)", "(");    //Removes All "*)" replaces with (
        temp = temp.replaceAll("(\\(\\/)", "(");   //Removes All "/)" replaces with (
        temp=temp;
        times++;
        
        //Replace ++ -- -+ +- with + + - - respectively
        temp = temp.replaceAll("(--)", "+");   //Removes All "--" replaces with +
        temp = temp.replaceAll("(\\+\\+)", "+");   //Removes All "++" replaces with +
        temp = temp.replaceAll("(-\\+)", "-");   //Removes All "-+" replaces with -
        temp = temp.replaceAll("(\\+\\-)", "-");   //Removes All "+-" replaces with -
        
        //Replace all double signs ^^ ** //
        temp = temp.replaceAll("(\\^\\^)", "^");   //Removes All "^^" replaces with ^
        temp = temp.replaceAll("(\\*\\*)", "*");   //Removes All "**" replaces with *
        temp = temp.replaceAll("(\\/\\/)", "/");   //Removes All "//" replaces with /
        
        //Replace multiply expression double inputs
        temp = temp.replaceAll("(\\*\\+)", "*");   //Removes All "**" replaces with *
        temp = temp.replaceAll("(\\*-)", "*");   //Removes All "**" replaces with *
        temp = temp.replaceAll("(\\*\\/)", "*");   //Removes All "**" replaces with *
        temp = temp.replaceAll("(\\*\\^)", "*");   //Removes All "**" replaces with *

        //Replace Divide expression double inputs
        temp = temp.replaceAll("(\\/\\+)"   , "/");   //Removes All "/+" replaces with /
        temp = temp.replaceAll("(\\/-)"     , "/");   //Removes All "/-" replaces with /
        temp = temp.replaceAll("(\\/\\*)"   , "/");   //Removes All "/*" replaces with /
        temp = temp.replaceAll("(\\/\\^)"   , "/");   //Removes All "/^" replaces with /
        
        //Replace Exponent expression double inputs
        temp = temp.replaceAll("(\\^\\+)"   , "^");   //Removes All "^+" replaces with ^
        temp = temp.replaceAll("(\\^-)"     , "^");   //Removes All "^-" replaces with ^
        temp = temp.replaceAll("(\\^\\/)"   , "^");   //Removes All "^/" replaces with ^
        temp = temp.replaceAll("(\\^\\*)"   , "^");   //Removes All "^*" replaces with ^

        //Replace possitive expression double inputs
        temp = temp.replaceAll("(\\+\\*)", "+");   //Removes All "+*" replaces with +
        temp = temp.replaceAll("(\\+\\/)", "+");   //Removes All "+/" replaces with +
        temp = temp.replaceAll("(\\+\\^)", "+");   //Removes All "+^" replaces with +
        
        //Replace possitive expression double inputs
        temp = temp.replaceAll("(\\-\\*)", "+");   //Removes All "-*" replaces with -
        temp = temp.replaceAll("(\\-\\/)", "+");   //Removes All "-/" replaces with -
        temp = temp.replaceAll("(\\-\\^)", "+");   //Removes All "-^" replaces with -
        
        //Empty "()"
        temp = temp.replaceAll("(\\(\\))", "");   //Removes All "()" replaces with ""
        
        }while(times<=100);
        //}
        //Removes all +- -+ and leaves -
        
//(-\))
        System.out.println("Clean String: "+temp);
        cleanPhoneNum = temp;
        
        //Return clean string
        return cleanPhoneNum;
    }//end clean string method
    
    
    //Method test - Finds all Open And Closed Parenthesis - Fail if no match
    public boolean test(String phoneNum, boolean test){
        int open = 0;
        int close = 0;
       System.out.println("Test For Open And Closed Parenthesis:  ");
        //Find All Parentasies
        for(int i = 0;i<phoneNum.length();i++){
            
            System.out.print(phoneNum.charAt(i)+" ");
            if(phoneNum.charAt(i)== '('){
                System.out.print(" <--MATCH! ");
                open++;
            }
            if(phoneNum.charAt(i)== ')'){
                System.out.print(" <--MATCH! ");
                close++;
                if(open < close){
                System.out.println("\nMiss Match!!!");
                break;
                }
                
            }
        }//For Loop Closed
        
        
        if(open == close){
                System.out.println("\nMatched Complete: open = "+open+", Close = "+close+"");
                test = true;
            }
        //Return Boolean
        return test;
    }//End Method Test
    
    
    //Method Clean fixNeg - NO LONGER NEEDED TO FIX NEG - INSTEAD, IT PROVIDES VALUES
    public boolean fixNeg(String phoneNum, boolean test){
        int operators = 0;
        int numbers = 0;
        String value = "";
        char app = ' ';
        String concat = "";
        boolean numbGen = false;
        
        //Check String for opperators, Parenthesis, and numeric values
        for(int i = 0;i<phoneNum.length();i++){
            //Find values of each character with app
            app = phoneNum.charAt(i);
            System.out.println("App is: "+app);
            
            //Check Digits
            if( (app== '0')||(app== '1')||(app== '2')||(app== '3')
                    ||(app== '4')||(app== '5')||(app== '6')||(app== '7')
                    ||(app== '8')||(app== '9') ){
            
            //Start Number or () store
                System.out.println("Its a Number: "+phoneNum.charAt(i));
                numbGen = true;
                do{
                    app = phoneNum.charAt(i);
                    if( i<phoneNum.length() &&((app== '0')||(app== '1')||(app== '2')||(app== '3')
                    ||(app== '4')||(app== '5')||(app== '6')||(app== '7')
                    ||(app== '8')||(app== '9')) ){            
                            //
                            if(numbGen){
                            concat = String.valueOf(app);
                            System.out.println("Concatinate " + concat + "i: "+i);
                            value = value+concat;    



                               //Check for next value
                               if(i<phoneNum.length()){
                                i++;
                               } 

                                //Correct the value if its out of range
                                if(i>=phoneNum.length()){
                                i--;
                                numbGen=false;
                                }
                            }
                    }
                    else{
                    //next value probably not a number or out of range
                    numbGen=false;
                    i--;
                    }
                }while(numbGen);
                
                //Print Value
                System.out.println("Value: " + value+"\n");
                //Push value
                ///Push to bag of strings
                numArr[numArrP]=value;
                numArrP++;
                
                //Clear Value for next use
                value = "";
                numTotal++;
            }//Check digits ends
            
            //Operator
            else if((app== '+')||(app== '-')||(app== '*')||(app== '/')||(app== '^')){
                System.out.println("Its an OPPERATOR: "+phoneNum.charAt(i));
                app = phoneNum.charAt(i);

                if(phoneNum.charAt(i)== '+'){
                System.out.println("Its a Possitive Sign: "+phoneNum.charAt(i));
                }
                else if(phoneNum.charAt(i)== '-'){
                System.out.println("Its a Negative Sign: "+phoneNum.charAt(i));
                }
                else if(phoneNum.charAt(i)== '*'){
                System.out.println("Its a Multiplication Sign: "+phoneNum.charAt(i));
                }
                else if(phoneNum.charAt(i)== '/'){
                System.out.println("Its a Division Sign: "+phoneNum.charAt(i));
                }
                else if(phoneNum.charAt(i)== '^'){
                System.out.println("Its a Power Sign: "+phoneNum.charAt(i));
                }
                
                //PUSH ZERO
                concat = String.valueOf(app);
                value = value+concat;   
                
                //Print Opperator
                System.out.println("Opperator: " + value+"\n");
                ///Push to bag of strings
                //Clear Value for next time
                oppArr[oppArrP]=value;
                oppArrP++;
                
                value = "";
                oppTotal++;
            }//Check for Opperators ends
            

            
                
            //Parenthesis
            else{
                //Start Number or () store
                System.out.println("Its a Parenthesis (): "+phoneNum.charAt(i));
                numbGen = true;
                do{
                app = phoneNum.charAt(i);
                
                //If its not a number, dont concatinate
                //If its not a number, dont concatinate
                if( (app =='(') || (app ==')') ){
                    System.out.println("Concatination Loop Ends: Parenthesis");
                    concat = String.valueOf(app);
                    value = value+concat;
                    numbGen = false;
                }
                else if( (app =='/') || (app =='*') || (app =='+') || (app =='-') || (app =='^') ){
                    System.out.println("Concatination Loop Ends: OPPERATOR");
                    numbGen = false;
                    i--;
                }
                
                //
                if(numbGen){
                concat = String.valueOf(app);
                value = value+concat;    
                i++;
                }
                
                
                }while(numbGen);
                
                System.out.println("Value: " + value+"\n");
                
                //Push value
                
                //Clear Value for next use
                value = "";
                perTotal++;
            }//Parenthesis End
        }
        //Sum Totals
        valTotal=phoneNum;
        System.out.printf("String: %s\n",valTotal);
        System.out.println("Per Total: " + perTotal);
        System.out.println("Num Total: " + numTotal);
        System.out.println("Opp Total: " + oppTotal);
        //Per Total, numTotal, and oppTotal
        return test;
    }
    
    
    public void show(){
        System.out.println("Showing Global Variables...");
        String temp = "";
        //Print Numbers in Array's
            //Print Numbers in Array
            for(int i=0;i<numArrP;i++){
            temp = numArr[i];
                System.out.printf("Number Array at %d: %s\n",i,temp);
            }

            //Print Opperators in array
            for(int i=0;i<oppArrP;i++){
            temp = oppArr[i];
                System.out.printf("Opperator Array at %d: %s\n",i,temp);
            }
        
        //Print Global Values of 
        System.out.printf("String: %s\n",valTotal);
        System.out.println("Per Total: " + perTotal);
        System.out.println("num Total: " + numTotal);
        System.out.println("opp Total: " + oppTotal);
    }
            
}//class cleanPhone end
