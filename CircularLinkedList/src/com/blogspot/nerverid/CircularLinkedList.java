package com.blogspot.nerverid;

public class CircularLinkedList {

	Node head;  // В отличие от Simply Linked List, или Doubly Linked List
				// нам не понадобится указатель "хвоста"-tail, так как в данной разновидности
				// последний элемент ссылается на первый. Потому и кольцевой список.
	
	class Node{
		int data;
		Node next;
		Node prev;
	}
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		
		// Test for add element into set
		// Тестируем добавление элемента
		cll.add(2);
		cll.add(4);
		if (cll.count()> 1) System.out.println("Elements added. Элементы добавлены. Тест пройден");
		
		// Test for delete element into set
		// Тестируем удаление элемента
		cll.delete(4);
		if (cll.count()<2) System.out.printkn("Element delete. Элемент удалён. Тест пройден!")
	}

}
