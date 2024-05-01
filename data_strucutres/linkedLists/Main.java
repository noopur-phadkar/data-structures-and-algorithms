package data_strucutres.linkedLists;

public class Main {
    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();
        list.add(5);
        list.add(10);
        list.add(15);
        list.printList();
        list.find(10);
        list.insertAt(12, 2);
        list.printList();
    }
}
