/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charcastint;

//Class CharCastInt
public class CharCastInt {

    //Main Start
    public static void main(String[] args) {
        
        //Declare Variables
        String name = "Values";
        int Length = name.length();      //Length of string "name". 5
        int [] array1;                  //Array to Dump the ascii values of name
        array1 = new int[Length];      //Allovates memorie of size Length 
        int asciiV = 0;               //To Cast to
        char characterN = '0';      //To get original char from name
        
        //Cast to int Array
        for(int i=0;i<Length;i++){
            //Cast To ascii
            characterN = name.charAt(i);    //Get original Char from Name
            asciiV = (int) characterN;      //Cast to Ascii Value
            System.out.println(asciiV);
            //Dump into Array
            array1[i] = asciiV;
            System.out.println(array1[i]);
        }
        
        //Display Array
//        System.out.println(name);
//        System.out.println(array1);        
        
    }// End Main
    
}// End Class CharCastInt
