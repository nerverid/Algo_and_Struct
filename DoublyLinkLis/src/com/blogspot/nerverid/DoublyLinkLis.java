package com.blogspot.nerverid;

public class DoublyLinkLis {
	
	Node head;  // Ссылка на начало списка
	Node tail;  // Ссылка на конец списка
	
	class Node{  // Внутренний класс элемента списка
		int data; 	// Какие-то данные
		Node next;	// Ссылка на последующий элемент
		Node prev;	// Ссылка на предыдущий элемент
		
		// Конструктор с параметром, инициализирует ссылки
		Node (int data){  
			this.data = data;
			next = null;
			prev = null;
		}
		
		// Конструктор без параметра, инициализирует значения и ссылки
		Node (){
			this.data = 0;
			next = null;
			prev = null;
		}
	}
	
	// Метод добавления в начало списка
	public void addFront (int data){
		Node newNode = new Node(); // Создаём элемент без параметра
		newNode.data = data;		// Вручную заносим параметр
		newNode.prev = null;		// Ссылку на предыдущий элемент ставим нулевой
		
		if (head == null){			// Если объявленные ссылки на первый и последний элементы нулевые, то есть список пустой
			head = newNode;			// Присваиваем ссылки первого и последнего элемента единственному созданному
			tail = newNode;
		} else {
			newNode.next = head;	// Иначе в новом элементе присваиваем ссылку первого элемента, ссылке на следующий.
			head = newNode;			// И ссылку заголовка ставим на вновь созданный элемент.
		}
	}
	
	// Метод добавления в конец списка.
	public void addBack (int data){
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		
		if (tail == null){	// Если объявленные ссылки на первый и последний элементы нулевые, то есть список пустой
			head = newNode; // Присваиваем ссылкам на начало и конец, единственный новый элемент
			tail = newNode;
		} else {
			tail.next = newNode;	//	Иначе ставим ссылку последнего злемнта на новый созданный
			tail = newNode;			//	ссылку конца списка присваиваем новый элемент
		}
	}
	
	// Метод вставки после указаанного элемента
	public void insertAfter(Node prevNode, int data){
		if ( prevNode != null){					// Проверяем указана ли вообще предыдущий элемент
			System.out.println("Не пустая!");
		} else return;							// Если предыдущий элемент пустой то вываливаемся из метода.
		
		Node newNode = new Node (data);
		if (prevNode != tail){
			newNode.next = prevNode.next;			// Присваиваем в новом элементе ссылке на следюущий элемент ссылку из предыдущего элемента
			prevNode.next = newNode;				// Предыдущему в качестве ссылки на следующий элемент - новый элемент
			newNode.prev = prevNode;				// В новом Эл. ссылка на предыдущий Эл.
			newNode.next.prev = newNode;			//	Если это не последний элемент то в следующем элементе ссылку на предыдущий новый Эл.
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public Node search(int data){
		Node newNode = head;
		Node nodeNon = null;
		while (newNode != null){		// Ищем от начала и до конца.
			if (newNode.data == data){
				return newNode;			//	Возвращаем либо найденный элемент
			}
			newNode = newNode.next;
		}
		return nodeNon;					//	Либо возвращаем нулевой элемент.
	}
	
	public void remove(Node headNode, Node delNode){
		if (head == null || delNode == null) return;
		if (head == delNode) {
			head = delNode.next;
			return;
		}
		if (tail == delNode) {
			tail = delNode.prev;
			return;
		}
		if (delNode.next != null) delNode.next.prev = delNode.prev;
		if (delNode.prev != null) delNode.prev.next = delNode.next;
	}
	
	// Метод подсчёта всех элементов или длинны всго списка
	public int countList(){
		Node newNode = head;
		int Count=0;
		while (newNode != null){
			newNode = newNode.next;
			Count++;
		}
		return Count;
	}
	
	// Метод вывода всех элементов, задаётся первый элемент и листается в конец списка
	public void printList(){
		Node nNode = head;
		while ( nNode != null){
			System.out.print(nNode.data + " ");
			nNode = nNode.next;
		}
		Node tNode = tail;
		while ( tNode != null){
			System.out.print(tNode.data + " ");
			tNode = tNode.prev;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkLis ddl = new DoublyLinkLis();
		/*
		 * This fragment demonstrate how to works LinkedList
		 * Этот фрагмент демонстрирует как работает Список
		 */
		/*ddl.addFront(3);
		ddl.addFront(1);
		
		ddl.addBack(5);
		ddl.addBack(7);
		
		ddl.insertAfter(ddl.head, 2);
		ddl.insertAfter(ddl.tail, 8);
		
		ddl.printList();
		
		ddl.remove(ddl.head, ddl.head.next);
		
		System.out.println(ddl.search(7));
		
		ddl.printList();
		*/
		/*
		 * Test for LinkedList
		 * Тесты для класса Списка
		 */
		// Тестируем добавление
				ddl.addFront(6);
				ddl.addFront(4);
				if(ddl.countList() > 0) System.out.println("Элементы добавлен. Тест пройден!");		
				
				ddl.addBack(7);
				ddl.addBack(8);
				
				if (ddl.countList() >= 4) System.out.println ("Элементы в конец добавлены. Тест пройден!");
				
				ddl.printList();
				
				// Добавляем элемент после заданного
				ddl.insertAfter(ddl.head.next, 5);
				if(ddl.countList() >= 5) System.out.println("Элемент добавлен. Тест пройден!");
				ddl.printList();
				
				// Тестируем удаление элемента
				ddl.remove(ddl.head, ddl.head);
				if(ddl.countList() < 5) System.out.println("Элемент удалён. Тест пройден!"); 
				ddl.printList();
				
				// Тестируем поиск
				if(ddl.search(7) != null)System.out.println("Элемент найден. Тест пройден!");
				System.out.println(ddl.search(7) + " - Тот самый элемент.");

	}

}

