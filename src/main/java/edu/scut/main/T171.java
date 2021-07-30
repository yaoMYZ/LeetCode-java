package edu.scut.main;

public class T171 {
	public int titleToNumber(String columnTitle) {
		int res = 0;
		for (char c : columnTitle.toCharArray()) {
			int tmp = c-'A'+1;
			res = res*26+tmp;
		}
		return res;
    }
	
	public static void main(String[] args) {
		T171 t171 = new T171();
		System.out.println(t171.titleToNumber("FXSHRXW"));
	}
}
