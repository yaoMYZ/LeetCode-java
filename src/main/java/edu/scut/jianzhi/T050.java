package edu.scut.jianzhi;

public class T050 {
	public double myPow(double x, int n) {
		long N = n;
		if(N<0)
			return 1.0/subPow(x, Math.abs(N));
		else {
			return subPow(x, N);
		}
	}
	
	private double subPow(double x, long n) {
		if(n==0)
			return 1;
		double subPow = subPow(x, n/2);
		double result = subPow*subPow;
		return n%2==1?result*x:result;
	}
	
	public static void main(String[] args) {
		T050 t050 = new T050();
		System.out.println(t050.myPow(2.0, 10));
	}
}
