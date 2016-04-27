/*
 Stack implemented via deque
 */

public class Stack2 {

    private Deque<Integer> stackItems;
    
    public Stack2()
    {
        stackItems = new Deque<Integer>();
    }
    
    public void push(int item)
    {
        stackItems.push_front(item);
    }
    
    public int pop()
    {
        return stackItems.pop_front();
    }
    
    public boolean isEmpty()
    {
        return stackItems.isEmpty();
    }
    
    @Override
    public String toString()
    {
        return stackItems.toString();
    }
}
