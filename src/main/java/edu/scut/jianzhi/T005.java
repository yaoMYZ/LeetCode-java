package edu.scut.jianzhi;

public class T005 {
	public String replaceSpace(String s) {
		String result = "";
		for (Character c : s.toCharArray()) {
			if(c==' ') {
				result+="%20";
			}else {
				result+=c;
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		T005 t005 = new T005();
		String s = t005.replaceSpace("We are happy.");
		System.out.println(s);
	}
}
