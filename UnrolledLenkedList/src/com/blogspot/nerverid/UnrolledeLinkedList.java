package com.blogspot.nerverid;

import java.util.Random;

public class UnrolledeLinkedList {

	Node head;
	
	public class Node{
		int data;
		int dataArray[];
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
		n1.dataArray = new int[5]; // How many elements to default
		if (head == null) {
			n1.dataArray[0]=1;
			n1.dataArray[1]=2;
			n1.dataArray[2]=3;
			head = n1;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = n1;
		}
	}
	
	public void insertNode(int data, int lengthArrayNew){
		Node n1 = new Node (data);
		n1.dataArray = new int[lengthArrayNew];
		Random random = new Random();
		if (head == null) {
			for (int i =0 ; i< lengthArrayNew; i++) {
				n1.dataArray[i] = random.nextInt(10);
			}
			head = n1;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = n1;
		}
	}
	
	// Method for Tests. Count each elements 
	// Метод для подсчёта всех элементов. Нужен для тестирования ваставки/удаления
	public void countList() {
		Node nextNode = head;
		while (nextNode != null) {
			System.out.println("Node - " + nextNode.data);
			for(int i = 0; i < nextNode.dataArray.length; i++) {
				System.out.print(" " + nextNode.dataArray[i]);
			}
			nextNode = nextNode.next;
		}
	}
	
	// This method for print each elements of List and elements of Nodes
	// Метод для вывода каждого элемента списка, и каждого элемента узла списка
	public void printList (){
		Node nextNode = head;
		while(nextNode != null){
			System.out.println("Node - " + nextNode.data);
			for (int i=0 ; i< nextNode.dataArray.length; i++){
				System.out.print(" " + nextNode.dataArray[i]);
			}
			System.out.println("");
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
		ull.insertNode(2, 8);
		ull.printList();
	}

}
