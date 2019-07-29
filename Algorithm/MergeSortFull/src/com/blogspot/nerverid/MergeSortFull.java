package com.blogspot.nerverid;

class MSArray{
	
	private long []myArray;
	int nElems;
	
	MSArray(int size){
		myArray = new long [size];
		nElems = 0;
	}
	
	MSArray(){
		myArray = new long [20];
		nElems = 0;
	}
	
	public void insert(long Elem) {
		if (nElems-1 == myArray.length) {
			System.out.println("Array is full");
			return;
		} else	{
			myArray[nElems] = Elem;
			nElems++;
		}
	}
	
	public void display() {
		for (int i = 0; i < nElems; i ++) 
			System.out.print(" "+ myArray[i]);
		System.out.println();
	}
	
	public void findE() {
		
	}
	
	public void remove() {
		
	}
	
	public void sortM() {
		long [] workSpace = new long [nElems];
		mergeSort(workSpace, 0, nElems-1);
	}
	
	public void mergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return;
		}else {
			int mid = (lowerBound + upperBound) / 2;
			mergeSort (workSpace, lowerBound, mid);
			mergeSort (workSpace, mid+1, upperBound);
			merge(workSpace, lowerBound, mid+1, upperBound);
		}
	}
	public void merge(long [] workSpace, int lowPtr, int highPtr, int upperBound) {
		int i = 0;
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n = upperBound-lowerBound+1;
		while(lowPtr <= mid && highPtr <= upperBound) {
			if (myArray[lowPtr] < myArray[highPtr]) {
				workSpace[i++] = myArray[lowPtr++];
			} else
				workSpace[i++] = myArray[highPtr++];
		}
		while (lowPtr <=mid)
			workSpace[i++] = myArray[lowPtr++];
		while (highPtr <= upperBound)
			workSpace[i++] = myArray[highPtr++];
		for(i=0; i<n; i++) {
			myArray[lowerBound + i] = workSpace[i];
		}
	}
}

public class MergeSortFull {

	public static void main(String[] args) {
		MSArray arr = new MSArray(100);
		
		arr.insert(4);
		arr.insert(9);
		arr.insert(43);
		arr.insert(2);
		arr.insert(34);
		arr.insert(11);
		arr.insert(55);
		arr.insert(42);
		arr.insert(45);
		arr.insert(65);
		arr.insert(23);
		arr.insert(16);
		arr.insert(1);
		arr.insert(8);
		
		arr.display();
		arr.sortM();
		arr.display();
	}

}
