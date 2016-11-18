package pr1.a02;

public class SomeFunctions
{
	public static void main(String[] args){
		// Kreisumfang
		double a = 3.6;
		double b = 7.1;
		double c = 6.6;
		System.out.printf("Kreisumfang von Radius %3.1f:%7.2f%n",a,kreisUmfang(a));
		System.out.printf("Kreisumfang von Radius %3.1f:%7.2f%n%n",b,kreisUmfang(b));
		
		// Rechteckumfang
		System.out.printf("Rechteckumfang von %3.1f und %3.1f:%7.2f%n", a, b, rechteckUmfang(a, b));
		System.out.printf("Rechteckumfang von %3.1f und %3.1f:%7.2f%n%n", c, b, rechteckUmfang(c, b));
		
		// Rechteckfläche
		System.out.printf("Rechteckfläche von %3.1f und %3.1f:%7.2f%n", a, b, rechteckFlaeche(a, b));
		System.out.printf("Rechteckfläche von %3.1f und %3.1f:%7.2f%n", c, b, rechteckFlaeche(c, b));
	}
	
	public static double kreisUmfang(double radius){
		return 2*Math.PI*radius;
	}
	
	public static double rechteckUmfang(double a, double b){
		return 2*(a+b);
	}
	
	public static double rechteckFlaeche(double a, double b){
		return a*b;
	}
	
}
