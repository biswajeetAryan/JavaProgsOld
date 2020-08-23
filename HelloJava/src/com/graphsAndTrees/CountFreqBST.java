package com.graphsAndTrees;

public class CountFreqBST {
	class Node{
		int data;
		int freq = 1;
		Node left, right;
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	Node root;
	
	CountFreqBST(){
		root = null;
	}
	
	public void insert(int val){
		root = insertRec(root, val);
	}
	
	public Node insertRec(Node root, int val) {
		if(root == null) {
			return new Node(val);
		}
		if(root.data == val) {
			root.freq++;
		}
		if(root.data < val) {
			root.right = insertRec(root.right, val);
		}else if(root.data > val) {
			root.left = insertRec(root.left, val);
		}
		
		return root;
	}
	
	public void delete(int val){
		root = deleteRec(root, val);
	}
	
	public Node deleteRec(Node root, int val) {
		if(root == null) {
			return root;
		}
		
		if(root.data < val) {
			root.right = deleteRec(root.right, val);
		}else if(root.data > val) {
			root.left = deleteRec(root.left, val);
		}else{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			
			root.data = getMin(root.right);
			root.right = deleteRec(root, root.data);
		}
		
		return root;
	}
	
	int getMin(Node root) {
		int min = root.data;
		while(root.left!=null) {
			min = root.left.data;
			root = root.left;
			
		}
		return min;
	}
	
	public void printBST(Node root) {
		if(root != null) {
			printBST(root.left);
			System.out.println("data = "+root.data+" freq = "+root.freq);
			printBST(root.right);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2,2,1,3,4,5,4,7,1,6};
		CountFreqBST c = new CountFreqBST();
		for(int i : arr) {
			c.insert(i);
		}
		
		c.printBST(c.root);
		
		c.delete(7);
		System.out.println("data deleted 7 ");
		c.printBST(c.root);
	}
}
