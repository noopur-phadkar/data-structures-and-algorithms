package data_strucutres.queue;

class Node {
    int value;
    Node next;

    public Node(int value, Node nextNode){
        this.value = value;
        this.next = nextNode;
    }
}

class Queue {
    Node rear;
    Node head;

    public Queue(){
        rear = null;
        head = null;
    }

    public void insert(int value){
        Node newNode = new Node(value, null);
        if ( rear == null && head == null) {
            rear = newNode;
            head = newNode;
            return;
        }
        newNode.next = rear;
        rear = newNode;
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        Node curr = rear;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        int value = head.value;
        head = curr;
        return value;
    }

    public void printQueue(){
        if (rear == null){
            System.out.println("null");
            return;
        }
        String res = "";
        Node curr = rear;
        while (curr != null) {
            res += curr.value + " -> ";
            curr = curr.next;
        }
        System.out.println(res + "null");
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.printQueue();
        queue.insert(5);
        queue.printQueue();
        queue.insert(1);
        queue.printQueue();
        queue.insert(4);
        queue.printQueue();
        queue.insert(8);
        queue.printQueue();
        System.out.println("Value: " + queue.pop());
        queue.printQueue();
    }
}
