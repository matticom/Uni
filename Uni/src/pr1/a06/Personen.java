package pr1.a06;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory;

public class Personen {

	public static void main(String[] args) {
		aufgabeB();
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
		printPersons(personSet, "./listen/PersonSetAufgabe5b3.txt");
		out.close();
	}

	public static void aufgabeC(PrintWriter out) {

		Scanner onePerson = new Scanner(new DirtyFileReader("./listen/sportfreunde.txt"));
		Scanner personSet = new Scanner(new DirtyFileReader("./listen/sportfreunde.txt"));

		// Aufgabe 5.c
		HashSet<Person> onePersonSet = new HashSet<Person>();
		onePersonSet.add(createPerson(onePerson));
		out.println("Personenset mit einer Person:");
		printPersons(onePersonSet, out);
		onePerson.close();

		HashSet<Person> sportfreundePersonSet = getPersonsFrom(personSet);
		out.println("Personenset mit Scanner:");
		printPersons(sportfreundePersonSet, out);
		personSet.close();

		out.println("Personenset mit filename:");
		printPersons(getPersonsFrom("./listen/sportfreunde.txt"), out);

		// Aufgabe d
		HashSet<Person> kommilitonenPersonSet = getPersonsFrom("./listen/kommilitonen.txt");

		// aller Sportfreunde, die auch Kommilitonen sind
		PrintWriter outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/SundK.txt"), true);
		HashSet<Person> sportfreundeAndKommilitonen = new HashSet<Person>(kommilitonenPersonSet);
		sportfreundeAndKommilitonen.retainAll(sportfreundePersonSet);
		printPersons(sportfreundeAndKommilitonen, outAufgabeD);
		outAufgabeD.close();

		// aller Kommilitonen, die nicht Sportfreunde sind
		outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/KaberNichtS.txt"), true);
		HashSet<Person> kommilitonenAndNotSportfreunde = new HashSet<Person>(kommilitonenPersonSet);
		kommilitonenAndNotSportfreunde.removeAll(sportfreundePersonSet);
		printPersons(kommilitonenAndNotSportfreunde, outAufgabeD);
		outAufgabeD.close();
		
		// alle Testpersonen und Kommilitonen
		outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/TvereinigtK.txt"), true);
		HashSet<Person> kommilitonenAndTestpersonen = new HashSet<Person>(kommilitonenPersonSet);
		HashSet<Person> testPersonen = createTestPersonSet();
		kommilitonenAndTestpersonen.addAll(testPersonen);
		printPersons(kommilitonenAndTestpersonen, outAufgabeD);
		outAufgabeD.close();
	}

	public static void printPersons(ArrayList<Person> persons, PrintWriter out) {
		for (Person person : persons) {
			String personStr = person.getVorname();
			for (int i = person.getVorname().length(); i < 25; i++) {
				personStr += " ";
			}
			personStr += person.getNachname();
			for (int i = person.getNachname().length(); i < 25; i++) {
				personStr += " ";
			}
			personStr += person.getGeburtsjahr();
			out.println(personStr);
		}
		out.println();
		out.println();
	}

	public static void printPersons(HashSet<Person> persons, PrintWriter out) {
		for (Person person : persons) {
			String personStr = person.getVorname();
			for (int i = person.getVorname().length(); i < 25; i++) {
				personStr += " ";
			}
			personStr += person.getNachname();
			for (int i = person.getNachname().length(); i < 25; i++) {
				personStr += " ";
			}
			personStr += person.getGeburtsjahr();
			out.println(personStr);
		}
		out.println();
		out.println();
	}

	public static void printPersons(HashSet<Person> persons, String filename) {
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

	public static HashSet<Person> getPersonsFrom(Scanner dataSource) {
		HashSet<Person> personSet = new HashSet<Person>();
		while (dataSource.hasNextLine()) {
			personSet.add(createPerson(dataSource));
		}
		return personSet;
	}

	public static HashSet<Person> getPersonsFrom(String filename) {
		Scanner in = new Scanner(new DirtyFileReader(filename));
		HashSet<Person> personSet = getPersonsFrom(in);
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
