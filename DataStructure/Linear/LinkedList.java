package Linear;/*
Linked List
链表是由节点 Linear.Node 组成的线性集合，每个节点可以利用指针指向其他节点。
- 单向链表
- 双向链表
- 循环链表
 */


public class LinkedList {
    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// 链表Node类
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}