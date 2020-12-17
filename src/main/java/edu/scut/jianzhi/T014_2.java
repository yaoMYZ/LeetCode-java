package edu.scut.jianzhi;

public class T014_2 {
	public int cuttingRope(int n) {
		int result = 1;
		int rInter = 1;
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
				mul=(mul*cal)%1000000007;	
			}
			if(mul>result)
				rInter=inter;
			result = Math.max(result, mul);
		}
		System.out.println(rInter);
		return result;
    }
	
	public static void main(String[] args) {
		T014_2 t014_1 = new T014_2();
		int r = t014_1.cuttingRope(120);
		System.out.println(r);
	}
}
