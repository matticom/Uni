package pr1.a02;

import java.io.PrintWriter;

public class Schachbrett
{

	public static void main(String[] args)
	{
		// Aufgabe 2a.a
		printSchachbrett();
		System.out.println();

		// Aufgabe 2a.b
		printSchachbrettReverse();
		System.out.println();

		PrintWriter out = new PrintWriter(System.out, true);
		
		// Aufgabe 2a.c
		printSchachbrett(out);
		System.out.println();

		// Aufgabe 2a.d
		printSchachbrettReverse(out);
		System.out.println();
		out.flush();
	}

	public static void printSchachbrett()
	{

		for (int number = 8; number >= 1; number--)
		{

			for (char letter = 'A'; letter <= 'H'; letter++)
			{
				System.out.print(letter + "" + number + "  ");
			}

			System.out.println();
		}
	}

	public static void printSchachbrettReverse()
	{

		for (int number = 1; number <= 8; number++)
		{

			for (char letter = 'H'; letter >= 'A'; letter--)
			{
				System.out.print(letter + "" + number + "  ");
			}

			System.out.println();
		}
	}

	public static void printSchachbrett(PrintWriter out)
	{

		for (int number = 8; number >= 1; number--)
		{

			for (char letter = 'A'; letter <= 'H'; letter++)
			{
				out.print(letter + "" + number + "  ");
			}

			out.println();
		}
	}

	public static void printSchachbrettReverse(PrintWriter out)
	{

		for (int number = 1; number <= 8; number++)
		{

			for (char letter = 'H'; letter >= 'A'; letter--)
			{
				out.print(letter + "" + number + "  ");
			}

			out.println();
		}
	}

}
