package com.blogspot.nerverid;

class ArraySh{
	private long [] myArray;
	private int nElem;
	
	ArraySh(int size){
		myArray = new long[size];
		nElem = 0;
	}
	
	ArraySh(){
		myArray = new long[100];
		nElem = 0;
	}
	
	public void insert(long iElem) {
		myArray[nElem++] = iElem;
	}
	
	public void display() {
		for (int i = 0; i < nElem; i++) {
			System.out.print(myArray[i] + " ");
		}
		System.out.println();
	}
	
	public void delete() {
		
	}
	
	public void theSort() {
		int inner, outer;
		long temp;
		int h = 1;
		while (h <= nElem/3) {
			h = h*3 +1;
		}
		
		while (h > 0) {
			for(outer = h; outer < nElem; outer++) {
				temp = myArray[outer];
				inner = outer;
				
				while ((inner > h-1) && (myArray[inner-h]>=temp)) {
					myArray[inner] = myArray[inner - h];
					inner -= h;
				}
				myArray[inner] = temp;
			}
			h = (h - 1)/ 3;
		}
	}
}

public class MyShellSort {	
	public static void main(String[] args) {
		int maxSize = 10;
		ArraySh arr = new ArraySh(maxSize);
		
		for(int i = 0; i < maxSize; i++) {
			int inL = (int)(Math.random()*99);
			arr.insert(inL);
		}
		
		arr.display();
		
		arr.theSort();
		
		arr.display();
	}

}
