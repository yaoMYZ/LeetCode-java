package edu.scut.jianzhi;

public class T004 {
	private boolean find = false;
	
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix.length==0)
			return false;
		int[] p1 = {0,0};
		int[] p2 = {matrix.length-1,matrix[0].length-1};
		find(matrix, p1, p2, target);
		return find;
    }
	
	public void find(int[][] matrix,int[] p1,int[] p2, int target) {
		if(find)
			return;
		if(p1[0]>p2[0]||p1[1]>p2[1])
			return;
		int row = p2[0]-p1[0];
		int col = p2[1]-p1[1];
		int n = Math.min(row, col);
		int mid = 0;
		while (mid <= n) {
			int i = mid+p1[0];
			int j = mid+p1[1];
			if(matrix[i][j]==target) {
				find = true;
				return;
			}
			if(matrix[i][j]>target) {
				break;
			}	
			mid++;
		}
		int[] np1 = new int[2];
		np1[0] = p1[0];
		np1[1] = mid+p1[1];
		int[] np2 = new int[2];
		np2[0] = mid-1+p1[0];
		np2[1] = p2[1];
		find(matrix, np1, np2, target);
		
		if(find)
			return;
		np1[0] = p1[0]+mid;
		np1[1] = p1[1];
		np2[0] = p2[0];
		np2[1] = mid-1+p1[1];
		find(matrix, np1, np2, target);
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}};
		int target = 0;
		T004 t004 = new T004();
		boolean find = t004.findNumberIn2DArray(matrix, target);
		System.out.println(find);
	}
}
