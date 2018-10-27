package com.blogspot.nerverid;

public class DoublyLinkLis {
	
	Node head;
	Node tail;
	
	class Node {
		int data;
		Node prev;
		Node next;
		
		// ������������
		Node (int d) {	data = d;}		
		Node (){ data = 0;}
	}
	
	// ���������� ���� � ������ ������
	public void add_front(int new_data)
	{
		Node new_Node = new Node(new_data);
		new_Node.next = head;
		new_Node.prev = null;
		
		// ���� ������ �� ������, ����������� ����������� ���� ������ �� ����� ���������
		if (head != null) head.prev = new_Node;
		
		// ����������� ��������� ����� ����� ����
		head = new_Node;
	}
	
	// ��������� ���� � ����� ������
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
		
		// ������ �� ������ � �� �����
		while (node != null)
		{
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		
		System.out.println("");
		// ������ �� ����� � ������
		while(last != null)
		{
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}
	
	public void InsertAftr(Node prim_node, int data)
	{
		// ��������� �� ����� �� ����
		if(prim_node != null)
		{
			System.out.println(" ");
			System.out.println("�� �������!");
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
		// ����� �� ������ � �� �����
		while (node != null)
		{
			if (node.data == data) {
				System.out.println ("������� ������! " + node.data);
			}
			last = node;
			node = node.next;
		}
	}
	
	// ����� �������� �� ��������, ������� ���� ����� ������� �������, � ���� ����� �� ����� �� ������� �������
    void remove(Node head_ref, Node del) { 
  
        // ��������� �� ������ �� ������ � �� ������� �� ��������� ����
        if (head == null || del == null) { 
            return; 
        } 
  
        // ���� ������ ���� � ���� ���������
        if (head == del) { 
            head = del.next; 
        } 
  
       // ���� ��������� �� ��������� �����������, ������ �� ����������, �������� �� ���������, �� ���������� �� ����������
        if (del.next != null) { 
            del.next.prev = del.prev; 
        } 
  
        // ������ ������ , �� ������. ����, ����������� ��. �� ���������� �� ����������� �� ����������
        if (del.prev != null) { 
            del.prev.next = del.next; 
        } 
  
        // �������
        return; 
    } 
	
    // ����� �������� ���������
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
		// ��������� ����������
		ddl.add_front(6);
		ddl.add_front(4);
		if(ddl.countNode() > 0) System.out.println("�������� ��������. ���� �������!");		
		
		ddl.add_end(7);
		ddl.add_end(8);
		
		if (ddl.countNode() >= 4) System.out.println ("�������� � ����� ���������. ���� �������!");
		
		ddl.print_List(ddl.head);
		
		// ��������� ������� ����� ���������
		ddl.InsertAftr(ddl.head.next, 5);
		if(ddl.countNode() >= 5) System.out.println("������� ��������. ���� �������!");
		ddl.print_List(ddl.head);
		
		// ��������� �������� ��������
		ddl.remove(ddl.head, ddl.head);
		if(ddl.countNode() < 5) System.out.println("������� �����. ���� �������!"); 
		ddl.print_List(ddl.head);
		
		// ��������� �����
		ddl.search_node(ddl.head, 7);
	}
}
