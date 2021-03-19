package edu.scut.mianshi;

public class T0105 {
	public boolean oneEditAway(String first, String second) {
		int len1 = first.length();
		int len2 = second.length();
		if(Math.abs(len1-len2)>=2)
			return false;
		else if (Math.abs(len1-len2)==1) {
			if(len1<len2) {
				String tmp = first;
				first = second;
				second = tmp;
			}
			return judeNotEqual(first, second);
		}else {
			return judeEqual(first, second);
		}
    }
	
	public boolean judeNotEqual(String first, String second) {
		int modify = 0;
		for (int i = 0, j = 0; j < second.length(); i++, j++) {
			if(first.charAt(i)!=second.charAt(j)) {
				modify++;
				j--;
			}
			if (modify>1)
				return false;
		}
		return true;
	}
	
	public boolean judeEqual(String first, String second) {
		int modify = 0;
		for (int i = 0; i < first.length(); i++) {
			if(first.charAt(i)!=second.charAt(i)) {
				modify++;
			}
			if (modify>1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		T0105 t0105 = new T0105();
		String first = "a";
		String second = "";
		System.out.println(t0105.oneEditAway(first, second));
	}
}
