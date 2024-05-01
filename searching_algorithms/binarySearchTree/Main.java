package searching_algorithms.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        myBST tree = new myBST();
        tree.add(5);
        tree.add(1);
        tree.add(11);
        tree.add(3);
        tree.add(0);
        tree.add(15);
        System.out.println(tree.search(3));
        System.out.println(tree.search(9));
        tree.delete(3);
        System.out.println(tree.search(3));
    }
}
