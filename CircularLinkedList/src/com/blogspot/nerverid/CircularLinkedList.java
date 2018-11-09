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
		if (cll.count()> 1) System.out.println("Elements added. Test complit! Элементы добавлены. Тест пройден");
		
		// Test for delete element into set
		// Тестируем удаление элемента
		cll.delete(4);
		if (cll.count()<2) System.out.printkn("Element delete. Test complit! Элемент удалён. Тест пройден!")
		
		// Test inserting new element after selected element
		// Тестируем вставку элементов после выбранного
		cll.insertAfter(head.next, 5);
		if (cll.count()>=2) System.out.println ("Element inserting. Test complit! Элемент вставлен. Тест пройден!");
		// Test searching element
		// Тестируем поиск элемента.
		if (cll.search(5) != null) System.out.println("Element search complit. Test compit! Элемент найден. Тест пройден!");
		
	}

}
