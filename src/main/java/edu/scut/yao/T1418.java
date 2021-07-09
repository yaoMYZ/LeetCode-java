package edu.scut.yao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class T1418 {
	public List<List<String>> displayTable(List<List<String>> orders) {
		List<List<String>> res = new ArrayList<>();
		Set<String> tableNames = new HashSet<>();
		Set<String> foodItems = new  HashSet<>();
		
		Map<String, Map<String, Integer>> tableMap = new HashMap<>();
		
		for (List<String> order : orders) {
			String tableName = order.get(2);
			String foodItem = order.get(1);
			
			tableNames.add(tableName);
			foodItems.add(foodItem);
			
			tableMap.computeIfAbsent(tableName, key->new HashMap<>());
			tableMap.get(tableName).computeIfAbsent(foodItem, key->0);
			
			tableMap.get(tableName).put(foodItem, tableMap.get(tableName).get(foodItem)+1);
		}
		
		List<String> tableNamesList= new ArrayList<>(tableNames);
		List<Integer> foodItemsList = new ArrayList<>();
		for (String foodItem : foodItems) {
			foodItemsList.add(Integer.valueOf(foodItem));
		}
		
		Collections.sort(tableNamesList);
		Collections.sort(foodItemsList);
		
		res.add(new ArrayList<>());
		res.get(0).add("Table");
		for (String tableName : tableNamesList) {
			res.get(0).add(tableName);
		}
		
		int resIdx = 1;
		for (Integer foodItem : foodItemsList) {
			res.add(new ArrayList<>());
			String foodItemStr = String.valueOf(foodItem);
			res.get(resIdx).add(foodItemStr);
			
			for (String tableName : tableNamesList) {
				Map<String, Integer> foodMap = tableMap.get(tableName);
				if(foodMap.containsKey(foodItemStr)) {
					res.get(resIdx).add(String.valueOf(foodMap.get(foodItemStr)));
				}else {
					res.get(resIdx).add("0");
				}
			}
			resIdx++;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		T1418 t1418 = new T1418();
		List<List<String>> orders = new ArrayList<>();
		orders.add(Arrays.asList(new String[]{"David","3","Ceviche"}));
		orders.add(Arrays.asList(new String[]{"Corina","10","Beef Burrito"}));
		orders.add(Arrays.asList(new String[]{"David","3","Fried Chicken"}));
		orders.add(Arrays.asList(new String[]{"Carla","5","Water"}));
		orders.add(Arrays.asList(new String[]{"Carla","5","Ceviche"}));
		orders.add(Arrays.asList(new String[]{"Rous","3","Ceviche"}));
		List<List<String>> res = t1418.displayTable(orders);
		System.out.println(res);
	}
}
