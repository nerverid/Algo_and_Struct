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
	
	public void disconectChild(int childNum) {
		
	}
	
}

public class Tree234Ap {

	public static void main(String[] args) {
		
	}

}
