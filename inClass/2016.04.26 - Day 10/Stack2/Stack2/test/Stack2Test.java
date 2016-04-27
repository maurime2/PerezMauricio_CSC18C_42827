
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Stack2Test {
    
    // private test object for Stack2
    Stack2 testStack;
    
    public Stack2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPushPop() {
        testStack = new Stack2();
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);
        testStack.push(40);
        testStack.push(50);
        System.out.println("Asserting pop returns 50");
        Assert.assertEquals(50, testStack.pop());
        System.out.println("Asserting pop returns 40");
        Assert.assertEquals(40, testStack.pop());
        System.out.println("Asserting pop returns 30");
        Assert.assertEquals(30, testStack.pop());
        System.out.println("Asserting pop returns 20");
        Assert.assertEquals(20, testStack.pop());
        System.out.println("Asserting pop returns 10");
        Assert.assertEquals(10, testStack.pop());
    }
    
    @Test
    public void testIsEmptyTrue()
    {
        testStack = new Stack2();
        Assert.assertTrue(testStack.isEmpty());
    }
    
    @Test 
    public void testIsEmptyFalse()
    {
        testStack = new Stack2();
        testStack.push(10);
        Assert.assertFalse(testStack.isEmpty());
    }
}
