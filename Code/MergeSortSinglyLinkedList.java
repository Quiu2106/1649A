public class MergeSortSinglyLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = getMiddle(head);
        Node right = mid.next;
        mid.next = null;

        return merge(mergeSort(head), mergeSort(right));
    }

    static Node getMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }
}
