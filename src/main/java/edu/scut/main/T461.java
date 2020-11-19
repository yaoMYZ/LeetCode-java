package edu.scut.main;

public class T461 {
	public int hammingDistance(int x, int y) {
		int dis = 0;
		while (x!=0 || y!=0) {
			int x1 = x%2;
			int y1 = y%2;
			dis+=x1^y1;
			x=x>>1;
			y=y>>1;
		}
		return dis;
    }
	
	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		T461 t461 = new T461();
		System.out.println(t461.hammingDistance(x, y));
	}
}
