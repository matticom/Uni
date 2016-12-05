package extra_2f;

public class HelloNumbers
{

	public static void main(String[] args)
	{
		
		try {
			int[] ar = new int[1];
			ar[10] = 10;
		} catch (Exception e) {
			System.out.println("War in catch");
		}
		someExpressions();

	}
	
	public static void someExpressions() {
		System.out.println(Math.pow(7, 5));
		System.out.println(Math.pow(7, 5+3));
		System.out.println(Math.pow(7, 5+Math.pow(9, 4)));
		
		System.out.println(Math.exp(5)+Math.sin(5)+Math.sqrt(5));
	}

}
