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
		} else{
			while (nodeNext.next != null){
				nodeNext = nodeNext.next;
			}
			nodeNext.next = newNode;
		}
	}
	
	// метод вывода всех элементов
	public void printList(){
		Node ndNode = head;
		while (ndNode != null){
			System.out.print(" " + ndNode.data);
			ndNode = ndNode.next;
		}
	}
	
	// метод для тестирования. method for tests.
	public int countList(){
		Node ndNode = head;
		int countLt = 0;
		while (ndNode != null){
			ndNode = ndNode.next;
			countLt++;
		}
		return countLt;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.Add(2);
		rll.Add(4);
		rll.Add(6);
		if (rll.countList() >=3) System.out.println("Test correct. Тест выполнен!");
		rll.printList();
	}

}
