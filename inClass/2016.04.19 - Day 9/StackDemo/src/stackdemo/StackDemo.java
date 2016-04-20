package stackdemo;
import java.security.SecureRandom;

public class StackDemo {
    public static void main(String[] args) {
        Stack myStack = new Stack(50000);
        
        SecureRandom gen = new SecureRandom();
        
        while (!myStack.isFull())
        {
            int v=gen.nextInt(100);
            System.out.println("Pushing "+v+" onto stack...");
            myStack.push(v);
        }
        
        System.out.println("Contents of the stack poped off...");
        while(!myStack.isEmpty() )
                System.out.println(myStack.pop());
        
        System.out.println("\b");
        
        /*
        int value =2112567890; //12345678
        */
        
        /*
        while(value>0)
        {
        myStack.push(value % 1000);
        value = value / 1000;
        }
        */
        
        /*
        for(int i =0; i<3;i++)
        {
        myStack.push(value % 1000);
        value = value / 1000;
        }
        */
        /*
        myStack.push(4);
        myStack.push(14);
        myStack.push(41);
        myStack.push(24);
        myStack.push(34);
        */
        
        /*
        try{
        while (!myStack.isEmpty())
            System.out.println(myStack.pop());
        }
        catch(Exception e)
        {
        
        }
        System.out.println("\b");
        */
    }//End Main
    
}//End Stack Demo
