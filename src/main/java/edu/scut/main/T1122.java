package edu.scut.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class T1122 {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> numMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for (Integer n : arr1) {
			if(!numMap.containsKey(n))
				numMap.put(n, 0);
			numMap.put(n, numMap.get(n)+1);
		}
		for (Integer n : arr2) {
			int repeat = numMap.get(n);
			for (int i=0;i<repeat;i++) {
				result.add(n);
			}
			numMap.remove(n);
		}
		
		List<Integer> last = new ArrayList<>();
		for (Entry<Integer, Integer> entry : numMap.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				last.add(entry.getKey());
			}
		}
		last.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
			
		});
		for (Integer integer : last) {
			result.add(integer);
		}
		
		int[] resultNum = new int[arr1.length];
		for (int i=0;i<result.size(); i++) {
			resultNum[i] = result.get(i);
		}
		return resultNum;
    }
}
