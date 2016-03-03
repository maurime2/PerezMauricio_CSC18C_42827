public final class Bag<T> implements BagInterface<T> {
    private T[] bag_items;
    private int numberOfEntries;
    
    public Bag() {
        bag_items = (T[])new Object[10]; // default 10 item bag
        this.numberOfEntries=0;
    }
    
    public Bag(int startSize)
    {
        bag_items = (T[])new Object[startSize];
        this.numberOfEntries=0;
    }
    
    // return the current size of the bag, or the number of elements in the bag
    public int getSize(){
        return this.numberOfEntries;
    }
    
    // returns true if bag is empty or false if bag is not empty
    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }
    
    // add item to bag, returns true if successful, false if not
    public boolean add(T item) {
        if ( this.numberOfEntries >= bag_items.length ) return false; // cannot add more items
        bag_items[numberOfEntries++] = item;
        return true;
    }
    
    // returns true if item is removed from bag
    public boolean remove(T item) {
        for(int i=0;i<this.numberOfEntries;i++)
        {
            if ( this.bag_items[i]==item )
            {
                for(int j=i+1;j<this.numberOfEntries;j++)
                    this.bag_items[j-1]=this.bag_items[j];
                this.numberOfEntries--;
                return true;
            }
        }
        return false;
    }
    
    // clear the bag of all items
    public void clear()
    {
        this.numberOfEntries=0; // just reset numberOfEntries to zero and overwrite old data when we add new data
    }
    
    // returns true if item found in bag
    public boolean contains(T item) {
        for(int i=0;i<this.numberOfEntries;i++) if ( bag_items[i]==item ) return true;
        return false;
    }
    
    public T[] toArray() {
        T[] arr = (T[])new Object[this.numberOfEntries];
        for(int i=0;i<this.numberOfEntries;i++) arr[i]=this.bag_items[i];
        return arr;
    }            
}
