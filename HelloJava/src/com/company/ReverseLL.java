package com.company;

class Node{
	int data;
	Node next;
	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}
public class ReverseLL {
	void insert(int data, Node head) {
		if(head == null) {
			head = new Node(data, null);
			return;
		}
		Node curr = head;
		while(curr.next != null)
			curr = curr.next;
		curr.next = new Node(data, null);
	}
	
	void display(Node head) {
		if(head == null)
			return;
		Node curr = head;
		while(curr != null) {
			System.out.print(" "+curr.data);
			curr = curr.next;
		}
		System.out.println();
	}
	
	void reverse(Node head) {
		if(head == null || head.next == null) {
			System.out.print("hi");
			return;
		}
		
		Node prev, cur;
		
		prev = head;
		head = prev.next;
		prev.next = null;
		
		while(head != null) {
			cur = head.next;
			head.next = prev;
			prev = head;
			head = cur;
		}
		
		head = prev;
		display(head);
	}
	Node mergedHead = null;
	void merge(Node head2, Node head) {
		
		if(head.data < head2.data) {
			mergedHead = new Node(head.data, null);
			head = head.next;
		}else{
			mergedHead = new Node(head2.data, null);
			head2 = head2.next;
		}
		
		Node temp = mergedHead;
		
		while(head != null && head2 != null) {
			if(head.data < head2.data) {
				temp.next = head;
				head = head.next;
			}else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		
		if(head != null)
			temp.next = head;
		
		if(head2 != null)
			temp.next = head2;
		
		display(mergedHead);
	}
	public static void main(String[] args) {
		ReverseLL obj = new ReverseLL();
		Node head = new Node(0, null);
		obj.insert(10, head);
		obj.insert(30, head);
		obj.insert(60, head);
		obj.insert(80, head);
		
		Node N1 = new Node(1, null);
		obj.insert(20, N1);
		obj.insert(40, N1);
		obj.insert(90, N1);
		
		obj.display(head);
		obj.display(N1);
		
		obj.merge(N1, head);
		obj.reverse(obj.mergedHead);
	}

}
