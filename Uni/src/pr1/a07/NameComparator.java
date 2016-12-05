package pr1.a07;

import java.util.Comparator;

import pr1.a06.Person;

public class NameComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		String vornamePerson1 = person1.getVorname();
		String vornamePerson2 = person2.getVorname();
		String nachnamePerson1 = person1.getNachname();
		String nachnamePerson2 = person2.getNachname();
		int result = nachnamePerson1.compareTo(nachnamePerson2);
		if (result == 0) {
			result = vornamePerson1.compareTo(vornamePerson2);
		}
		return result;
	}

}
