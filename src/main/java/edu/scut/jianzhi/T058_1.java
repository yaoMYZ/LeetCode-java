package edu.scut.jianzhi;

public class T058_1 {
	public String reverseWords(String s) {
		String[] arr = s.split(" ");
		int len = arr.length;
		if(len==0)
			return "";
		int idxf = len-1;
		while(arr[idxf].equals("")&&idxf>0)
			idxf--;
		if(idxf<0)
			return "";
		String result = arr[idxf];
		for (int i = idxf-1; i >=0; i--) {
			if(arr[i].equals(""))
				continue;
			result+=" "+arr[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("is "+ 100 + 5);
		T058_1 t058_1 = new T058_1();
		String s = " ";
		String r = t058_1.reverseWords(s);
		System.out.println(r);
	}
	
}
