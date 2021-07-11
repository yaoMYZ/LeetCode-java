package edu.scut.yao;

import java.util.Arrays;

public class T274 {
	public int hIndex(int[] citations) {
		int len = citations.length;
		Arrays.sort(citations);
		int h = 0;
		for (int i = len-1; i >=0 ; i--) {
			h+=1;
			if(citations[i]<h)
				return h-1;
		}
		return len;
    }
	
	public static void main(String[] args) {
		T274 t274 = new T274();
		int[] citations = {3,0,6,1,5};
		System.out.println(t274.hIndex(citations));
	}
}
