package edu.scut.jianzhi;

public class T016 {
	public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		T016 t016 = new T016();
		double r = t016.myPow(2,9);
		System.out.println(r);
	}
}
