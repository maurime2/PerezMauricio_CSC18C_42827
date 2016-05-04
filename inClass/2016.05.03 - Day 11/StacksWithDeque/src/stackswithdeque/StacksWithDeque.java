package stackswithdeque;

public class StacksWithDeque {


    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack();
        Stack<Float> stackFliat = new Stack();
        Stack<Character> stackChar = new Stack();
        
        stackInt.push(10);
        stackInt.push(12);
        stackInt.push(8);
        stackInt.push(-4);
        stackInt.push(2);
        stackInt.push(1);
        
        while (stackInt.isEmpty()==false)
        {
            System.out.println("Return value of peek is: "+stackInt.peek());
            System.out.println("pop return value of peek is: "+stackInt.pop());
        }
        
    }
    
}
