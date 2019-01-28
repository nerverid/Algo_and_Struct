package myClassDataArray;


class Person {
	private String firstName;
	private String lastName;
	private int age;
	
	Person (String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public void displayPerson() {
		System.out.println("First Name - " + firstName);
		System.out.println("Last name - " + lastName);
		System.out.println("Age - " + age);
	}
	
	public String getLastName() {
		return lastName;
	}
}

public class classDataArray {
	
	private Person [] a;
	private int nElems;
	
	classDataArray(int max){
		a  = new Person [max];
	}
	
	public void find(String searchLastName) {
		int i;
		for (i = 0; i< nElems; i++) {
			if(searchLastName.equals(a[i].getLastName())) {
				System.out.println("Person Found!");
				break;
			}
		}
		if (i == nElems) {
			System.out.println("Person not Found!");
		}
	}
	
	public void insert(String firstName, String lastName, int age) {
		if (nElems>0) { 
			a[nElems] = new Person (firstName, lastName, age);
			nElems++;
		} else if (nElems == 0) {
			a[0] = new Person (firstName, lastName, age);
			nElems++;
		}
	}
	
	public void delete(String searchLastName) {
		int k;
		for (k = 0; k < nElems; k++) {
			if (a[k].getLastName().equals(searchLastName)) break;
		}
		if (k == (nElems)) {
			System.out.println("Not found");
			return;
		} else {
			for (;k < nElems; k++) {
				a[k] = a[k+1];
			}
			nElems--;
		}
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
		//	System.out.print(i + " - ");
			a[i].displayPerson();
		}
	}
}

class classDataArrayApp{
	public static void main (String args []) {
		classDataArray cDA = new classDataArray (20);
		cDA.insert("Kristian", "Bell", 41);
		cDA.insert("Harry", "Potter", 35);
		cDA.insert("Carloss", "Castaneda", 59);
		cDA.insert("Jillian", "Anderson", 50);
		cDA.display();
		
		cDA.delete("Potter");
		cDA.display();
		
		cDA.delete("");
		cDA.find("Potter");
		cDA.find("Castaneda");
	}
}
