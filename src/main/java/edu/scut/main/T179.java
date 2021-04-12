package edu.scut.main;

import java.util.Arrays;

public class T179 {
	public String largestNumber(int[] nums) {
        int n = nums.length;
        // ת���ɰ�װ���ͣ��Ա㴫�� Comparator ���󣨴˴�Ϊ lambda ���ʽ��
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
	
	
	public static void main(String[] args) {
		T179 t179 = new T179();
		int[] nums = {3,30,34,5,9};
		System.out.println(t179.largestNumber(nums));
	}
}
