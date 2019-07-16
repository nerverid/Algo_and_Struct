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
	private int numItem;
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
		return (numItem == ORDER-1)? true :false;
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
	
	
	
}

public class Tree234Ap {

	public static void main(String[] args) {
		
	}

}
