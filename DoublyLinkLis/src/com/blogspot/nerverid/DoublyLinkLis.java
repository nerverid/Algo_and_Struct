package com.blogspot.nerverid;

public class DoublyLinkLis {
	
	Node head;
	Node tail;
	
	class Node {
		int data;
		Node prev;
		Node next;
		
		// Конструкторы
		Node (int d) {	data = d;}		
		Node (){ data = 0;}
	}
	
	// Добавление ноды в начало списка
	public void add_front(int new_data)
	{
		Node new_Node = new Node(new_data);
		new_Node.next = head;
		new_Node.prev = null;
		
		// Если список не пустой, присваиваем последующей ноде ссылку на вновь созданную
		if (head != null) head.prev = new_Node;
		
		// Присваиваем указателю адрес новой ноды
		head = new_Node;
	}
	
	// Добавляем ноду в конец списка
	public void add_end(int new_data)
	{
		Node new_Node = new Node(new_data);

		Node last = head;
		
		new_Node.next = null;
		
		if (head == null){
			new_Node.prev = null;
			head = new_Node;
			return;
		}
		
		while (last.next != null){
			last = last.next;
		}
		
		last.next = new_Node;
		
		new_Node.prev = last;
	}
	
	public void print_List(Node node){
		Node last = null;
		
		// печать от начала и до конца
		while (node != null)
		{
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		
		System.out.println("");
		// печать от конца к началу
		while(last != null)
		{
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}
	
	public void InsertAftr(Node prim_node, int data)
	{
		// Проверяем не равна ли нулю
		if(prim_node != null)
		{
			System.out.println(" ");
			System.out.println("Не нулевая!");
		} else return;
		
		Node new_node = new Node(data);
		new_node.next = prim_node.next;
		prim_node.next = new_node;
		
		new_node.prev = prim_node;
		
		if (new_node.next != null){
			new_node.next.prev = new_node;
		}
		
	}
	
	public void search_node(Node node, int data){
		Node last = null;
		// поиск от начала и до конца
		while (node != null)
		{
			if (node.data == data) {
				System.out.println ("Элемент найден! " + node.data);
			}
			last = node;
			node = node.next;
		}
	}
	
	// Метод работает по принципу, задаётся нода после которой удаляем, и нода какая по счёту от которой удаляем
    void remove(Node head_ref, Node del) { 
  
        // Проверяем не пустой ли список и не нулевая ли удаляемая нода
        if (head == null || del == null) { 
            return; 
        } 
  
        // Если первая нода и есть удаляемая
        if (head == del) { 
            head = del.next; 
        } 
  
       // если удаляемая не последняя присваиваем, ссылку на предыдущий, элемента за удаляемым, на предыдущую от удаляемого
        if (del.next != null) { 
            del.next.prev = del.prev; 
        } 
  
        // меняем ссылку , на послед. элем, предыдущего эл. от удаляемого на последующий от удаляемого
        if (del.prev != null) { 
            del.prev.next = del.next; 
        } 
  
        // выходим
        return; 
    } 
	
    // Метод подсчёта элементов
    public int countNode ()
	{
		Node t = head;
		int cntNode = 0;
		while (t != null){
			t = t.next;
			cntNode++;
		}
		return cntNode;
	}
    
	public static void main(String [] args){
		
		DoublyLinkLis ddl = new DoublyLinkLis();
		// Тестируем добавление
		ddl.add_front(6);
		ddl.add_front(4);
		if(ddl.countNode() > 0) System.out.println("Элементы добавлен. Тест пройден!");		
		
		ddl.add_end(7);
		ddl.add_end(8);
		
		if (ddl.countNode() >= 4) System.out.println ("Элементы в конец добавлены. Тест пройден!");
		
		ddl.print_List(ddl.head);
		
		// Добавляем элемент после заданного
		ddl.InsertAftr(ddl.head.next, 5);
		if(ddl.countNode() >= 5) System.out.println("Элемент добавлен. Тест пройден!");
		ddl.print_List(ddl.head);
		
		// Тестируем удаление элемента
		ddl.remove(ddl.head, ddl.head);
		if(ddl.countNode() < 5) System.out.println("Элемент удалён. Тест пройден!"); 
		ddl.print_List(ddl.head);
		
		// Тестируем поиск
		ddl.search_node(ddl.head, 7);
	}
}
