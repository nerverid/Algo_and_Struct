package com.blogspot.nerverid;
/*
 * @author nerverid
 * this code espetialy for study myself
 */
class myNode {
	private int myData;
	myNode next;
	myNode prev;
	
	myNode (){
		myData = 0;
		next = null;
		prev = null;
	}
	
	myNode (int data){
		myData = data;
		next = null;
		prev = null;
	}
	
	public int getData() {
		return myData;
	}
}

class myQueue{
	
	private myNode head = null, tail = null;
	private int emptySet = 0;
	
	public void insert(int data) {
		if (tail == null) {
			myNode node = new myNode(data);
			head = node;
			tail = node;
			emptySet ++;
		} else {
			myNode node = new myNode(data);
			tail.next = node;
			node.prev = tail;
			tail = node;
			emptySet++;
		}
	}
	
	public boolean remove () {
		if (tail == null) {
			return false;
		}else {
			tail.prev.next = null;
			tail = tail.prev;
			emptySet--;
			return true;
		}
	}
	
	public int peek() {
		return tail.getData();
	}
	
	
	public int getCountEle() {
		return emptySet;
	}
}

public class myQueueApp {

	public static void main(String[] args) {
		myQueue myQue = new myQueue ();
		
		System.out.println("Create queue...");
		myQue.insert(5);
		myQue.insert(7);
		myQue.insert(1);
		myQue.insert(2);
		
		System.out.println("Element is tail of queue... " + myQue.peek());
		System.out.println(myQue.getCountEle());
		
		
		System.out.println(myQue.remove());
		System.out.println("Element after remove... " + myQue.peek());
		System.out.println(myQue.getCountEle());
	}
}
