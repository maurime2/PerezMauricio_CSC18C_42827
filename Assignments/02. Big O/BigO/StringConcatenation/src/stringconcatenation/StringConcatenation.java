/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringconcatenation;
//Fig 14.7 Revisited
public class StringConcatenation {
   
    public static void main(String[] args) {
        String s1 = "Happy ";      //String 1
        String s2 = "Birthday";   //String 2
        String s3 = "Non ";      //String 3
        String s4 = " ";        //We will be using this as our output string

        //Before Concatination
        System.out.printf("s1 = %s%ns2 = %s%ns3 = %s%ns4 = %s%n%n",s1, s2, s3, s4);
        
        //Concatination
        System.out.printf("Result of s4.concat(s1) = %s%n",s4=s4.concat(s1) );
        System.out.printf("Result of s4.concat(s3) = %s%n",s4=s4.concat(s3) );
        System.out.printf("Result of s4.concat(s3) = %s%n",s4=s4.concat(s2) );
        
        //End Result
        System.out.printf("s4 after concatenation = %s%n", s4);
    }//End Main    
}//End of class StringConcatenation