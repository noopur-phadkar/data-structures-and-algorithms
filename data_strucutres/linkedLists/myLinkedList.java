package data_strucutres.linkedLists;

public class myLinkedList {
    private myNode head;

    public myLinkedList(){
        this.head = null;
    }

    public void add(int value){
        myNode newNode = new myNode(value, null);
        if (head == null){
            head = newNode;
        } else {
            myNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void insertAt(int value, int index){
        myNode newNode = new myNode(value, null);
        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        myNode curr = head;
        myNode next = curr.next;
        int loc = 1;
        while (next != null) {
            if(loc == index){
                curr.next = newNode;
                newNode.next = next;
                return;
            }
            curr = next;
            next = next.next;
            loc += 1;
        }
        curr.next = newNode;
    }

    public boolean find(int value){
        myNode curr = head;
        while (curr != null) {
            if(curr.value == value){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void printList(){
        myNode curr = head;
        while (curr != null) {
            System.out.print(curr.value);
            System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}