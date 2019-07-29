package com.blogspot.nerverid;

public class Test {

	Node head;
	
	public static void main(String[] args) {
		LinkedList llist = new LinkedList(); 
	    
		Test test = new Test();
		
		System.out.println("Тест на пустоту созданного связанного списка.");
		if(llist.testCountNode() == 0){
			System.out.println("Список пуст, Тест пройден!");
		}
		
		/*
		 * Тестируем на произвольно заданные элементы
		 */
		System.out.println("Тестируем на произвольно заданные элементы.");
		llist.head  = new Node(1); 
		Node second = new Node(2); 
		Node third  = new Node(3);       				 
		llist.head.next = second; 
		second.next = third; 
		if (llist.testCountNode() == 3){
			System.out.println("Добавлено три элемента. Тест пройден!");
		}		
		
		System.out.println("Тестируем на удаление по значению.");
		llist.remove(3);
		if (llist.testCountNode() < 3){
			System.out.println("Осталось " +  llist.testCountNode() + " элемента." +" Тест пройден!");
		}
		
		System.out.println("Тестируем добавление элемента по методу.");
		llist.addFront(4);
		if (llist.testCountNode() >= 3){
			System.out.println("Стало " +  llist.testCountNode() + " элемента." +" Тест пройден!");
		}
		
		//llist.addBack(16);
		llist.testCountNode();
		llist.printList();
	}	
}
