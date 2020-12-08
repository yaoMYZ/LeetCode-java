package edu.scut.jianzhi;

public class T010_1 {
	public int fib(int n) {
		int sum = 0;
		int a = 0;
		int b = 1;
		for (int i=0; i<n ; i++) {
			sum = (a+b)% 1000000007;
			a = b;
			b = sum;
		}
		return a;
    }
}
