package Oct17th;

public class MyLinkedList {

    static Node h1, h2;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    int getLength(Node n){
        int length = 0;
        Node curr = n;

        while(curr != null){
            length++;
            curr = curr.next;
        }

        return length;
    }

    Node findNode(){
        int l1 = getLength(h1);
        int l2 = getLength(h2);
        if(l1 == 0 || l2 == 0) throw new RuntimeException("empty list");

        int diff = Math.abs(l1-l2);
        if(l1 > l2){
            return getIntersection(diff, h1, h2);
        }
        else{
            return getIntersection(diff, h2, h1);
        }
    }

    Node getIntersection(int diff, Node n1, Node n2){
        Node curr1 = n1;
        Node curr2 = n2;
        for(int i = 0; i < diff; i++){
            if(curr1 == null) throw new RuntimeException("larger list null before reaching parallel");
            curr1 = curr1.next;
        }
        while( curr1 != null && curr2 != null){
            if(curr1 == curr2) return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        Node same1 = new Node(8);
        Node same2 = new Node(10);

        // creating first linked list
        list.h1 = new Node(3);
        list.h1.next = new Node(7);
        list.h1.next.next = same1;
        list.h1.next.next.next = same2;

        // creating second linked list
        list.h2 = new Node(99);
        list.h2.next = new Node(1);
        list.h2.next.next = same1;
        list.h2.next.next.next = same2;

        Node intersect = list.findNode();
        System.out.println("Intersection at: " + intersect + " with value: " + intersect.data);

    }
}
