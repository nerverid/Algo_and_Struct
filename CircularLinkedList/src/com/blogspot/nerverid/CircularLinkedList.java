package com.blogspot.nerverid;

public class CircularLinkedList {

	Node head;  // В отличие от Simply Linked List, или Doubly Linked List
				// нам не понадобится указатель "хвоста"-tail, так как в данной разновидности
				// последний элемент ссылается на первый. Потому и кольцевой список.
	class Node{
		int data;
		Node next;
		//Node prev;
		
		Node (int data){
			this.data = data;
			next = null;
			//prev = null;
		}
		
		Node (){
			next = null;
			//prev = null;
		}
	}
	
	public void add (int data){
		Node newNode = new Node (data);
		Node last = head;
		if (head == null) {			// Проверяем на пустой список, если заголовок пуст то пишем туда элемент и выходим
			head = newNode;
			head.next = head;
			return;
		} else {							// Если список не пуст то,
			while (last.next != head) {		// перебираем весь список до заголовка таким образом у нас кольцевой список элемента
				last = last.next;
			}
			last.next = newNode;       // В последний элемент пишем.
			newNode.next = head;		// и последний элемент обязательно ссылается на заголовок он же первый элемент
		}
	}
	

	public void delete (int data){
		Node last = head;
		CircularLinkedList ccl = new CircularLinkedList();
		if (head == null){
			System.out.println("Sets havn't Elements");
			return;
		}
		if (data == head.data){
			head = null;
		} else{
			do {
				if (last.next.data == data) break; // если нашли совпадение то прерываем цикл и пробрасываем ссылку на следующий элемент таким образом элемент удаляется (выпадает)
				last = last.next;
			} while (last != head);
			last.next = last.next.next;
		}		
	}
	
	public int search (int data){
		return 0;
	}
	
	public int count (){
		Node newNode = head;
		int countN = 0;
		do {
			countN++;
			newNode = newNode.next;
		} while (newNode != head);		// в каждом цикле листаем список до первого-заголовка элемента, список кольцевой
		System.out.println("Nodes = " + countN);
		return countN;
	}
	
	public void printList() {
		Node newNode = head;
		do {
			System.out.print(newNode.data + " ");
			newNode = newNode.next;
		} while (newNode != head);		// в каждом цикле листаем список до первого-заголовка элемента, список кольцевой
	}
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		
		// Test for add element into set
		// Тестируем добавление элемента
		cll.add(2);
		cll.add(4);
		if (cll.count()> 1) System.out.println("Elements added. Test complit! Элементы добавлены. Тест пройден");
		cll.printList();
		
		// Test for delete element into set
		// Тестируем удаление элемента
		cll.delete(4);
		if (cll.count()<2) System.out.println("Element delete. Test complit! Элемент удалён. Тест пройден!");
		cll.printList();
		/*
		// Test inserting new element after selected element
		// Тестируем вставку элементов после выбранного
		cll.insertAfter(head.next, 5);
		if (cll.count()>=2) System.out.println ("Element inserting. Test complit! Элемент вставлен. Тест пройден!");
		// Test searching element
		// Тестируем поиск элемента.
		if (cll.search(5) != null) System.out.println("Element search complit. Test compit! Элемент найден. Тест пройден!");
		*/
	}

}
