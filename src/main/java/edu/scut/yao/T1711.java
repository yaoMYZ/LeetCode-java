package edu.scut.yao;

import java.util.HashMap;
import java.util.Map;


public class T1711 {
	public int countPairs(int[] deliciousness) {
		final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
	
	public static void main(String[] args) {
		int[] deliciousness = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
		T1711 t1711 = new T1711();
		System.out.println(t1711.countPairs(deliciousness));
		
//		Food food1 = new Food(0, 2);
//		Food food2 = new Food(0, 2);
//		
//		Map<Food,Boolean> map= new HashMap<>();
//		map.put(food1, false);
//		if(map.containsKey(food2))
//			System.out.println("contain");
	}
}
