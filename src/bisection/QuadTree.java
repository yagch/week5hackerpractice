package bisection;

public class QuadTree {
	static double xs; 
	static double ys;
	public static double f1(double x, double y) {
		return Math.exp(x) - Math.exp(y);
	}
	public static double f2(double x, double y) {
		return Math.exp(x) + Math.exp(y) - 2;
	}
	public static void bisection(double a, double b, double c, double d) {
		if(Math.abs(b - a) < Math.pow(10, -3) && Math.abs(d - c) < Math.pow(10, -3)) {
			xs = (a + b) / 2;
			ys = (c + d) / 2;
			return;
		}
		double x1 = (a + b) / 2;
		double y1 = (c + d) / 2;
		if(f1(x1, y1) == 0 && f2(x1, y1) == 0) {
			xs = x1;
			ys = y1;
			return;
		}
		else if(f1(x1, y1) >= 0 && f2(x1, y1) >= 0) {
			bisection(Math.min(a, b), x1, c, d);
		}
		else if(f1(x1, y1) >= 0 && f2(x1, y1) <= 0) {
			bisection(a, b, y1, Math.max(c, d));
		}
		else if(f1(x1, y1) <= 0 && f2(x1, y1) >= 0) {
			bisection(a, b, Math.min(c, d), y1);
		}
		else {
			bisection(x1, Math.max(a, b), c, d);
		}
	}
	public static void main(String[] arg) {
		bisection(-5, 10, -5, 10);
		System.out.println("x = " + xs);
		System.out.println("y = " + ys);
	}
}
