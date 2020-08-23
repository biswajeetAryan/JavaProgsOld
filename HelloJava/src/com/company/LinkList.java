package com.company;

import org.w3c.dom.Node;

public class LinkList {
    Node head;
    class Node {
        private int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }

    public void push(int nodeVal) {
        Node newNode = new Node(nodeVal);

        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node preNode, int data){
        Node newNode = new Node(data);
        if(preNode == null)
            return;
        newNode.next = preNode.next;
        preNode.next = newNode;
    }

    public void append(int data){
        Node newNode = new Node(data);

        Node temp = head;
        if(temp == null) {
            head = newNode;
            return;
        }

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void deleteNode(int loc){
        Node temp = head;
        if(loc == 0) {
            head = temp.next;
            return;
        }
        for(int i=0;i<loc-1 && temp!=null; i++){
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return;
        Node nextNode = temp.next.next;
        temp.next = nextNode;
    }

    public void displayAll(){
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String args []){
        LinkList ll = new LinkList();
        ll.append(10);
        ll.push(1);
        ll.push(2);
        ll.push(4);
        ll.push(5);

        ll.insertAfter(ll.head.next.next, 3);
        ll.append(100);
        ll.displayAll();
    }
}
