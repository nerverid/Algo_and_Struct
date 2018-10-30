package com.blogspot.nerverid;

import main.DoblyLinkedList;
import main.DoblyLinkedList.Node;

public class DoublyLinkLis {
	
	Node head;  // ������ �� ������ ������
	Node tail;  // ������ �� ����� ������
	
	class Node{  // ���������� ����� �������� ������
		int data; 	// �����-�� ������
		Node next;	// ������ �� ����������� �������
		Node prev;	// ������ �� ���������� �������
		
		// ����������� � ����������, �������������� ������
		Node (int data){  
			this.data = data;
			next = null;
			prev = null;
		}
		
		// ����������� ��� ���������, �������������� �������� � ������
		Node (){
			this.data = 0;
			next = null;
			prev = null;
		}
	}
	
	// ����� ���������� � ������ ������
	public void addFront (int data){
		Node newNode = new Node(); // ������ ������� ��� ���������
		newNode.data = data;		// ������� ������� ��������
		newNode.prev = null;		// ������ �� ���������� ������� ������ �������
		
		if (head == null){			// ���� ����������� ������ �� ������ � ��������� �������� �������, �� ���� ������ ������
			head = newNode;			// ����������� ������ ������� � ���������� �������� ������������� ����������
			tail = newNode;
		} else {
			newNode.next = head;	// ����� � ����� �������� ����������� ������ ������� ��������, ������ �� ���������.
			head = newNode;			// � ������ ��������� ������ �� ����� ��������� �������.
		}
	}
	
	// ����� ���������� � ����� ������.
	public void addBack (int data){
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		
		if (tail == null){	// ���� ����������� ������ �� ������ � ��������� �������� �������, �� ���� ������ ������
			head = newNode; // ����������� ������� �� ������ � �����, ������������ ����� �������
			tail = newNode;
		} else {
			tail.next = newNode;	//	����� ������ ������ ���������� ������� �� ����� ���������
			tail = newNode;			//	������ ����� ������ ����������� ����� �������
		}
	}
	
	// ����� ������� ����� ����������� ��������
	public void insertAfter(Node prevNode, int data){
		if ( prevNode != null){					// ��������� ������� �� ������ ���������� �������
			System.out.println("�� ������!");
		} else return;							// ���� ���������� ������� ������ �� ������������ �� ������.
		
		Node newNode = new Node (data);
		if (prevNode != tail){
			newNode.next = prevNode.next;			// ����������� � ����� �������� ������ �� ��������� ������� ������ �� ����������� ��������
			prevNode.next = newNode;				// ����������� � �������� ������ �� ��������� ������� - ����� �������
			newNode.prev = prevNode;				// � ����� ��. ������ �� ���������� ��.
			newNode.next.prev = newNode;			//	���� ��� �� ��������� ������� �� � ��������� �������� ������ �� ���������� ����� ��.
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public Node search(int data){
		Node newNode = head;
		Node nodeNon = null;
		while (newNode != null){		// ���� �� ������ � �� �����.
			if (newNode.data == data){
				return newNode;			//	���������� ���� ��������� �������
			}
			newNode = newNode.next;
		}
		return nodeNon;					//	���� ���������� ������� �������.
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
	
	// ����� �������� ���� ��������� ��� ������ ���� ������
	public int countList(){
		Node newNode = head;
		int Count=0;
		while (newNode != null){
			newNode = newNode.next;
			Count++;
		}
		return Count;
	}
	
	// ����� ������ ���� ���������, ������� ������ ������� � ��������� � ����� ������
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
		DoblyLinkedList ddl = new DoblyLinkedList();
		
		ddl.addFront(3);
		ddl.addFront(1);
		
		ddl.addBack(5);
		ddl.addBack(7);
		
		ddl.insertAfter(ddl.head, 2);
		ddl.insertAfter(ddl.tail, 8);
		
		ddl.printList();
		
		ddl.remove(ddl.head, ddl.head.next);
		
		System.out.println(ddl.search(7));
		
		ddl.printList();
	}

}
