package pr1.a07;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import pr1.a06.Person;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory;

public class Personen {

	
	public static void main(String[] args) {
//		aufgabeB();
		PrintWriter out = new PrintWriter(System.out, true);
		aufgabeC(out);
		out.close();
	}

	public static void aufgabeB() {
		PrintWriter out = new PrintWriter(System.out, true);
		ArrayList<Person> personList = createTestPersonliste();
		HashSet<Person> personSet = createTestPersonSet();
		// Aufgabe 5.b.1-3
		printPersons(personList, out);
		printPersons(personSet, out);
		printPersons(personList, "./listen/PersonSetAufgabe5b3.txt");
		out.close();
	}

	public static void aufgabeC(PrintWriter out) {

		;
		Scanner onePerson = new Scanner(new DirtyFileReader("./listen/sportfreunde.txt"));
		Scanner personSet = new Scanner(new DirtyFileReader("./listen/sportfreunde.txt"));

		// Aufgabe 5.c
		ArrayList<Person> onePersonSet = new ArrayList<Person>();
		onePersonSet.add(createPerson(onePerson));
		System.out.println("Personenset mit einer Person:");
		printPersons(onePersonSet, out);
		onePerson.close();

		ArrayList<Person> sportfreundePersonSet = getPersonsFrom(personSet);
		out.println("Personenset mit Scanner:");
		printPersons(sportfreundePersonSet, out);
		personSet.close();

		out.println("Personenset mit filename:");
		printPersons(getPersonsFrom("./listen/sportfreunde.txt"), out);

		// Aufgabe d
		ArrayList<Person> kommilitonenPersonSet = getPersonsFrom("./listen/kommilitonen.txt");

		// aller Sportfreunde, die auch Kommilitonen sind
		PrintWriter outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/SundK.txt"), true);
		ArrayList<Person> sportfreundeAndKommilitonen = new ArrayList<Person>(kommilitonenPersonSet);
		sportfreundeAndKommilitonen.retainAll(sportfreundePersonSet);
		printPersons(sportfreundeAndKommilitonen, outAufgabeD);
		outAufgabeD.close();

		// aller Kommilitonen, die nicht Sportfreunde sind
		outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/KaberNichtS.txt"), true);
		ArrayList<Person> kommilitonenAndNotSportfreunde = new ArrayList<Person>(kommilitonenPersonSet);
		kommilitonenAndNotSportfreunde.removeAll(sportfreundePersonSet);
		printPersons(kommilitonenAndNotSportfreunde, outAufgabeD);
		outAufgabeD.close();
		
		// alle Testpersonen und Kommilitonen
		outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/TvereinigtK.txt"), true);
		ArrayList<Person> kommilitonenAndTestpersonen = new ArrayList<Person>(kommilitonenPersonSet);
		ArrayList<Person> testPersonen = createTestPersonliste();
		kommilitonenAndTestpersonen.addAll(testPersonen);
		printPersons(kommilitonenAndTestpersonen, outAufgabeD);
		outAufgabeD.close();
		
		// Aufgabe 7a2
		out.println("Sortiere ArrayList der Sportfreunde (nach Geburtsjahr):");
		sportfreundePersonSet.sort(new YearComparator());
		printPersons(sportfreundePersonSet, out);
		
		out.println("Sortiere ArrayList der Kommilitonen (nach Geburtsjahr):");
		kommilitonenPersonSet.sort(new YearComparator());
		printPersons(kommilitonenPersonSet, out);
		
		out.println("Sortiere ArrayList der Sportfreunde und Kommilitonen (nach Geburtsjahr):");
		sportfreundeAndKommilitonen.sort(new YearComparator());
		printPersons(sportfreundeAndKommilitonen, out);
		
		out.println("Sortiere ArrayList der Kommilitonen aber nicht Sportfreunde (nach Geburtsjahr):");
		kommilitonenAndNotSportfreunde.sort(new YearComparator());
		printPersons(kommilitonenAndNotSportfreunde, out);
		
		out.println("Sortiere ArrayList der Kommilitonen und Testpersonen (nach Geburtsjahr):");
		kommilitonenAndTestpersonen.sort(new YearComparator());
		printPersons(kommilitonenAndTestpersonen, out);
		
		// Aufgabe 7a3
		out.println("Sortiere ArrayList der Sportfreunde (nach Name):");
		sportfreundePersonSet.sort(new NameComparator());
		printPersons(sportfreundePersonSet, out);
		
		out.println("Sortiere ArrayList der Kommilitonen (nach Name):");
		kommilitonenPersonSet.sort(new NameComparator());
		printPersons(kommilitonenPersonSet, out);
		
		out.println("Sortiere ArrayList der Sportfreunde und Kommilitonen (nach Name):");
		sportfreundeAndKommilitonen.sort(new NameComparator());
		printPersons(sportfreundeAndKommilitonen, out);
		
		out.println("Sortiere ArrayList der Kommilitonen aber nicht Sportfreunde (nach Name):");
		kommilitonenAndNotSportfreunde.sort(new NameComparator());
		printPersons(kommilitonenAndNotSportfreunde, out);
		
		out.println("Sortiere ArrayList der Kommilitonen und Testpersonen (nach Name):");
		kommilitonenAndTestpersonen.sort(new NameComparator());
		printPersons(kommilitonenAndTestpersonen, out);
		
		out.close();
				
	}
		
