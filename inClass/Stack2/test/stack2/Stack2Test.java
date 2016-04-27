
package stack2;

import Stack2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Stack2Test {
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
    public void testPush() {
        testStack = new Stack2();
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);
        testStack.push(40);
        testStack.push(50);
        Assert.assertEquals(50, testStack.pop());
        Assert.assertEquals(40, testStack.pop());
        Assert.assertEquals(30, testStack.pop());
        Assert.assertEquals(20, testStack.pop());
        Assert.assertEquals(10, testStack.pop());
                                
    }//end Test push
    
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
