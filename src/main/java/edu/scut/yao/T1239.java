package edu.scut.yao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1239 {
	private int res=0;
	private List<Integer> masks = new ArrayList<>();
	
	public int maxLength(List<String> arr) {
		for (String str : arr) {
			int mask = 0;
			for (int i = 0; i < str.length(); i++) {
				int ch = str.charAt(i) - 'a';
				if((mask&(1<<ch))!=0) { //ÅÐ¶ÏÊÇ·ñÒÑ´æÔÚÖØ¸´×Ö·û
					mask=0; 
					break;
				}
				mask|=(1<<ch);
			}
			if(mask>0)
				masks.add(mask);
		}
		dp(0, 0);
		return res;
    }
	
	private void dp(int pos,int mask) {
		if(pos>=masks.size()) {
			return;
		}
		int tmask = masks.get(pos);
		if((mask&tmask)==0) {
			int nmask=mask|tmask;
			res = Math.max(res,Integer.bitCount(nmask));
			dp(pos+1, nmask);
		}
		dp(pos+1, mask);
	}
	
	public static void main(String[] args) {
		String[] arr = {"abcdefghijklmnopqrstuvwxyz"};
		T1239 t1239 = new T1239();
		System.out.println(t1239.maxLength(new ArrayList<String>(Arrays.asList(arr))));
	}
}