	public static void printPersons(ArrayList<Person> persons, PrintWriter out) {
		for (Person person : persons) {
			out.printf("%-25s%-25s%-25d\n",  person.getNachname(), person.getVorname(), person.getGeburtsjahr());
		}
		out.println();
		out.println();
	}

	public static void printPersons(HashSet<Person> persons, PrintWriter out) {
		for (Person person : persons) {
			out.printf("%-25s%-25s%-25d\n",  person.getNachname(), person.getVorname(), person.getGeburtsjahr());
		}
		out.println();
		out.println();
	}

	public static void printPersons(ArrayList<Person> persons, String filename) {
		PrintWriter out = new PrintWriter(new DirtyFileWriter(filename), true);
		printPersons(persons, out);
		out.close();
	}

	public static Person createPerson(Scanner dataSource) {
		String givenName = dataSource.next();
		String surName = dataSource.next();
		int yearOfBirth = dataSource.nextInt();
		return new Person(givenName, surName, yearOfBirth);
	}

	public static ArrayList<Person> getPersonsFrom(Scanner dataSource) {
		ArrayList<Person> personSet = new ArrayList<Person>();
		while (dataSource.hasNextLine()) {
			personSet.add(createPerson(dataSource));
		}
		return personSet;
	}

	public static ArrayList<Person> getPersonsFrom(String filename) {
		Scanner in = new Scanner(new DirtyFileReader(filename));
		ArrayList<Person> personSet = getPersonsFrom(in);
		in.close();
		return personSet;
	}
	
	public static ArrayList<Person> createTestPersonliste() {
		ArrayList<schimkat.berlin.lernhilfe2016ws.objectPlay.Person> personList = PersonFactory.createTestPersonliste();
		ArrayList<Person> personListStd = new ArrayList<Person>();
		for (schimkat.berlin.lernhilfe2016ws.objectPlay.Person personObjectPlay: personList) {
			personListStd.add(new Person(personObjectPlay));
		}
		return personListStd;
	}
	
	public static HashSet<Person> createTestPersonSet() {
		HashSet<schimkat.berlin.lernhilfe2016ws.objectPlay.Person> personSet = PersonFactory.createTestPersonSet();
		HashSet<Person> personSetStd = new HashSet<Person>();
		for (schimkat.berlin.lernhilfe2016ws.objectPlay.Person personObjectPlay: personSet) {
			personSetStd.add(new Person(personObjectPlay));
		}
		return personSetStd;
	}
}
