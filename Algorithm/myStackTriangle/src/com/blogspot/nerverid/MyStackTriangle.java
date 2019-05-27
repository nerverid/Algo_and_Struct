package com.blogspot.nerverid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Params{
	public int n;
	public int returnAddress;
	
	public Params(int nn, int ra) {
		n = nn;
		returnAddress = ra;
	}
}

class StackX{
	private int maxSize;
	private Params [] stackArray;
	private int top;
	
	public StackX(int size) {
		maxSize = size;
		stackArray = new Params[maxSize];
		top = -1;
	}
	
	public void push (Params p) {
		stackArray[++top] = p;
	}
	
	public Params pop () {
		return stackArray[top--];
	}
	
	public Params peek() {
		return stackArray[top];
	}
	
}

public class MyStackTriangle {

	static int theNumber;
	static int theAnswer;
	static StackX theStackX;
	static int codePart;
	static Params theseParams;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number... ");
		theNumber = getInt();
		recTriangle();
		System.out.println("Triangle="+ theAnswer);
	}
	
	public static void recTriangle() {
		theStackX = new StackX(10000);
		codePart = 1;
		while (step() == false);
	}
	
	public static boolean step() {
			switch (codePart) {
				case 1:
					theseParams = new Params(theNumber, 6);
					theStackX.push(theseParams);
					codePart = 2;
					break;
				case 2:
					theseParams = theStackX.peek();
					if(theseParams.n == 1) {
						theAnswer = 1;
						codePart = 5;
					} else
						codePart = 3;
					break;
				case 3:
					Params newParams = new Params(theseParams.n - 1, 4);
					theStackX.push(newParams);
					codePart = 2;
					break;
				case 4:
					theseParams = theStackX.peek();
					theAnswer = theAnswer + theseParams.n;
					codePart = 5;
					break;
				case 5:
					theseParams = theStackX.peek();
					codePart = theseParams.returnAddress;
					theStackX.pop();
					break;
				case 6:
					return true;
			}
			return true;
	}

	public static String getString () throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		String s = br.readLine();
		return s;
	}
	
	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
	
}
