package com.blogspot.nerverid;

public class UnrolledeLinkedList {

	Node head;
	
	public class Node{
		int data;
		int dataArray[] = new int [5];
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
		Node(){
			this.data = 0;
			this.next = null;
		}
	}
	
	public void insertNode(int data){
		Node n1 = new Node (data);
		n1.dataArray[0]=1;
		n1.dataArray[1]=2;
		n1.dataArray[2]=3;
		head = n1;
	}
	
	public void printList (){
		Node nextNode = head;
		while(nextNode != null){
			for (int nextData : nextNode.dataArray){
				System.out.print(" " + nextNode.dataArray[nextData]);
			}
			nextNode = nextNode.next;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnrolledeLinkedList ull = new UnrolledeLinkedList(); 
		
		// Test for insert into empty class without it's methods.
		// Тест на вставку в пустой класс без методов.
		ull.insertNode(1);
		ull.printList();
	}

}
