public class BubbleSortSinglyLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int d, int data){
            this.data = data;
        }
        public Node(Object d, int data2) {
            //TODO Auto-generated constructor stub
        }
    }
    static void bubbleSort(Node head){
        boolean swapped;
        do{
            swapped = false;
            Node cur = head;
            while(cur != null && cur.next != null){
                if(cur.data > cur.next.data){
                    int temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
        } while(swapped);
    }
    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5, 5);
        head.next = new Node(1, 2);
        head.next.next = new Node(4, 0);
        head.next.next.next = new Node(2, 9);

        bubbleSort(head);
        print(head);
    }
    
}
