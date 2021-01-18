package com.blogspot.nerverid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackX{
	private char [] stackxc;
	private int top;
	
	StackX(int size){
		stackxc = new char[size];
		top = -1;
	}
	
	public void insert (char data) {
		stackxc[++top] = data;
	}
	
	public char peek() {
		return stackxc[top];
	}
	
	public void remove(){
		stackxc[top--] = 0;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public char pop() {
		return stackxc[top--];
	}
}

class ReverseX{
	private String input;
	private String output;
	ReverseX(String in){
		input = in;
	}
	
	public String revX() {
		int stackSize = input.length();
		StackX stackXrev = new StackX(stackSize);
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			stackXrev.insert(ch);
		}
		
		output = "";
		
		while (!stackXrev.isEmpty()) {
			char ch = stackXrev.pop();
			output = output + ch;
		}
		
		return output;
	}
}

public class TestBracketsStack {

	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.println("Enter a string: ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			ReverseX theReverse = new ReverseX(input);
			output = theReverse.revX();
			System.out.println("Reverse: " + output);
		}
	}
	
	public static String getString () throws IOException {
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
