import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    
    private static Main main;
    private TreeNode root;
    private TreeNode invalidRoot;
    private TreeNode nullRoot;

    @BeforeClass
    public static void createMain() {
        main = new Main();
    }

    @Before
    public void setUp() {
        root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1,
                                null,
                                new TreeNode(2, null, null)),
                        null),
                new TreeNode(10,
                        new TreeNode(6, null, null),
                        new TreeNode(15, null, null)));
        invalidRoot = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1,
                                null,
                                new TreeNode(2, null, null)),
                        new TreeNode(7, null, null)),
                new TreeNode(10,
                        new TreeNode(6, null, null),
                        new TreeNode(15, null, null)));
        nullRoot = null;
    }

    @Test
    public void testIsValidBST() {
        assertTrue("null", main.isValidBST(nullRoot));
        assertTrue(main.isValidBST(root));
        assertFalse(main.isValidBST(invalidRoot));
    }

    @Test
    public void testInOrder() {

        assertEquals(new LinkedList<>(), main.inOrder(null));

        List<Integer> result = main.inOrder(root);
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 6, 10, 15);
        assertEquals(expected, result);
    }

    @Test(expected = NullPointerException.class)
    public void testFailsOnNull() {
        main.failsOnNull(nullRoot);
    }

    @After
    public void tearDown() {
        System.out.println("after");
    }
}