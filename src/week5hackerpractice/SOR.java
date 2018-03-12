package week5hackerpractice;

public class SOR {
	public static void main(String[] arg) {
		double[][] D = {{-0.25,0,0,0,0},{0,-0.25,0,0,0},{0,0,-0.25,0,0},{0,0,0,-0.25,0},{0,0,0,0,-0.25}};
		double[][] A = {{-4,1,0,0,1},{4,-4,1,0,0},{0,1,-4,1,0},{0,0,1,-4,1},{1,0,0,1,-4}};
		double[] b = {1,0,0,0,0};
		FullMatrix matD = new FullMatrix(D);
		FullMatrix matA = new FullMatrix(A);
		double[] xk = matD.productAx(b);
		double[] xk1 = new double[5];
		double[] deltax = new double[5];
		double[] rk = new double[5];
        double omega = 0.5;
		deltax[0] = 1;
		int k = 0;
		while(norm(deltax) >= Math.pow(10, -7)) {
			for(int i = 0; i < 5; i++) {
				double xi = b[i];
				for(int j = 0; j < i; j++) {
					xi -= A[i][j] * xk1[j];
				}
				for(int j = i+1; j < 5; j++) {
					xi -= A[i][j] * xk[j];
				}
				xi *= omega / A[i][i];
				xi += (1 - omega) * xk[i];
				xk1[i] = xi;
				deltax[i] = xk1[i] - xk[i];
			}
			for(int i = 1; i < 5; i++) {
				double[] prodAx = matA.productAx(xk);
				rk[i] = b[i] - prodAx[i];
			}
			System.out.println("Iteration " + k + ": " );
			System.out.println("x1" + k + " is: " + xk[0]);
			System.out.println("x1" + (k + 1) + " is: " + xk1[0]);
			System.out.println("norm of deltax" + k + " is: " + norm(deltax));
			System.out.println("norm of r" + k + " is: " + norm(rk));
			for(int i = 0; i < 5; i++) {
				xk[i] = xk1[i];
			}
			k++;
		}
		System.out.println("The result is");
		for(int i = 0; i < 5; i++) {
			System.out.println(xk[i]);
		}
	}
	// calculate second norm
	public static double norm(double[] x) {
		double res = 0;
		for (int i = 0; i < x.length; i++) {
			res += x[i] * x[i];
		}
		return Math.sqrt(res);
	}
}
