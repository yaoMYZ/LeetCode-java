package edu.scut.yao;

import java.util.Arrays;

public class T204 {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		T204 t204 = new T204();
		System.out.println(t204.countPrimes(0));
	}
}
