package com.blogspot.nerverid;

class Node{
	private int myData;
	private Node next;
	private Node prev;
	
	Node(int data){
		myData = data;
		next = null;
		prev = null;
	}
	
	public void setNext(Node node) {
		next = node;
	}
	
	public void setPrev(Node node) {
		prev = node;
	}
	
	public int getData() {
		return myData;
	}
	
	public Node getNext() {
		return next;
	}
	
	public Node getPrev() {
		return prev;
	}
}

class myDeque{
	
	private Node head;
	private Node tail;
	
	public void insert(int data) {
		insertBack(data);
	}
	
	public void insertFront(int data) {
		if (head == null) {
			Node node = new Node(data);
			node.setNext(null);
			node.setPrev(null);
			head = node;
			tail = node;
		} else {
			Node node = new Node(data);
			node.setPrev(head);
			node.getPrev().setNext(node);
			head = node;
		}
	}
	
	public void insertBack(int data) {
		if (head == null) {
			Node node = new Node(data);
			node.setNext(null);
			node.setPrev(null);
			
			head = node;
			tail = node;
		} else {
			Node node = new Node(data);
			node.setNext(tail);
			node.getNext().setPrev(node);
			tail = node;			
		}
	}
	
	public int peek() {
		return head.getData();
	}
	
	public int displayTail() {
		return tail.getData();
	}
	
	public void remove() {
		tail = tail.getNext();
		tail.setPrev(null);
	}
}

public class myDequeApp {

	public static void main(String[] args) {
		myDeque deque = new myDeque();
		deque.insert(23);
		System.out.println("head - " +deque.peek() +" ; tail - " + deque.displayTail());
		deque.insertFront(3);
		System.out.println("head - " +deque.peek() +" ; tail - " + deque.displayTail());
		deque.insertBack(7);
		System.out.println("head - " +deque.peek() +" ; tail - " + deque.displayTail());
		deque.insert(4);
		System.out.println("head - " +deque.peek() +" ; tail - " + deque.displayTail());
		
		deque.remove();
		System.out.println("head - " +deque.peek() +" ; tail - " + deque.displayTail());
	}

}
