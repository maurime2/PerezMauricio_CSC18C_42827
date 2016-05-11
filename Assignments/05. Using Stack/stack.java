public class Stack {
    private int[] items;
    private int top;
    
    public Stack()
    {
        items = new int[20];
        top = -1;
    }
    
    public Stack(int InitialStackSize)
    {
        items = new int[InitialStackSize];
        top = -1;
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
        if ( !isFull() )
        {
            items[++top]=data;
        }
        // else how do we handle pushing onto a full stack?
    }
    
    public int pop()
    {
        if ( isEmpty() ) return 0;
        return items[top--];        
    }
}
