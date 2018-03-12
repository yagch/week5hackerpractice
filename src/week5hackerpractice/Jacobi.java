package week5hackerpractice;

public class Jacobi {
	public static void main(String[] arg) {
		double[][] D = {{-0.25,0,0,0,0},{0,-0.25,0,0,0},{0,0,-0.25,0,0},{0,0,0,-0.25,0},{0,0,0,0,-0.25}};
		double[][] A = {{-4,1,0,0,1},{4,-4,1,0,0},{0,1,-4,1,0},{0,0,1,-4,1},{1,0,0,1,-4}};
		double[] b = {1,0,0,0,0};
		FullMatrix matD = new FullMatrix(D);
		FullMatrix matA = new FullMatrix(A);
		double[] xk = matD.productAx(b);
		double[] deltax = new double[5];
		double[] deltab = new double[5];
		
		deltax[0] = 1;
		while(norm(deltax) >= Math.pow(10, -7)) {
			for(int i = 0; i < 5; i++) {
				double xi = b[i];
				for(int j = 0; j < 5; j++) {
					if(j != i) {
						xi -= A[i][j] * xk[j];
					}
				}
				xi /= A[i][i];
				deltax[i] = xi - xk[i];
				xk[i] = xi;
			}
			//track the iteration
			for(int i = 1; i < 5; i++) {
				double[] prodAx = matA.productAx(xk);
				deltab[i] = b[i] - prodAx[i];
			}
			System.out.println("The error is: " + norm(deltab));
		}
		System.out.println("The result is");
		for(int i = 0; i < 5; i++) {
			System.out.println(xk[i]);
		}
	}
	
	// calculate secon norm
	public static double norm(double[] x) {
		double res = 0;
		for (int i = 0; i < x.length; i++) {
			res += x[i] * x[i];
		}
		return Math.sqrt(res);
	}
}
