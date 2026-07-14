class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head; // node đầu tiên

    public LinkedList() {
        head = null;
    }

    // Thêm vào đầu danh sách
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Thêm vào cuối danh sách
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Xóa phần tử đầu
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // In danh sách
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.addLast(4);
        list.addLast(5);

        list.printList(); // 1 -> 2 -> 3 -> 4 -> 5 -> null

        list.removeFirst();
        list.printList(); // 2 -> 3 -> 4 -> 5 -> null
    }
}
