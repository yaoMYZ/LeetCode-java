package edu.scut.main;



public class T394 {
	public String decodeString(String s) {
		String result = "";
		String digit = "";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='[') {
				Result tmp = getRepeatString(i+1, s);
				int rt = Integer.valueOf(digit);
				for(int j=0;j<rt;j++) {
					result +=tmp.p1;
				}
				i = tmp.p2;
				digit="";
			}else if (Character.isDigit(s.charAt(i))) {
				digit+=s.charAt(i);
			}else {
				result+=s.charAt(i);
			}
		}
		return result;
    }
	
	private Result getRepeatString(int idx,String s) {
		Result result = new Result("",idx);
		String digit = "";
		for(int i=idx;i<s.length();i++) {
			result.p2 = i;
			if(s.charAt(i)=='[') {
				Result tmp = getRepeatString(i+1, s);
				int rt = Integer.valueOf(digit);
				for(int j=0;j<rt;j++) {
					result.p1+=tmp.p1;
				}
				i = tmp.p2;
				digit = "";
			}else if (s.charAt(i)==']') {
				break;
			}else if (Character.isDigit(s.charAt(i))) {
				digit+=s.charAt(i);
			}else {
				result.p1+=s.charAt(i);
			}
		}
		
		return result;
	}
}


class Result{
	public String p1;
	public int p2;
	
	public Result(String p1,int p2) {
		this.p1=p1;
		this.p2=p2;
	}
}