package binarySearchTree;

/**
 * myBST
 */
public class myBST {
    myNode root;

    public myBST() {
        this.root = null;
    }

    public void add(int value){
        myNode newNode = new myNode(value, null, null);
        if (root == null) {
            root = newNode;
            return;
        }
        myNode curr = root;
        while (curr != null) {
            if (curr.value == value){
                return;
            } else if (curr.value > value) {
                if (curr.leftNode == null) {
                    curr.leftNode = newNode;
                    return;
                }
                curr = curr.leftNode;
            } else {
                if (curr.rightNode == null) {
                    curr.rightNode = newNode;
                    return;
                }
                curr = curr.rightNode;
            }
        }
    }

    public boolean search(int value) {
        myNode curr = root;
        while (curr != null) {
            if (curr.value == value) {
                return true;
            } else if (curr.value > value) {
                curr = curr.leftNode;
            } else {
                curr = curr.rightNode;
            }
        }
        return false;
    }

    public int findLargest(myNode curr) {
        while (curr.rightNode != null) {
            curr = curr.rightNode;
        }
        return curr.value;
    }

    public void findAndDeleteLargest(myNode curr) {
        myNode prev = curr;
        while (curr.rightNode != null) {
            prev = curr;
            curr = curr.rightNode;
        }
        prev.rightNode = null;
    }

    public int findSmallest(myNode curr) {
        while (curr.leftNode != null) {
            curr = curr.leftNode;
        }
        return curr.value;
    }

    public void findAndDeleteSmallest(myNode curr) {
        myNode prev = curr;
        while (curr.leftNode != null) {
            prev = curr;
            curr = curr.leftNode;
        }
        prev.leftNode = null;
    }


    public void delete(int value) {
        myNode curr = root;
        myNode prev = curr;
        while (curr != null) {
            if (curr.value == value){           // find node
                if (curr.leftNode == null && curr.rightNode == null){   
                    if (curr.value == root.value) {         // if delete root value
                        root = null;
                        return;
                    }
                    if (prev.leftNode.value == value){
                        prev.leftNode = null;
                        return;
                    } else {
                        prev.rightNode = null;
                        return;
                    }
                } else if (curr.leftNode == null) {
                    curr.value = findSmallest(curr.rightNode); // replace it with the largest value in left subtree
                    findAndDeleteSmallest(curr.rightNode);     // find and delete that previous largest node
                    return;
                } else {
                    curr.value = findLargest(curr.leftNode); // replace it with the largest value in left subtree
                    findAndDeleteLargest(curr.leftNode);     // find and delete that previous largest node
                    return;
                }
            } else if (curr.value > value) {
                prev = curr;
                curr = curr.leftNode;
            } else {
                prev = curr;
                curr = curr.rightNode;
            }
        }
    }
}