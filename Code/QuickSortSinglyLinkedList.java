public class QuickSortSinglyLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node quickSort(Node head) {
        if (head == null || head.next == null) return head;

        int pivot = head.data;
        Node less = null, equal = null, greater = null;

        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;

            if (cur.data < pivot) {
                cur.next = less; less = cur;
            } else if (cur.data > pivot) {
                cur.next = greater; greater = cur;
            } else {
                cur.next = equal; equal = cur;
            }
            cur = next;
        }

        less = quickSort(less);
        greater = quickSort(greater);

        return concat(less, equal, greater);
    }

    static Node concat(Node a, Node b, Node c) {
        Node head = null, tail = null;
        for (Node part : new Node[]{a, b, c}) {
            if (part == null) continue;
            if (head == null) head = part;
            if (tail != null) tail.next = part;
            while (part.next != null) part = part.next;
            tail = part;
        }
        return head;
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
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);

        head = quickSort(head);
        print(head);
    }
}
