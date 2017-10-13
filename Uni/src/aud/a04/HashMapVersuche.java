package aud.a04;

import java.time.Instant;
import java.util.HashMap;

import aud.a03.QueueOverflow;
import aud.a03.QueueUnderflow;
import aud.a05.Edge;
import aud.a05.Graph;
import aud.a05.GraphLesen;
import aud.a05.MyVertex;

public class HashMapVersuche {

	protected HashMap<String, String> hm1;
	protected HashMap<String, String> hm2;

	public HashMapVersuche() {
		hm1 = new HashMap<String, String>(8);
		hm2 = new HashMap<String, String>(100);
		addValues();
		measureIterationThroughHashMaps();
	}

	protected void addValues() {
		hm1.put("Wert1", "1");
		hm1.put("Wert2", "2");
		hm1.put("Wert3", "3");
		hm1.put("Wert4", "4");
		hm1.put("Wert5", "5");
		hm2.put("Wert1", "1");
		hm2.put("Wert2", "2");
		hm2.put("Wert3", "3");
		hm2.put("Wert4", "4");
		hm2.put("Wert5", "5");
	}

	protected void measureIterationThroughHashMaps() {
		Long duration = 0l;
		Long start;
		Long end;

		for (int i = 1; i < 100; i++) {
			start = System.nanoTime();

			for (String value : hm1.values()) {
				hm1.containsValue(value);
			}
			end = System.nanoTime();
			duration += (end - start);
		}
		System.out.println("Kleine HashMap: " + (duration / 100));

		duration = 0l;
		for (int i = 1; i < 100; i++) {
			start = System.nanoTime();

			for (String value : hm2.values()) {
				hm2.containsValue(value);
			}
			end = System.nanoTime();
			duration += (end - start);
		}

		System.out.println("Große HashMap: " + (duration / 100));
	}

	public static void main(String[] args) throws QueueOverflow, QueueUnderflow {
		HashMapVersuche versuch = new HashMapVersuche();
	}
}
