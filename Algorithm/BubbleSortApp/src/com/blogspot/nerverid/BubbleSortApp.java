package com.blogspot.nerverid;

import java.util.Scanner;

class BubbleSort{
	
	private int [] arBubble;
	
	BubbleSort(int size){
		arBubble = new int [size];
	}
	
	public void insert() {
		for (int i = 0; i < arBubble.length; i++) {
			arBubble[i] = 1 + ((int)(Math.random()*40));
		}
	}
	
	public void bubbleSortArray() {
		for(int i=0; i < arBubble.length; i++) {
			int k = arBubble.length - i;
			for(int j = 0; j < k ; j++) {
				if(j == 19) break;
				else if (arBubble[j] > arBubble[j+1]) {
					int temp = arBubble[j];
					arBubble[j] = arBubble[j+1];
					arBubble[j+1] = temp; 
 				}
			}
		}
	}
	
	public void bubbleCombinSort() {
		for(int i=0; i <arBubble.length; i++){
			// this combing sort
		}
	}
	
	public void display() {
		for (int i = 0; i < arBubble.length; i++) {
			System.out.print(arBubble[i] + " ");
		}
		System.out.println();
	}
	
	public boolean delete (int delElem) {
		//binary search
		int max, min, middle;
		max = arBubble.length;
		min = 0;
		int positionEl;
		while (true) {
			middle = (max + min)/2;
			if (arBubble[middle] == delElem) {
				positionEl = middle;
				break;
			}
			else if (delElem < arBubble[middle]) max = middle-1;
			else if (delElem > arBubble[middle]) min = middle +1;
			else if (min == max) {
				System.out.println("Элемент не найден!");
				return false;
			}
		}
		for (int i = positionEl; i < arBubble.length; i++) {
			if ((i+1) != arBubble.length){
				arBubble[i] = arBubble[i+1];
			} else arBubble[i] = 0;
		}
		return true;
	}
	
	public int findEl (int searchEl) {
		//binary search

		int max= arBubble.length;
		int min = 0;
		int middle = 0;

		while (true) {
			middle = (max + min)/2;
			
			if (arBubble[middle] == searchEl) {
				return middle;
			}
			else if (searchEl < arBubble[middle]) max = middle-1;
			else if (searchEl > arBubble[middle]) min = middle +1;
			else if (min == max) {
				System.out.println("Элемент не найден!");
				return 0;
			}
		}
		
	}
}

public class BubbleSortApp {

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort (20);
		bs.display();
		
		bs.insert();
		bs.display();
		
		bs.bubbleSortArray();
		bs.display();
		
		System.out.println("Введите элемент!");
		//Нужно написать чтобы спрашивала какой элемент ищем
		Scanner keyboard = new Scanner(System.in);
		int nextNum = keyboard.nextInt();
		System.out.println(bs.findEl(nextNum));
		
		
		//Нужно написать какой элемнт удаляем.
		System.out.println("Перед удалением.");
		bs.display();
		System.out.println("Вводим число.");
		int nextDel = keyboard.nextInt();
		System.out.println(bs.delete(nextDel));
		bs.display();
		//TDD forever
	}

}
