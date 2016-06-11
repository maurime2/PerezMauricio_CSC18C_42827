public class BagDemo {

    public static void main(String[] args) {
        Bag<String> bag_of_strings = new Bag();
        
        bag_of_strings.add("Hello");            //Added to the bag
        bag_of_strings.add("World!");
        bag_of_strings.add("Structures1");
        bag_of_strings.add("Data");
	bag_of_strings.add("Structures1");
        bag_of_strings.add("Structures2");
        bag_of_strings.remove("Structures1");   //Removed from bag
        
        System.out.println("Size of bag_of_strings=" + bag_of_strings.getSize() );
        System.out.println("Contents of bag_of_strings:");
        Object[] a = bag_of_strings.toArray();
        for(int i=0;i<a.length;i++) {
            System.out.printf("a[%d]=%s\n",i,a[i]);
        }
        
        //My Code
        System.out.println("Size of Array 'a': " + a.length );
        //Element Added
        System.out.println();
        System.out.println("Contents of bag_of_strings:");
        System.out.println("One Element Added");
        bag_of_strings.add("Structures1");
        System.out.println("Size of bag_of_strings=" + bag_of_strings.getSize() );
        //Resize
        a = bag_of_strings.toArrayResize();
        for(int i=0;i<a.length;i++) {
            System.out.printf("a[%d]=%s\n",i,a[i]);
        }
        System.out.println("Size of Array 'a': " + a.length );
        
        //2 Elements Removed
        System.out.println();
        System.out.println("Contents of bag_of_strings:");
        System.out.println("Two Element Removed");
        bag_of_strings.remove("Structures1");   //Removed from bag
        bag_of_strings.remove("Structures2");   //Removed from bag
        System.out.println("Size of bag_of_strings=" + bag_of_strings.getSize() );
        //Resize
        a = bag_of_strings.toArrayResize();
        for(int i=0;i<a.length;i++) {
            System.out.printf("a[%d]=%s\n",i,a[i]);
        }
        System.out.println("Size of Array 'a': " + a.length );
    }
    
}
