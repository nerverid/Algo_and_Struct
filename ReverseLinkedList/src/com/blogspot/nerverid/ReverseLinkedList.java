package com.blogspot.nerverid;

public class ReverseLinkedList {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
		
		Node (){
			this.data = 0;
			next = null;
		}
	}
	
	// Метод добавления элемента. Add elements method
	public void Add(int data){
		Node newNode = new Node(data);
		Node nodeNext = head;
		newNode.next = null;
		if (head == null){
			head = newNode;
		} else {
			while (nodeNext != null){
				nodeNext = nodeNext.next;
			}
			nodeNext.next = newNode;
		}
	}
	
	// метод вывода всех элементов
	public void printList(){
		Node ndNode = head;
		while (ndNode != null){
			System.out.print(" " + ndNode);
			ndNode = ndNode.next;
		}
	}
	
	static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.Add(2);
		rll.Add(4);
		rll.Add(6);
		rll.printList();
	}

}
