package pr1.a06;

public class Person {

	String Vorname;
	String Nachname;
	int Geburtsjahr;
	
	public Person(String Vorname, String Nachname, int Geburtsjahr) {
		this.Vorname = Vorname;
		this.Nachname = Nachname;
		this.Geburtsjahr = Geburtsjahr;
	}
	
	public Person(Person person) {
		this(person.Vorname, person.Nachname, person.Geburtsjahr);
	}
	
	public Person(schimkat.berlin.lernhilfe2016ws.objectPlay.Person person) {
		this(person.getVorname(), person.getNachname(), person.getGeburtsjahr());
	}

	public String getVorname() {
		return Vorname;
	}

	public String getNachname() {
		return Nachname;
	}

	public int getGeburtsjahr() {
		return Geburtsjahr;
	}

	@Override
	public String toString() {
		return "Vorname: " + Vorname + " / Nachname: " + Nachname + " / Geburtsjahr: " + Geburtsjahr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Vorname == null) ? 0 : Vorname.hashCode());
		result = prime * result + ((Nachname == null) ? 0 : Nachname.hashCode());
		result = prime * result + Geburtsjahr;
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
		if (Vorname == null) {
			if (other.Vorname != null)
				return false;
		} else if (!Vorname.equals(other.Vorname))
			return false;
		if (Nachname == null) {
			if (other.Nachname != null)
				return false;
		} else if (!Nachname.equals(other.Nachname))
			return false;
		if (Geburtsjahr != other.Geburtsjahr)
			return false;
		return true;
	}
}
