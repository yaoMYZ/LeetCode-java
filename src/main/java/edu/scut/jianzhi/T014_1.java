package edu.scut.jianzhi;

public class T014_1 {
	public int cuttingRope(int n) {
		int result = 1;
		for (int i = 2; i <= (n/2+1); i++) {
			int inter = n/i;
			int last = n%i;
			int mul = 1;
			for (int j = 0; j < i; j++) {
				int cal = inter;
				if(last>0) {
					cal++;
					last--;
				}
				mul*=cal;
			}
			result = Math.max(result, mul);
		}
		return result;
    }
	
	public static void main(String[] args) {
		T014_1 t014_1 = new T014_1();
		int r = t014_1.cuttingRope(3);
		System.out.println(r);
	}
}
