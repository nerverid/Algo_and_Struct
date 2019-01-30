package com.blogspot.nerverid;

class HighArray{
	private long [] a;
	private int nElems;
	
	HighArray(int size){
		a = new long [size];
		nElems = 0;
	}
	
	public int find(long searchElem) {
		int j;
		for ( j =0 ; j < nElems; j++) {
			if (searchElem == a[j] ) {
				System.out.println("Found!");
				break;
			} else if (j == nElems) {
				System.out.println("Not Found! "); 
				return 0;
			}
		}
		return j;
	}
	
	public void insert (long elem) {
		a[nElems] = elem;
		nElems++;
	}
	
	public void delete(long elem){
		int j;
		for (j = 0; j < nElems; j++) {
			if (elem == a[j]) {
				break;
			}
		}
		for (int k = j; k < nElems; k++) {
			a[k] = a[k+1];
		}
		nElems--;
		System.out.println("Element deleted!");
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

public class myHighArrayApp {

	public static void main(String[] args) {
		HighArray myA = new HighArray(20);
		System.out.println("Array created!");
		
		myA.insert(11);
		myA.insert(55);
		myA.insert(88);
		myA.insert(22);
		myA.insert(99);
		myA.insert(77);
		myA.display();
		System.out.println(" Elements added!");
		//Searching element
		System.out.println("position element = " + myA.find(22));
		// Delete element
		myA.delete(88);
		myA.display();
	}

}
