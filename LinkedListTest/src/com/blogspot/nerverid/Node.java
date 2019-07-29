package com.blogspot.nerverid;

public class Node 
{ 
    int value; // Данные
    Node next; // Указатель на следующий элемент
   
    // Конструктор
    Node(int d) {
    	value = d;
    	next = null;
    } 
    Node() {
    	next = null;
    } 
} 