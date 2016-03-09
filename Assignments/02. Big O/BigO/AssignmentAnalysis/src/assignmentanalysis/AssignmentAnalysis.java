/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentanalysis;

/**
 *
 * @author Paul
 */
public class AssignmentAnalysis {

    static int count;
    
    public static void function_one(int n)
    {
        count++;
        System.out.print(n+" ");
        if ( n > 1 )
        {
            function_one(n-1);
            function_one(n-1);
        }
    }//End Function 1
    
    public static void function_two(int n)
    {
        count++;
        System.out.print(n+" ");
        if ( n > 1 )
        {
            function_two(n-1);
            function_two(n/2);
        }
    }//end function 2
    
    public static int function_three(int n)
    {
        count++;
        System.out.print(n+" ");
        if ( n > 1 )
        {
            return function_three(n/2)+function_three(n/2);
        }
        return 1;
    }//end Function 3
    
    public static void count_down(int n)
    {
        count++;
        //System.out.println(n);
        if ( n > 1 )
            count_down(n/2);
    }//End Count Down
	
    public static void main(String[] args) {
       /*
        for(int i=1;i<100;i++)
        {
            count=0;
            
            function_one(i);
            System.out.printf("%d\n",count);
        }
        
         
        for(int i=1;i<=10;i++)
        {
            count=0;
            function_two(i);
            System.out.printf("n=%d, count=%d\n", i,count);
        }
        
       
        for(int i=1;i<10;i++)
        {
            count=0;
            function_three(i);
            System.out.printf("n=%d, count=%d\n", i,count);
        }
        */
        
        
        for(int i=1;i<=100;i++)
        {
            count=0;
            count_down(i);
            System.out.printf("=%d\n", count);
        }
            
    }//end Main   
    
}//end Assignment Analysis
