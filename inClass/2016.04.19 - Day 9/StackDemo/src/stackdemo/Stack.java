package stackdemo;

public class Stack {
    private int[] items;
    private int top=-1;
    
    public Stack()
    {
        items = new int[20];
        top = 0;
    }
    
    public Stack(int InitialStackSize)
    {
        items = new int[InitialStackSize];
        top=0;
    }
    
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    public boolean isFull()
    {
        return top == items.length-1;
    }
    
    public void push(int data)
    {
        if(!isFull() )
        {
            items[++top]=data;
        }
        //else how do we handle pushinf onto a full stack?
    }
    
    public int pop() throws Exception
    {
        if (isEmpty() ) throw new Exception();
        return items[top--];
    }
}
