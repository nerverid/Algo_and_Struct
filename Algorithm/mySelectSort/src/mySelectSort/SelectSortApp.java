package mySelectSort;

import java.util.Scanner;

class SelectSort{
	
	private  int [] sArray;
	
	SelectSort(int size){
		sArray = new int [size];
		for (int i=0; i< sArray.length; i++) {
			sArray[i] = 0;
		}
	}
	
	public void display() {
		for(int i = 0; i< sArray.length; i++) {
			System.out.print(sArray[i] + " ");
		}
		System.out.println();
	}
	
	public void insert(int diap) {
		for(int i=0; i < sArray.length; i++) {
			sArray[i] = (int)(Math.random() * diap);
		}
	}
	
	public void selectSorting() {
		int min;
		int position = 0;
		int temp;
		for (int i = 0; i < sArray.length; i++) {
			min = i;
			for (int k = i; k < sArray.length; k ++) {
				if (sArray[k] < sArray[min]) {
					min = k;
				}	
			}
			SwapArr(min, i);
		}
	}
	
	public void SwapArr (int position, int inter) {
		int temp;
		temp = sArray[inter];
		sArray[inter] = sArray[position];
		sArray[position] = temp;
	}
	
	public void delete() {
		
	}
	
	public void find() {
		
	}
	
}

public class SelectSortApp {


	
	public static void main(String[] args) {
		
		SelectSort sSortAr = new SelectSort(20);
		sSortAr.insert(50);
		sSortAr.display();
		
		sSortAr.selectSorting();
		sSortAr.display();
		
		System.out.println();
		Scanner keyboard = new Scanner(System.in);
		int fiKi = keyboard.nextInt();
		sSortAr.find();
		sSortAr.delete();
		sSortAr.display();
	}

}
