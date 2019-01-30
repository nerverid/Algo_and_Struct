package com.blogspot.nerverid;

public class myArrayApp {

	public static void main(String[] args) {
		int nElems =0;
		int [] myArray = new int [100];
		int searchKey = 0;
		int i;
		// Инициализация массива
		myArray [0] = 22;
		myArray [1] = 66;
		myArray [2] = 88;
		myArray [3] = 33;
		myArray [4] = 11;
		myArray [5] = 44;
		myArray [6] = 99;
		nElems = 7;
		// Вывод массива
		for (i=0; i<nElems; i++) {
			System.out.print(myArray[i] + " ");
		}
		System.out.println(" ");

		// Поиск элемента
		searchKey = 11;
		for (i = 0; i < nElems; i++) {
			System.out.print(myArray[i] +" ");
			if (myArray[i] == searchKey) {
				System.out.println("Found. Its index = " + i );
				break;
			}
		}
		if (i == nElems) System.out.println("Not found");
		
		// Вставка элемента
		searchKey = 77;
		for (i = 0; i < nElems; i++) {
			if (myArray[i+1] > searchKey) break;
		}
		++nElems;
		int j = nElems;
		while (true) {		// Начинаем с конца, так как  нам нужно сдвинуть все элементы
			myArray[j+1] = myArray[j];
			if (j==(i+1)) {
				myArray[j] = searchKey;
				break;				
			}
			j--;
		} 
		//Вывод элементов
		for (i =0; i<nElems; i++) {
			System.out.print(" "+ myArray[i]);
		}
		System.out.println(" Element inserted");
		
		// Удаление элемента
		searchKey= 33;
		for (i =0 ; i<nElems; i++) {
			if(myArray[i] == searchKey) break;
		}
		for (; i < nElems; i++) {
			myArray[i] = myArray[i+1];
		}
		nElems--;
		// Вывод элементов
		for (i = 0; i <nElems; i++) {
			System.out.print(" " + myArray[i]);
		}
		System.out.println(" Element removed");
	}
	
}
