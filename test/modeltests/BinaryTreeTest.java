package modeltests;

import model.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey on 17.05.2017.
 */
public class BinaryTreeTest {

    BinaryTree tree;

    @Before
    public void initTree(){
        tree = new BinaryTree();
        tree.addElement("6");
        tree.addElement("9");
        tree.addElement("5");
        tree.addElement("3");
        tree.addElement("1");
        tree.addElement("2");
    }

    @org.junit.Test
    public void testAddElement() throws Exception {
        tree.addElement("test");
        assertEquals("Test add element","test",String.valueOf(tree.getElement("test")));
    }

    @org.junit.Test
    public void getElement() throws Exception {
        assertEquals("Test get element","9",String.valueOf(tree.getElement("9")));
    }

    @org.junit.Test
    public void getMinimum() throws Exception {
        assertEquals("Test get minimum","1", String.valueOf(tree.getMinimum()));
    }

    @org.junit.Test
    public void getMaximum() throws Exception {
        assertEquals("Test get maximum","9", String.valueOf(tree.getMaximum()));
    }

    @org.junit.Test
    public void next() throws Exception {
        assertEquals("Test next element","9",String.valueOf(tree.next()));
    }

    @org.junit.Test
    public void previous() throws Exception {
        //root = 6, so 5 is previous
        assertEquals("Test previous element", "5", String.valueOf(tree.previous()));
    }

    @org.junit.Test
    public void testRemove() throws Exception {
        tree.remove("3");
        assertNull(tree.getElement("3"));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("Test size", 6,tree.size());
    }

}
