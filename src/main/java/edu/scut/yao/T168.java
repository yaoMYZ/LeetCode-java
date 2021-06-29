package edu.scut.yao;

public class T168 {
	public String convertToTitle(int columnNumber) {
		StringBuilder res = new StringBuilder();
		while(columnNumber>0) {
			columnNumber-=1;
			int last = columnNumber%26;
			res.append((char)('A'+last));
			columnNumber/=26;
		}
		return res.reverse().toString();
    }
	
	public static void main(String[] args) {
		T168 t168 = new T168();
		System.out.println(t168.convertToTitle(2147483647));
	}
}
