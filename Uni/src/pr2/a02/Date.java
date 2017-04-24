package pr2.a02;

public class Date {

	private int tag;
	private int monat;
	private int jahr;
	private final int[] TAGE_IM_MONAT = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int tag, int monat, int jahr) throws IllegalDateException {
		checkDate(tag, monat, jahr);
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;
	}
	
	private void checkDate(int tag, int monat, int jahr) throws IllegalDateException {
		String ungueltigesDatum = String.format("falsches Datum: %02d.%02d.%04d: ", tag, monat, jahr);
		boolean ungueltigJahr = jahr < 0 || jahr > 3000;
		boolean ungueltigMonat = monat < 1 || monat > 12;
		boolean ungueltigTag = true;
		if (!ungueltigMonat) {
			ungueltigTag = tag < 1 || tag > TAGE_IM_MONAT[monat];
		} else {
			ungueltigTag = tag < 1 || tag > 28;
		}
			
		if ((ungueltigJahr && ungueltigMonat) || (ungueltigJahr && ungueltigTag) || (ungueltigMonat && ungueltigTag)) {
			throw new IllegalDateException(ungueltigesDatum + "more than one part of the date is invalid");
		}
		if (ungueltigJahr) {
			throw new IllegalDateException(ungueltigesDatum + "year is out of scope [0..3000]");
		}
		if (ungueltigMonat) {
			throw new IllegalDateException(ungueltigesDatum + "illegal month");
		}
		if (tag < 1 || tag > TAGE_IM_MONAT[monat]) {
			throw new IllegalDateException(ungueltigesDatum + "illegal day (> " + TAGE_IM_MONAT[monat] + ")");
		}
	}

	public int getTag() {
		return tag;
	}

	public int getMonat() {
		return monat;
	}

	public int getJahr() {
		return jahr;
	}

	@Override
	public String toString() {
		return String.format("%02d.%02d.%04d", tag, monat, jahr);
	}
}
