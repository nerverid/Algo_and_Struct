package com.blogspot.nerverid;

class ArrBR {
	
	private long [] arrBRS;
	private int nElem = 0;
	
	public ArrBR(int max) {
		arrBRS = new long [max];
	}
	
	public void insert (long data) {
		int curI = 0;
		if(nElem == 0) {
			arrBRS [0] = data;
			nElem++;
			return;
		} else
			for(int i=0; i < nElem; i++) {
				if (arrBRS[i] > data) {
					curI = i;
					break;
				} else if ((i+1) == nElem) {
					arrBRS [i+1] = data;
					nElem++;
					return;
				}
			}
		for (int i = (nElem); i > curI; i--) {
			arrBRS[i] = arrBRS[i-1];
		}
		arrBRS[curI] = data;
		nElem++;
		return;
	}
	
	public void display() {
		for (int i = 0; i < nElem; i++) {
			System.out.print(" " + arrBRS[i] );
		}
	}
	
	public void serchElem (long searchEl) {
		if ((findRecurs(searchEl, 0, nElem-1))> nElem) {
			System.out.print("\n Not Found");
		} else
			System.out.print("\n" + findRecurs(searchEl, 0, nElem-1));
	}
	
	private int findRecurs(long searchEl, int lowerEl, int upperEl) {
		int cursEl;
		cursEl = (lowerEl + upperEl)/2;
		if (searchEl == arrBRS[cursEl])
			return cursEl;
		else if(lowerEl > upperEl)
			return nElem+1;
		else {
			if (searchEl > arrBRS[cursEl])
				return findRecurs (searchEl, cursEl+1, upperEl);
			else
				return findRecurs (searchEl, lowerEl, cursEl-1);
		}
	}
}


public class RecursionBinarySearch {
	
	public static void main(String[] args) {
		ArrBR arrBR = new ArrBR(20);
		arrBR.insert(23);
		arrBR.insert(3);
		arrBR.insert(25);
		arrBR.insert(7);
		arrBR.insert(32);
		arrBR.insert(4);
		arrBR.insert(21);
		arrBR.insert(11);
		arrBR.insert(19);
		arrBR.display();
		arrBR.serchElem(7);
		arrBR.serchElem(24);
	}

}
