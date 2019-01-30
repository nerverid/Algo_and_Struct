package com.blogspot.nerverid;
/*
 * @author nerverid
 */

class Node{
	
	int DataNode;
	Node next;
	

	Node(int DataN, Node nextN){
		DataNode = DataN;
		next = nextN;
	}
	
	Node(int DataN){
		DataNode = DataN;
		next = null;
	}
}

class StackOnList{
	private int DepthStack;
	private Node head;
	private Node tail;
	
	StackOnList (){
		head = null;
		DepthStack = 0;
		tail = null;
	}
	
	public void push (int Elem) {
		if (head == null) {
			Node node = new Node(Elem);
			head = node;
			tail = node;
		} else {
			Node node = new Node (Elem, tail);
			node.next = tail;
			tail = node;
		}
	}
	
	public void pop () {
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = tail.next;
		}
	}
	
	public Node peek() {
		return tail;
	}
	
	public int displayN() {
		System.out.println(tail + " = " + tail.DataNode);
		return tail.DataNode;
	}
}

public class myStackOnListsApp {

	public static void main(String[] args) {
		StackOnList stackL = new StackOnList ();
		stackL.push(5);
		stackL.push(6);
		stackL.push(2);
		stackL.push(7);
		System.out.println(stackL.peek());
		stackL.displayN();
		stackL.pop();
		System.out.println(stackL.peek());
		stackL.displayN();
	}

}
