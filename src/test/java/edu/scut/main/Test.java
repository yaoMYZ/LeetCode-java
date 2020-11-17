package edu.scut.main;

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
		
//		T406 t406= new T406();
//		int[][] A = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
//		int[][] outs = t406.reconstructQueue(A);
//		for (int[] out : outs) {
//			for (int js : out) {
//				System.out.print(js);
//				System.out.print(" ");
//			}
//			System.out.print("\t");
//		}
		
//		T1122 t1122= new T1122();
//		int[] arr1= {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
//		int[] arr2= {2,42,38,0,43,21};
//		int[] outs = t1122.relativeSortArray(arr1, arr2);
//		for (int out : outs) {
//			System.out.print(out);
//			System.out.print(" ");
//		}
		
//		TreeNode root = new TreeNode(10);
//		root.right = new TreeNode(-3);
//		root.right.right = new TreeNode(11);
//		
//		root.left = new TreeNode(5);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(2);
//		root.left.left.left = new TreeNode(3);
//		root.left.left.right = new TreeNode(-2);
//		root.left.right.right = new TreeNode(1);
//		
//		T437 t437 = new T437();
//		int record = t437.pathSum(root, 8);
//		System.out.println(record);
		
//		T438 t438 = new T438();
//		String s = "cbaebabacd";
//		String p = "abc";
//		System.out.println(t438.findAnagrams(s, p));
		
		T1030 t1030 = new T1030();
		int R = 3;
		int C = 5;
		int r0 = 2;
		int c0 = 3;
		int[][] result = t1030.allCellsDistOrder(R, C, r0, c0);
		for (int[] is : result) {
			for (int is2 : is) {
				System.out.print(is2);
				System.out.print(" ");
			}
			System.out.println("\t");
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
