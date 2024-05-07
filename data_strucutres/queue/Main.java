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
    Node front;

    public Queue(){
        rear = null;
        front = null;
    }

    public void enqueue(int value){
        Node newNode = new Node(value, null);
        if (isEmpty()) {
            rear = newNode;
            front = newNode;
            return;
        }
        newNode.next = rear;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int value;
        if (rear == front){
            value = rear.value;
            rear = null;
            front = null;
        } else {
            Node curr = rear;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            value = front.value;
            front = curr;
        }
        return value;
    }

    public boolean isEmpty() {
        if (isEmpty())
            return true;
        return false;
    }

    public int peek_rear() {
        if (! isEmpty()) {
            return rear.value;
        }
        return -1;
    }

    public int peek_front() {
        if (! isEmpty()) {
            return front.value;
        }
        return -1;
    }

    public void printQueue(){
        if (isEmpty()){
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
        queue.enqueue(5);
        queue.printQueue();
        queue.enqueue(1);
        queue.printQueue();
        queue.enqueue(4);
        queue.printQueue();
        queue.enqueue(8);
        queue.printQueue();
        System.out.println("Value: " + queue.dequeue());
        queue.printQueue();
    }
}
