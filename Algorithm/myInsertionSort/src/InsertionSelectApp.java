/*
 * @author nerverid
 * @version 0.01
 * class for learning
 * Sorting of insertion method
 * Сортировка методом вставки
 */
import java.util.Scanner;

class InsertionSelect{
	int [] isArr;
	
	InsertionSelect(int size){
		isArr = new int [size];
		insert();
	}
	
	public void insert() {
		for (int i = 0; i < isArr.length; i++) {
			isArr[i] = (int)(Math.random()* 50);
		}
	}
	
	public void display() {
		for (int i = 0; i < isArr.length; i++) {
			System.out.print(isArr[i] + " ");
		}
		System.out.println();
	}
	
	public void insertSelectArr() {
		int in, out;
		for (out = 1 ; out < isArr.length; out++) {
			int temp = isArr[out];
			in = out;
			while ((in>0)&& (isArr[in-1] >= temp)) {
				isArr[in] = isArr[in-1];
				--in;
			}
			isArr[in] = temp;
		}
	}
	
	public int find(int findNum) {
		//binary search
		int min =0;
		int max = isArr.length;
		//System.out.println("max - " + max);
		int middle = 0;
		for (int i = 0; i < isArr.length; i++) {
			middle = (min + max) / 2;
			
			if (min == max) {
				System.out.println("Not found!");
				break;
			} else if (isArr[middle] == findNum){
				return middle;
			} else if (findNum < isArr[middle]) {
				max = middle-1;
			} else if (findNum > isArr[middle]) {
				min = middle+1;
			}
		}
		return 0;
	}
	
	public void delete(int deleteElem) {
		int posDel = find(deleteElem);
		
		for (int i = posDel; i  < isArr.length; i++) {
			if (i == (isArr.length - 1)) {
				isArr[i] = 0;
				break;
			} else {
				
				isArr[i] = isArr[i+1];
			}
		}
	}
}

public class InsertionSelectApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Insert size of array: ");
		int inSize = keyboard.nextInt();
		
		InsertionSelect isArr = new InsertionSelect(inSize);
		isArr.display();
		
		isArr.insertSelectArr(); // sorting
		isArr.display();
		
		System.out.println("Insert find of number:");
		inSize = keyboard.nextInt();
		System.out.println("Found of position - " + isArr.find(inSize));
		
		System.out.println("Insert delete number:");
		inSize = keyboard.nextInt();
		isArr.delete(inSize);
		isArr.display();
	}

}
