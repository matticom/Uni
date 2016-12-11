package pr1.a07;

import java.util.Comparator;

import pr1.a06.Person;

public class YearComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		return person1.getGeburtsjahr()-person2.getGeburtsjahr();
	}
}
