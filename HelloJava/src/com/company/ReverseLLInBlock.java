package com.company;

class Node1{
	int data;
	Node1 next;
	Node1(int data, Node1 next){
		this.data = data;
		this.next = next;
	}
}
public class ReverseLLInBlock {
	static void reverseBlock(Node1 head) {
		Node1 cur = head;
		Node1 prev = head;
		int c=0;
		while(cur != null) {
			c++;
			if(c%2 == 0) {
				int tmp=cur.data;
				cur.data = prev.data;
				prev.data = tmp;
			}
			prev = cur;
			cur = cur.next;
		}
		
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		ReverseLLInBlock r = new ReverseLLInBlock();
		Node1 n8 = new Node1(8, null);
		Node1 n7 = new Node1(7, n8);
		Node1 n6 = new Node1(6, n7);
		Node1 n5 = new Node1(5, n6);
		Node1 n4 = new Node1(4, n5);
		Node1 n3 = new Node1(3, n4);
		Node1 n2 = new Node1(2, n3);
		Node1 head = new Node1(1, n2);
		Node1 t = head;
		while(t != null) {
			System.out.print(t.data+" ");
			t = t.next;
		}
		System.out.println();
		reverseBlock(head);
	}

}
