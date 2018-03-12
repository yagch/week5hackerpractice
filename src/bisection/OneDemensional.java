package bisection;

public class OneDemensional {
	public static void main(String[] arg) {
		System.out.println("The solution is " + bisection(-5, 10));
	}
	public static double f(double x) {
		return Math.exp(x) - 1;
	}
	public static double bisection(double a, double b) {
		if(Math.abs(b - a) < Math.pow(10, -3)) {
			return (a + b) / 2;
		}
		double c = (a + b) / 2;
		if(f(c) > 0) {
			return bisection(Math.min(a, b), c);
		}
		else if(f(c) < 0) {
			return bisection(c, Math.max(a, b));
		}
		else {
			return c;
		}
	}
}
