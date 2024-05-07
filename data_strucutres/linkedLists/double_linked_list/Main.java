package data_strucutres.linkedLists.double_linked_list;

public class Main {
    public static void main(String[] args) {
        myDoubleLinkedList list = new myDoubleLinkedList();
        list.add(5);
        list.add(7);
        list.add(8);
        list.printList();
        list.insertAt(6, 1);
        list.printList();
        list.insertAt(10, 7);
        list.printList();
        list.deleteAt(3);
        list.printList();
    }
}
