package edu.scut.jianzhi;

public class T067 {
	public int strToInt(String str) {
		int i = 0;
		
		while(i<str.length()&&str.charAt(i)==' ')
			i++;
		if(i==str.length())
			return 0;
		char sChar = str.charAt(i);
		if(sChar!='+'&&sChar!='-'&&!Character.isDigit(sChar))
			return 0;
		if(sChar=='-') {
			return toInt(i+1, str, -1);
		}else if (sChar=='+')  {
			return toInt(i+1, str, 1);
		}
		else {
			return toInt(i, str, 1);
		}
    }
	
	
	private int toInt(int sidx,String str,int flag) {
		long result = 0;
		for (int j = sidx; j < str.length(); j++) {
			char tmp = str.charAt(j);
			if(Character.isDigit(tmp)) {
				result = result*10+(int)tmp - (int)('0');;
				if(flag*result>2147483647)
					return 2147483647;
				if(flag*result<-2147483648)
					return -2147483648;
			}else {
				break;
			}
		}
		return (int) (flag*result);
	}
	
	public static void main(String[] args) {
		T067 t067 = new T067();
		String str = "   +0 123";
		int r = t067.strToInt(str);
		System.out.println(r);
	}
}
