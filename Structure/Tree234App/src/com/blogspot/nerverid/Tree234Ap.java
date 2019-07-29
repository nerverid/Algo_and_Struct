package com.blogspot.nerverid;

import java.io.*;

class DataItem {
	public long dData;
	
	public DataItem(long dD) {
		this.dData = dD;
	}
	
	public void displayItem() {
		System.out.print("/"+ dData);
	}
}

class Node {

	private static final int ORDER = 4;
	
	Node parent;
	Node [] childArray = new Node [ORDER];
	private int numItems;
	private DataItem [] itemArray = new DataItem[ORDER -1];
	
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null) {
			child.parent = this;
		}
	}
	
	public Node disconectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	
	public Node getChild(int childNum) {
		return childArray[childNum];
	}
	
	public Node getParent() {
		return parent;
	}
	
	public boolean isLeaf() {
		return (childArray[0] == null) ? true : false;
	}
	
	public DataItem getItem(int index) {
		return itemArray[index];
	}
	
	public boolean isFull() {
		return (numItems == ORDER-1)? true :false;
	}
	
	public int findItem(long key) {
		for(int i = 0; i < ORDER-1; i++) {
			if(itemArray[i] == null)
				break;
			else if (itemArray[i].dData == key) {
				return i;
			}
		}
		return -1;
	}
	
	public int insertItem(DataItem newItem) {
		// suppose node not empty
		numItems++;
		long newKey = newItem.dData;
		
		for(int i = ORDER-2; i>=0; i--) {
			if(itemArray[i] == null) 
				continue;
			else {
				long itsKey = itemArray[i].dData;
				if (newKey < itsKey)
					itemArray[i+1] = itemArray[i];
				else {
					itemArray[i+1] = newItem;
					return i+1;
				}
			}
		}
		
		itemArray[0] = newItem;
		return 0;
	}
	
	public DataItem removeItem() {
		DataItem temp = itemArray[numItems-1];
		itemArray[numItems-1] = null;
		numItems--;
		return temp;
	}
	
	public void displayNode () {
		for (int i = 0; i<numItems; i++) 
			itemArray[i].displayItem();
		System.out.println("/");
	}
	
}

class Tree234{
	private Node root = new Node();
	
	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while (true) {
			if((childNumber=curNode.findItem(key)) != -1)
				return childNumber;
			else if (curNode.isLeaf())
				return -1;
			else 
				curNode = getNextChild(curNode, key);
		}
	}
}

public class Tree234Ap {

	public static void main(String[] args) {
		
	}

}
