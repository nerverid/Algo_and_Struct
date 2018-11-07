package com.blogspot.nerverid;

public class LinkedList {
	Node head; // указатель на первую ноду
	Node tail; // указатель на последний элемент
	/*
	 * Вывод всех элементов.
	 */  
    public void printList() 
    { 
        Node n = head; 
        while (n != null) 
        { 
            System.out.print(n.value+" "); 
            n = n.next; 
        } 
    } 
    
    /*
	 * Считаем сколько элементов
	 */
    public int testCountNode ()
	{
		Node t = head;
		int countNode = 0;
		while (t != null){
			t = t.next;
			countNode++;
		}
		return countNode;
	}
    
    void addFront(int data)           //добавить спереди
    {
        Node a = new Node();  //создаЄм новый элемент
        a.value = data;              //инициализируем данные. 
                                    // указатель на следующий элемент автоматически инициализируетс¤ как null
        if(head == null)            //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        }
        else {
            a.next = head;          //иначе новый элемент теперь ссылаетс¤ на "бывший" первый
            head = a;               //а указатель на первый элемент теперь ссылаетс¤ на новый элемент 
        }
    }
 
    void addBack(int data) {          //добавление в конец списка
        Node a = new Node();  //создаЄм новый элемент
        a.value = data;
        if (tail == null)           //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = new Node (a.value);               //т.е. список теперь состоит из одного элемента
            tail = a;
        } else {
        	/*
            tail.next = a;          //иначе "старый" последний элемент теперь ссылается на новый
            tail = a;
            */               //а в указатель на последний элемент записываем адрес нового элемента
        	Node last = head;
        	while (last.next != null){
        		last = last.next;
        	}
        	last.next = a;
        	return;
        }
    }
 
    void remove(int data)          //удаление элемента
    {
        if(head == null)        //если список пуст - 
            return;             //ничего не делаем
 
        if (head == tail) {     //если список состоит из одного элемента
            head = null;        //очищаем указатели начала и конца
            tail = null;
            return;             //и выходим
        }
 
        if (head.value == data) {    //если первый элемент - тот, что нам нужен
            head = head.next;       //переключаем указатель начала на второй элемент
            return;                 //и выходим
        }
 
        Node t = head;       //иначе начинаем искать
        while (t.next != null) {    //пока следующий элемент существует
            if (t.next.value == data) {  //проверяем следующий элемент
                if(tail == t.next)      //если он последний
                {
                    tail = t;           //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next;   //найденный элемент выкидываем
                return;                 //и выходим
            }
            t = t.next;                //иначе ищем дальше
        }
    }
 
}