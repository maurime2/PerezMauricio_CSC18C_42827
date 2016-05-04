package stackswithdeque;

public class Stack <T> {
    
    private Deque <T> _myStack;
    private boolean debug=false;
    private Object item;
    
    public Stack(){
    
        _myStack = new Deque();
    }
    
    
    public Stack (boolean dbg)
    {
        _myStack = new Deque();
        debug=true;
    }
    
    public void push (T item)
    {
        if(debug) System.out.println("Push onto stack value: "+item.toString());
        _myStack.push_front(item);        
    }

    public T pop()
    {
        if(debug) System.out.println("Pop onto stack value: "+item.toString());
        return _myStack.pop_front();
    }

    public boolean isEmpty()
    {
        return _myStack.isEmpty();
    }
    
    public T peak()
    {
        return _myStack.front();
    }

    String peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
