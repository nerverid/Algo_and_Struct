package com.blogspot.nerverid;

import java.io.*;

class StackX{
	private static int nElem;
	private int [] eArray;
	
	StackX (int size){
		eArray = new int[size];
		nElem = -1;
	}
	
	public int pop() {
		return eArray[nElem--];
	}
	
	public void push(int inElem) {
		if ((nElem+1 ) != eArray.length) {
			eArray[++nElem] = inElem;
		}
	}
	
	public int peek() {
		return eArray[nElem];
	}
	
	public boolean isEmpty() {
		return (nElem == -1);
	}
}

public class StackTriangle2 {

	private static int theNumber;
	private static int theAnswer;
	private static StackX theStack;
	
	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		try {
			theNumber = getInt();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		stackTriang();
		System.out.println("Triangle " + theAnswer);
	}

	public static void stackTriang() {
		theStack = new StackX(1000);
		theAnswer = 0;
		
		while (theNumber > 0) {
			theStack.push(theNumber);
			--theNumber;
		}
		
		while (!theStack.isEmpty()) {
			int newN = theStack.pop();
			theAnswer += newN;
		}
	}
	
	public static int getInt() throws IOException{
		int n;
		n = Integer.parseInt(getString());
		return n;
	}
	
	public static String getString() throws IOException{
		InputStreamReader reader = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader(reader);
		String s;
		s = br.readLine();
		return s;
	}
}
