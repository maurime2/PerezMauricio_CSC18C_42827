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
    
    //Method Clean String
    public String cleanString(String phoneNum, String cleanPhoneNum){
        //Declare Variables
        String temp = phoneNum;
        String leftB = "(";
        String rightB = ")";
        String Space = "-";
        String MultO = "*";
        String ADDO = "+";
        String DivO = "/";
        String ExpO = "^";
        String SubO = "-";
        
        //http://regexr.com/ 
        //Prepare String Array to be manipulated
        temp = temp.replaceAll("[A-Za-z]", "");   //Removes All Punctuation w/reg expressions.
        temp = temp.replaceAll("[!@#$%&_=]", "");   //Removes All Punctuation w/reg expressions.
        temp = temp.replaceAll("[`~<>,.?\"'{}]", "");   //Removes All Punctuation w/reg expressions.
        temp = temp.replaceAll("[\\.\\* \\r\\t\\n:|]", "");   //Removes All Punctuation w/reg expressions.
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
    
    
    //Method Clean String
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
    }
    
    
    //Method Clean String
    public boolean fixNeg(String phoneNum, boolean test){
        int operators = 0;
        int numbers = 0;
        String value = "";
        char app = ' ';
        String concat = "";
        boolean numbGen = false;
        
        //Check String untill you find a - sign
        for(int i = 0;i<phoneNum.length();i++){
            //  value = phoneNum.charAt(i);
            
            if(phoneNum.charAt(i)== '+'){
                System.out.println("Its a Plus Sign: "+phoneNum.charAt(i));
                
                
            }
          else if(phoneNum.charAt(i)=='-'){
                System.out.println("Its a Negative Sign: "+phoneNum.charAt(i));
                app = phoneNum.charAt(i);
                    
                //PUSH ZERO
                concat = String.valueOf(app);
                value = value+concat;   
                
                //Push Value to Characters
                System.out.println("Value; " + value);
                
                value = "";
                
                }
            
            
            
            
            
            
            
            
            
            
            else if(phoneNum.charAt(i)== '*'){
                System.out.println("Its a Multiplication Sign: "+phoneNum.charAt(i));
            }
            else if(phoneNum.charAt(i)== '/'){
                System.out.println("Its a Division Sign: "+phoneNum.charAt(i));
            }
            else if(phoneNum.charAt(i)== '^'){
                System.out.println("Its a Exponent: "+phoneNum.charAt(i));
            }
            else if(phoneNum.charAt(i)== ' '){
            System.out.println("Its a Space: "+phoneNum.charAt(i));
                
            }
            else{
                //Start Number or () store
                System.out.println("Its a Number or (): "+phoneNum.charAt(i));
                numbGen = true;
                do{
                app = phoneNum.charAt(i);
                
                //If its not a number, dont concatinate
                if( (app =='/') || (app =='*') || (app =='+') || (app =='-') || (app =='^') || (app =='(') || (app ==')') ){
                    System.out.println("Concatination Loop Ends");
                    numbGen = false;
                }
                
                //
                if(numbGen){
                concat = String.valueOf(app);
                value = value+concat;    
                i++;
                }
                
                
                }while(numbGen);
                System.out.println("Value; " + value);
                
                //Push value
                
                //Clear Value for next use
                value = "";
            }
            //int i = Integer.parseInt(myString);
            
        }
        
        
        return test;
    }
    
}//class cleanPhone end
