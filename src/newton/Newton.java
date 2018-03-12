package newton;

public class Newton {
	public static void main(String[] arg) {
		// set the initial guess to 1
		double x = 1;
		double deltax = -1 * f(x) / fd(x);   // deltax
		int iter = 0;    // Number of iteration
		System.out.println("while x0 = 1");
		while(Math.abs(deltax) >= Math.pow(10, -7) && Math.abs(f(x)) >= Math.pow(10, -7)) {
			System.out.println("x" + iter + " = " + x);
			System.out.println("deltax" + iter + " = " + deltax);
			System.out.println("f(x" + iter + ") = " + f(x));
			x += deltax;
			deltax = -1 * f(x) / fd(x);
			iter++;
		}
		// set the initial guess to 10
		x = 10;
		deltax = -1 * f(x) / fd(x);
		iter = 0;
		System.out.println("");
		System.out.println("while x0 = 10");
		while(Math.abs(deltax) >= Math.pow(10, -9) && Math.abs(f(x)) >= Math.pow(10, -9)) {
			System.out.println("x" + iter + " = " + x);
			System.out.println("deltax" + iter + " = " + deltax);
			System.out.println("f(x" + iter + ") = " + f(x));
			x += deltax;
			deltax = -1 * f(x) / fd(x);
			iter++;
			//When x0 = 10, f(x0) and fd(x0) overflow, and deltax0 is NaN
		}
	}
	
	// f(x)
	public static double f(double x) {
		return Math.exp(100 * x) - 1;
	}
	// derivative of f(x)
	public static double fd(double x) {
		return 100 * Math.exp(100 * x);
	}
	/
}
