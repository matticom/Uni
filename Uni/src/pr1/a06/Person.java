package pr1.a06;

public class Person {

	String vorname;
	String nachname;
	int geburtsjahr;
	
	public Person(String Vorname, String Nachname, int Geburtsjahr) {
		this.vorname = Vorname;
		this.nachname = Nachname;
		this.geburtsjahr = Geburtsjahr;
	}
	
	public Person(Person person) {
		this(person.vorname, person.nachname, person.geburtsjahr);
	}
	
	public Person(schimkat.berlin.lernhilfe2016ws.objectPlay.Person person) {
		this(person.getVorname(), person.getNachname(), person.getGeburtsjahr());
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	@Override
	public String toString() {
		String personStr = vorname;
		for (int i = vorname.length(); i < 25; i++) {
			personStr += " ";
		}
		personStr += nachname;
		for (int i = nachname.length(); i < 25; i++) {
			personStr += " ";
		}
		return personStr += geburtsjahr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + geburtsjahr;
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (geburtsjahr != other.geburtsjahr)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
}
