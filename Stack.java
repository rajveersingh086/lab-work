package classlab;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class StackUsingLinkedList {
    private Node top;
    public StackUsingLinkedList() {
        top = null;
    }
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Pushed " + data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        } else {
            int poppedData = top.data;
            top = top.next;
            return poppedData;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            Node current = top;
            System.out.print("Stack elements: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
public class Stack {
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(15);
        stack.push(12);
        stack.push(13);
        stack.push(16);
        stack.push(11);
        stack.printStack();
        System.out.println("Popped element: " + stack.pop());
        stack.printStack();
    }
}
