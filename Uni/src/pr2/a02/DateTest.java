package pr2.a02;

import java.io.PrintWriter;

public class DateTest {

	public static void main(String[] args) {

		int[][] testdata = {
			{1, 5, 2013},	
			{82, 38, 2013},
			{5, 5, 3600},
			{29, 2, 2016},
			{28, 2, 2017}
		};
		PrintWriter out = new PrintWriter(System.out, true);
		for (int i = 0; i < testdata.length; i++) {
			Date date;
			try {
				date = new Date(testdata[i][0], testdata[i][1], testdata[i][2]);
				out.printf("korrektes Datum: %s %n", date.toString());
			} catch (IllegalDateException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
