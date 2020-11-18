package edu.scut.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		Set<Integer> result = new HashSet<Integer>();
		for (int i = 1; i <= nums.length; i++) {
			result.add(i);
		}
		for (Integer integer : nums) {
			if(result.contains(integer))
				result.remove(integer);
		}
		return new ArrayList<>(result);
    }
}
