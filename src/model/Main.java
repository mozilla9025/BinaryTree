package model;

/**
 * Created by Sergey on 17.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.addElement("6");
        bt.addElement("9");
        bt.addElement("5");
        bt.addElement("3");
        bt.addElement("1");
        bt.addElement("2");
        bt.addElement("0");
        bt.addElement("12");
        bt.addElement("15");


        System.out.println("root: "+bt.getRoot());

        bt.inorderTraversal();

        System.out.println("\ndepth: "+bt.treeDepth());
        System.out.println("\nsize: "+bt.size());

        System.out.println(bt.previous());
    }
}
