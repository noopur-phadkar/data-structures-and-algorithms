package data_strucutres.linkedLists.double_linked_list;

class myDoubleLinkedList {

    Node head;

    public myDoubleLinkedList() {
        head = null;
    }

    public void insertAt(int value, int position) {
        Node newNode = new Node(value, null, null);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node curr = head;
        int currPos = 0;
        while (curr.next != null && currPos != (position - 1)) {
            curr = curr.next;
            currPos += 1;
        }
        if (curr.next != null) {
            curr.next.prev = newNode;
            newNode.next = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
    }

    public void add(int value) {
        Node newNode = new Node(value, null, null);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
    }

    public void deleteAt(int position) {
        if (isEmpty()) {
            return;
        }
        if (position == 0) {
            head = head.next;
            head.prev = null;
            return;
        }
        Node curr = head;
        int currPos = 0;
        while (currPos != (position - 1)) {
            if (curr.next == null)
                return;
            curr = curr.next;
            currPos += 1;
        }
        if (curr.next.next == null) {
            curr.next = null;
            return;
        }
        curr.next = curr.next.next;
        curr.next.prev = curr;
    }

    public boolean isEmpty() {
        if (head == null) 
            return true;
        return false;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("null");
            return;
        }
        Node curr = head;
        String res = "";
        while (curr != null) {
            res += curr.value + " -> ";
            curr = curr.next;
        }
        System.out.println(res + "null");
    }
}