public class BubbleSortDoublyLinkedList {

    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    static void bubbleSort(Node head) {
        boolean swapped;
        do {
            swapped = false;
            Node cur = head;
            while (cur.next != null) {
                if (cur.data > cur.next.data) {
                    int tmp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = tmp;
                    swapped = true;
                }
                cur = cur.next;
            }
        } while (swapped);
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(2);

        head.next = n1; n1.prev = head;
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;

        bubbleSort(head);
        print(head);
    }
}
