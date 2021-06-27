package edu.scut.jianzhi;

public class T015 {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int res = 0;
        while (n!=0) {
			n = n&(n-1);
			res++;
		}
        return res;
    }
    
    public static void main(String[] args) {
		T015 t015 = new T015();
		System.out.println(t015.hammingWeight(2));
	}
}
