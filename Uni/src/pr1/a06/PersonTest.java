package pr1.a06;

import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList;

public class PersonTest {

	public static void main(String[] args) {
		Person person1 = new Person("Oliver", "Burke", 1993);
		Person person2 = new Person("Davie", "Selke", 1984);
		Person person3 = new Person(person2);
		PersonList personList = PersonFactory.createTestPersonliste();
		Person person4 = new Person(personList.get(0));
		
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		System.out.println(person4);
	}
	
}
