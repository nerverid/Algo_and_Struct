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
	
	// Метод для разворота всего списка.
	public Node reverse (){
			Node prev = null; 		// Потребуются указатель на предыдущий элемент
			Node current = head;	// Курсор на текущий элемент
			Node next = null;		// Указатель на следующий
			while (current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			head = prev;
		return head;
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
		rll.printList();
		// Тест на добавлление в список. Test for add to List
		if (rll.countList() >=3) System.out.println("Test correct. Тест выполнен!");
		// Тест на разворот списка, последний элемент должен стать заголовком. Test for reverse List.
		rll.reverse();
		if (rll.head.data == 6) System.out.println("Test complit. Тест пройден.");
		rll.printList();
	}
}
