package Oct17th;


public class MyStack{

    private Node head;
    private Node maxHead;

    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public void push(int val){
        //check max
        if(head == null || val >= getMax()){
            Node maxTemp = maxHead;
            maxHead = new Node(val);
            maxHead.next = maxTemp;
        }
        //push new node
        Node temp = head;
        head = new Node(val);
        head.next = temp;

    }

    public Node pop(){
        if(head == null) throw new RuntimeException("head is null in pop");
        Node result = head;
        head = head.next;
        if(result.data == getMax()){
            maxHead = maxHead.next;
        }
        return result;
    }

    public int getMax(){
        if(maxHead == null) throw new RuntimeException("Head is null in getMax");

        return  maxHead.data;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        System.out.println("stack max: " + stack.getMax());
        stack.pop();
        stack.pop();
        System.out.println("stack max: " + stack.getMax());
    }

}
