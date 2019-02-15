package com.blogspot.nerverid;

import java.io.*;
import java.util.Scanner;

public class myTriangleNumbers {
	
	private static int theNumber;
	
	public static void main(String[] args) {
		System.out.println("Insert number");
		Scanner scanner = new Scanner(System.in) ;
		theNumber = Integer.parseInt(scanner.next());
		System.out.println("\n"+ triangles(theNumber));
		
		System.out.println("Insert factorial:");
		theNumber = Integer.parseInt(scanner.next());
		System.out.println("\n" + factorial(theNumber));
	}

	public static int triangles (int size) {
		int answe;
		if (size == 1) return 1 ;
		else {
			answe = (size + triangles(size - 1));
			System.out.print(" " + answe);
		}
		return answe;
	}
	
	public static int factorial(int size) {
		if (size == 0) return 1;
		else {
			return (size * (factorial(size-1)));
		}
	}
}
