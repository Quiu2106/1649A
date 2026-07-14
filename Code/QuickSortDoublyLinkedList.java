public class QuickSortDoublyLinkedList {

    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    static Node quickSort(Node head) {
        if (head == null || head.next == null) return head;

        int pivot = head.data;
        Node less = null, equal = null, greater = null;

        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.prev = cur.next = null;

            if (cur.data < pivot) {
                cur.next = less;
                if (less != null) less.prev = cur;
                less = cur;
            } else if (cur.data > pivot) {
                cur.next = greater;
                if (greater != null) greater.prev = cur;
                greater = cur;
            } else {
                cur.next = equal;
                if (equal != null) equal.prev = cur;
                equal = cur;
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
            if (tail != null) {
                tail.next = part;
                part.prev = tail;
            }
            while (part.next != null) part = part.next;
            tail = part;
        }
        return head;
    }
}
