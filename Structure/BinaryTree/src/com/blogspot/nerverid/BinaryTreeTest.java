package com.blogspot.nerverid;

class Node{
	public Node leftChild;
	public Node rightChild;
	public int idNode;
	public double dData;
	
	Node (int id, double data){
		this.idNode = id;
		this.dData = data;
	}

	public void display() {
		System.out.print(" " + idNode + " : " + dData);
	}
	
}

class BinaryTree{
	private Node root;
	
	BinaryTree(){
		root = null;
	}
	
	public void insertNode(int idNode, double dataNode) {
		Node newNode = new Node(idNode, dataNode);
		
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (current.idNode > idNode) {
					current = current.leftChild ;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void displayTree() {
		
	}
}

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insertNode(55, 45.98);
	}

}
