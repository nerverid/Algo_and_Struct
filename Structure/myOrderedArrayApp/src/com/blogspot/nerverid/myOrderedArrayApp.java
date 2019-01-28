package com.blogspot.nerverid;

class OrderedArray{
	
	private long [] a;
	private int nElements; // All elements
	private int elementMorph; //previos status elements
	
	OrderedArray(int size){
		a = new long [size];
		nElements = 0;
		elementMorph = 0;
		System.out.println("Array created!");
	}
	
	// binary search, в методе бинарный поиск
	public void find(long searchElem) {
		int maxElem = nElements-1;
		int minElem = 0;
		int midElem;
		while (true) {
			midElem = (maxElem + minElem) / 2;
			if(a[midElem] == searchElem) {
				System.out.println("Found!");
				break;
			} else if (minElem > maxElem) {
				System.out.println("Not Found!");
				break;
			}
			else {
				if (a[midElem] < searchElem) 
					minElem = midElem + 1;
				else if (a[midElem] > searchElem) 
					maxElem = midElem - 1;
			}
		}
		
	}
	
	// binary search, move elements
	// двоичный поиск, удаление элемента сдвигая массив
	public void delete(long searchDel) {
		int i;
		for (i = 0; i< nElements; i++) {
			if (a[i] == searchDel) 
				break;
		}
		for (; i < nElements ; i++) {
			a[i] = a[i+1];
			nElements--;
		}
	}
	
	// linear-search, move elements, inserting
	// линейный поиск, сдвиг элементов если необходимо, вставка.
	public void insert(long inElem) {
		int i;
		for (i = 0; i < nElements; i++) {
			if(a[i] > inElem)	break;
		}
		for (int j = nElements; j > i; j--) {
			a[j] = a[j-1];
		}
		a[i] = inElem;
		nElements++;
			
	}
	
	// printing all elements of array
	public void display () {
		for (int i =0; i < nElements; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	// method for test, counting elements in array
	// метод для тестирования, считает количество элементов.
	public void testArr () {
		if ((elementMorph < nElements)||(elementMorph > nElements)) {
			System.out.println("Array was morphing!");
			elementMorph = nElements;
		}
	}
}


public class myOrderedArrayApp {

	public static void main(String[] args) {
		OrderedArray nArr = new OrderedArray(20);
		nArr.testArr();
		nArr.display();
		
		nArr.insert(2);
		nArr.testArr();
		nArr.display();
		
		nArr.insert(4);
		nArr.insert(16);
		nArr.insert(8);
		nArr.insert(10);
		nArr.insert(13);
		nArr.insert(6);
		nArr.testArr();
		nArr.display();
		
		nArr.delete(8);
		nArr.display();
		
		nArr.insert(7);
		nArr.insert(9);
		nArr.delete(10);
		nArr.insert(14);
		nArr.display();
		
		nArr.find(7);
		nArr.find(9);
		nArr.find(8);
		nArr.display();
	}

}
