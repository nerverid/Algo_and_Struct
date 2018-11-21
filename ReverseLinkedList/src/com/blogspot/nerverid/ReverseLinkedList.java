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
	}

}
