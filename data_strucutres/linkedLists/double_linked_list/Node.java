package data_strucutres.linkedLists.double_linked_list;

public class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value, Node next, Node prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
