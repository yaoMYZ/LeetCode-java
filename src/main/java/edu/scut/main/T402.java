package edu.scut.main;

import java.util.ArrayList;
import java.util.List;

public class T402 {
	private List<String> res = new ArrayList<>();
	
	public List<String> readBinaryWatch(int turnedOn) {
		read(0, 0, 0, turnedOn);
		return res;
    }
	
	private void read(int pos,int mask, int count, int turnedOn) {
		if(count==turnedOn) {
			String str = int2String(mask);
			if(str!=null)
				res.add(str);
			return;
		}
		if(pos>10)
			return;
		read(pos+1, mask, count, turnedOn);
		int nmask = mask|(1<<pos);
		read(pos+1, nmask, count+1, turnedOn);
	}
	
	private String int2String(int mask) {
		int second = 0;
		for (int i = 0; i < 6; i++) {
			second=second<<1;
			if((mask&1)==1) {
				second|=1;
			}
			mask=mask>>1;
		}
		if(second>59||mask>11)
			return null;
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(String.valueOf(mask));
		strBuilder.append(":");
		if(second<10)
			strBuilder.append("0");
		strBuilder.append(String.valueOf(second));
		return strBuilder.toString();
	}
	
	public static void main(String[] args) {
		T402 t402 = new T402();
		System.out.println(t402.readBinaryWatch(1));
	}
}
