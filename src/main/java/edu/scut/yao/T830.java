package edu.scut.yao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T830 {
	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> result = new ArrayList<>();
		for (int l = 0, r=0 ; r < s.length(); r++) {
			if(r==s.length()-1||s.charAt(l)!=s.charAt(r+1)) {
				if(r-l>=2)
					result.add(Arrays.asList(l,r));
				l=r+1;
			}
		}
		return result;
    }
	
}
