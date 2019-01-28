package com.blogspot.nerverid;

class ArrayMini{
	private long [] a;
	public ArrayMini(int size) {
		a = new long [size];
	}
	
	public void setElem(int index, long value) {
		a[index] = value;
	}
	
	public long getElem(int index) {
		return a[index];
	}
}

public class LowArray {

	public static void main(String[] args) {
		
		int nElems; 
		int j;
		long searchKey;
		
		// Создание, Create
		ArrayMini myAr = new ArrayMini(100);
		myAr.setElem(0, 33);
		myAr.setElem(1, 55);
		myAr.setElem(2, 22);
		myAr.setElem(3, 77);
		myAr.setElem(4, 99);
		myAr.setElem(5, 11);
		myAr.setElem(6, 88);
		myAr.setElem(7, 44);
		myAr.setElem(8, 66);
		myAr.setElem(9, 10);
		
		nElems = 10;
		
		// Вывод, print
		for (j=0; j < nElems; j++) {
			System.out.print(myAr.getElem(j) + " ");
		}
		
		// Поиск, search
		searchKey = 88;
		for (j = 0; j < nElems; j++) {
			if (myAr.getElem(j) == searchKey) {
				System.out.println("Found Key, index = " + j );
				break;
			} else if (j == nElems) {
				System.out.println("Element Not Found!");
			}
		}
		
		// insert, Вставка
		searchKey = 70;
		for (j = 0; j < nElems; j++) {
			if (myAr.getElem(++j) > searchKey) {
				break;
			}
		}
		int i= nElems+1;
		for ( ; i>= j; i--) {
			if(i > j) myAr.setElem(i, myAr.getElem(i-1));
			if(i == j) {
				myAr.setElem(i, searchKey);
				nElems++;
				break;
			}
		}
		
		for(j=0; j < nElems; j++) {
			System.out.print(myAr.getElem(j) + " ");
		}
		System.out.println("Element inserted ");
		
		// Delete, удаление
		
		searchKey = 11;
		for(j = 0; j < nElems; j++) {
			if (myAr.getElem(j) == searchKey) break;
		}
		for (; j < nElems; j++) {
			myAr.setElem(j, myAr.getElem(j+1));
		}
		nElems--;
		
		for (j = 0; j < nElems; j++) {
			System.out.print(myAr.getElem(j) + " ");
		}
		System.out.println("Element deleted");
	}

}
