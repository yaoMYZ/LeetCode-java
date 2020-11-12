package edu.scut.main;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class Test {
	@org.junit.Test
	public void main() {
//		T031 t031 = new T031();
//		int[] nums = {2,2,0,4,3,1};
//		t031.nextPermutation(nums);
//		for (int i : nums) {
//			System.out.println(i);
//		}
		
//		T394 t394 = new T394();
//		String s = "3[a2[c]]";
//		String ss = t394.decodeString(s);
//		System.out.println(ss);
		
//		T339 t339 = new T339();
//		String[][] equations = {{"a","b"},{"b","c"}};
//		List<List<String>> newEqu = convertStringArrayToList(equations);
//		double[] values = {2.0,3.0};
//		String[][] queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"}};
//		List<List<String>> newQue = convertStringArrayToList(queries);
//		double[] ss = t339.calcEquation(newEqu,values,newQue);
//		for (double d : ss) {
//			System.out.println(d);
//		}
		
//		T922 t922= new T922();
//		int[] A = {4,2,5,7};
//		t922.sortArrayByParityII(A);
//		for (int i : A) {
//			System.out.println(i);
//		}
		
		T406 t406= new T406();
		int[][] A = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] outs = t406.reconstructQueue(A);
		for (int[] out : outs) {
			for (int js : out) {
				System.out.print(js);
				System.out.print(" ");
			}
			System.out.print("\t");
		}
	}
	
    /**2.将数组转换为list*/
	public static List<List<String>> convertStringArrayToList(String[][] array) {
		List<List<String>> result = new ArrayList<List<String>>();
		for (String[] listStr: array) {
			List<String> tmp = new ArrayList<>();
			for (String str : listStr) {
				tmp.add(str);
			}
			result.add(tmp);
		}
		return result;
	}
}
