package com.blogspot.nerverid;


class StackOnArray{
	
	private int [] isArray;
	private int marker;
	
	StackOnArray(int size){
		isArray = new int [size];
		marker = -1;
	}
	
	public void push(int inElem) {
		isArray[++marker] = inElem;
	}
	
	public void pop () {
		marker--;
	}
	
	public int peek() {
		System.out.println("Last element is " + isArray[marker]);
		return marker;
	}
	
	public boolean isEmpty(){
		if (marker != -1 ) {
			return false;
		}
		else return true;
	}
}

public class myStackOnArray {
	
	public static void main(String[] args) {
		StackOnArray stack = new StackOnArray(10);
		System.out.println("is Stack empty? - " + stack.isEmpty());
		stack.push(2);
		stack.push(4);
		stack.push(7);
		System.out.println("Is Stack empty? - " + stack.isEmpty());
		stack.peek();
		stack.pop();
		stack.peek();
	}

}
