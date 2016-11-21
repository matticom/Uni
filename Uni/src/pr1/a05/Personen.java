package pr1.a05;

import java.io.PrintWriter;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;

public class Personen {

	public static void main(String[] args) {
		aufgabeB();
		PrintWriter out = new PrintWriter(System.out, true);
		aufgabeC(out);
		out.close();
	}

	public static void aufgabeB() {
		PrintWriter out = new PrintWriter(System.out, true);
		PersonList personList = PersonFactory.createTestPersonliste();
		PersonSet personSet = PersonFactory.createTestPersonSet();

		// Aufgabe 5.b.1-3
		printPersons(personList, out);
		printPersons(personSet, out);
		printPersons(personSet, "./listen/PersonSetAufgabe5b3.txt");
	}

	public static void aufgabeC(PrintWriter out) {

		Scanner onePerson = new Scanner(new DirtyFileReader("./listen/sportfreunde.txt"));
		Scanner personSet = new Scanner(new DirtyFileReader("./listen/sportfreunde.txt"));

		// Aufgabe 5.c
		PersonSet onePersonSet = new PersonSet();
		onePersonSet.add(createPerson(onePerson));
		out.println("Personenset mit einer Person:");
		printPersons(onePersonSet, out);
		onePerson.close();

		PersonSet sportfreundePersonSet = getPersonsFrom(personSet);
		out.println("Personenset mit Scanner:");
		printPersons(sportfreundePersonSet, out);
		personSet.close();

		out.println("Personenset mit filename:");
		printPersons(getPersonsFrom("./listen/sportfreunde.txt"), out);

		// Aufgabe d
		PersonSet kommilitonenPersonSet = getPersonsFrom("./listen/kommilitonen.txt");

		// aller Sportfreunde, die auch Kommilitonen sind
		PrintWriter outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/SundK.txt"), true);
		PersonSet sportfreundeAndKommilitonen = new PersonSet(kommilitonenPersonSet);
		sportfreundeAndKommilitonen.retainAll(sportfreundePersonSet);
		printPersons(sportfreundeAndKommilitonen, outAufgabeD);
		outAufgabeD.close();

		// aller Kommilitonen, die nicht Sportfreunde sind
		outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/KaberNichtS.txt"), true);
		PersonSet kommilitonenAndNotSportfreunde = new PersonSet(kommilitonenPersonSet);
		kommilitonenAndNotSportfreunde.removeAll(sportfreundePersonSet);
		printPersons(kommilitonenAndNotSportfreunde, outAufgabeD);
		outAufgabeD.close();
		
		// alle Testpersonen und Kommilitonen
		outAufgabeD = new PrintWriter(new DirtyFileWriter("./listen/TvereinigtK.txt"), true);
		PersonSet kommilitonenAndTestpersonen = new PersonSet(kommilitonenPersonSet);
		PersonSet testPersonen = PersonFactory.createTestPersonSet();
		kommilitonenAndTestpersonen.addAll(testPersonen);
		printPersons(kommilitonenAndTestpersonen, outAufgabeD);
		outAufgabeD.close();
	}

	public static void printPersons(PersonList persons, PrintWriter out) {
		for (Person person : persons) {
			out.println(person.getVorname());
			out.println(person.getNachname());
			out.println(person.getGeburtsjahr());
			out.println();
		}
		out.println();
		out.println();
	}

	public static void printPersons(PersonSet persons, PrintWriter out) {
		for (Person person : persons) {
			out.println(person.getVorname());
			out.println(person.getNachname());
			out.println(person.getGeburtsjahr());
			out.println();
		}
		out.println();
		out.println();
	}

	public static void printPersons(PersonSet persons, String filename) {
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

	public static PersonSet getPersonsFrom(Scanner dataSource) {
		PersonSet personSet = new PersonSet();
		while (dataSource.hasNextLine()) {
			personSet.add(createPerson(dataSource));
		}
		return personSet;
	}

	public static PersonSet getPersonsFrom(String filename) {
		Scanner in = new Scanner(new DirtyFileReader(filename));
		PersonSet personSet = getPersonsFrom(in);
		in.close();
		return personSet;
	}
}
