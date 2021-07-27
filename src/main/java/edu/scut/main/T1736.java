package edu.scut.main;


public class T1736 {
	public String maximumTime(String time) {
		char[] res = time.toCharArray();
		if(res[0]=='?') {
			if(res[1]=='?'||res[1]<='3')
				res[0] = '2';
			else {
				res[0] = '1';
			}
		}
		
		if(res[1]=='?') {
			if(res[0]=='2') {
				res[1] = '3';
			}
			else {
				res[1] = '9';
			}
		}
		
		if(res[3]=='?') {
			res[3] = '5';
		}
		
		if(res[4]=='?') {
			res[4] = '9';
		}
		
		return new String(res);
    }
}
