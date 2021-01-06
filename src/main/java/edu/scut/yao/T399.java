package edu.scut.yao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

 

public class T399 {
	class EquEntry{
		public EquEntry(String str, double value) {
			this.str = str;
			this.value = value;
		}
		String str;
		double value;
	}
	
	private Map<String, Set<EquEntry>> strMap;
	
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		strMap = new HashMap<>();
		for (int i=0;i<equations.size();i++) {
			List<String> arr = equations.get(i);
			String first = arr.get(0);
			String second = arr.get(1);
			strMap.computeIfAbsent(first, k -> new HashSet());
			strMap.get(first).add(new EquEntry(second, values[i]));
			strMap.computeIfAbsent(second, k -> new HashSet());
			strMap.get(second).add(new EquEntry(first, 1/values[i]));
		}
		
		double[] result = new double[queries.size()];
		Map<String, Boolean> booleMap = new HashMap<>();
		for (String str : strMap.keySet()) {
			booleMap.put(str,true);
		}
		for (int i=0; i<queries.size();i++) {
			List<String> query = queries.get(i);
			String first = query.get(0);
			String second = query.get(1);
			booleMap.put(first, false);
			if(!strMap.containsKey(first)||!strMap.containsKey(second)) {
				result[i]=-1.0;
			}else {
				if(first.equals(second)) {
					result[i]=1.0;
				}else {
					result[i]=getNumber(first, second, booleMap);
				}
			}
			booleMap.put(first, true);
		}
		
		
		return result;
	}
	
	
	private double getNumber(String curStr,String target,Map<String, Boolean> booleMap) {
		double result = -1.0;
		for (EquEntry strEntry : strMap.get(curStr)) {
			String str = strEntry.str;
			double value = strEntry.value;
			if(booleMap.get(str)) {
				if(str.equals(target)) {
					return value;
				}else {
					booleMap.put(str, false);
					double tmp = getNumber(str, target, booleMap);
					booleMap.put(str, true);
					if(tmp!=-1.0)
						return tmp*value;
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		T399 t399 = new T399();
		List<List<String>> equations = new ArrayList<>();
		equations.add(Arrays.asList("a","b"));
		equations.add(Arrays.asList("c","d"));
		equations.add(Arrays.asList("e","f"));
		equations.add(Arrays.asList("g","h"));
		double[] values = {4.5,2.3,8.9,0.44};
		List<List<String>> queries = new ArrayList<>();
		queries.add(Arrays.asList("a","c"));
		queries.add(Arrays.asList("d","f"));
		queries.add(Arrays.asList("h","e"));
		queries.add(Arrays.asList("b","e"));
		double[] r = t399.calcEquation(equations, values, queries);
		for (double d : r) {
			System.out.println(d);
		}
	}
}
