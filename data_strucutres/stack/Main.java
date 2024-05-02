package data_strucutres.stack;

class Node {
    int value;
    Node next;

    public Node(int value, Node nextNode) {
        this.value = value;
        this.next = nextNode;
    }
}

class Stack {
    Node head;

    public Stack() {
        head = null;
    }

    public void push(int value){
        Node newNode = new Node(value, null);
        if (head == null){
             head = newNode;
             return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public int pop(){
        if (head == null){
            return -1;
       }
       int value = head.value;
       head = head.next;
       return value;
    }

    public void printStack(){
        if (head == null){
            System.out.println("null");
            return;
        }
        String res = "";
        Node curr = head;
        while (curr != null) {
            res += curr.value + " -> ";
            curr = curr.next;
        }
        System.out.println(res + "null");
    }
}

public class Main {

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.printStack();
        myStack.push(5);
        myStack.printStack();
        myStack.push(1);
        myStack.printStack();
        myStack.push(4);
        myStack.printStack();
        myStack.push(8);
        myStack.printStack();
        myStack.pop();
        myStack.printStack();
    }
}
