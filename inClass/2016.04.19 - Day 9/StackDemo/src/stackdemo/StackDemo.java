package stackdemo;
public class StackDemo {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        
        int value =2112567890; //12345678

        while(value>0)
        {
        myStack.push(value % 1000);
        value = value / 1000;
        }
        
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
        try{
        while (!myStack.isEmpty())
            System.out.println(myStack.pop());
        }
        catch(Exception e)
        {
        
        }
        System.out.println("\b");
    }//End Main
    
}//End Stack Demo
