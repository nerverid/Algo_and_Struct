package com.blogspot.nerverid;

import java.io.*;

public class myAnagramm {

	private static int size;
	private static int count;
	private static char [] arrChar = new char[100];
	
	public static void main(String[] args) {
		System.out.print("Enter a word: ");
		try {
			String input = getString();
			size = input.length();
			count = 0;
			for (int i = 0; i < size; i++) {
				arrChar[i] = input.charAt(i);
			} 
			doAnagramm(size);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void doAnagramm(int newSize) {
		if (newSize == 1)
			return ;
		for (int i = 0; i< newSize; i++) {
			doAnagramm(newSize-1);
			if (newSize == 2)
				displayWord();
			rotate(newSize);
		}
	}
	
	public static void displayWord() {
		if(count < 99) {
			System.out.print(" ");
		}
		if (count < 9) {
			System.out.print(" ");
		}
		System.out.print(++count + " ");
		for (int i = 0 ; i < size; i++) {
			System.out.print(arrChar[i]);
		}
		System.out.print("   ");
		System.out.flush();
		if(count%6 == 0)
			System.out.println("");
	}
	
	public static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position];
		for (j = position + 1; j < size; j++)
			arrChar[j-1] = arrChar[j];
		arrChar [j - 1] = temp;
	}
	
	public static String getString () {
		String s = null;
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader newread = new BufferedReader(reader);
		try {
			s = newread.readLine();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return s; 
	}

}
