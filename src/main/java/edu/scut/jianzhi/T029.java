package edu.scut.jianzhi;

public class T029 {
	
	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length==0)
			return new int[0];
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] pos = {{0,1},{1,0},{0,-1},{-1,0}};
		int[] run = {col,row-1};
		int runI = 0;
		int pI = 0;
		int[] po = {0,-1};
		int[] result = new int[row*col];
		
		int i=0;
		while(i<result.length) {
			for (int j = 0; j < run[runI]; j++) {
				po[0]+=pos[pI][0];
				po[1]+=pos[pI][1];
				result[i]=matrix[po[0]][po[1]];
				i++;
			}
			run[runI]--;
			runI=(runI+1)%2;
			pI=(pI+1)%4;
		}
		return result;
    }
	
	public static void main(String[] args) {
		T029 t029 = new T029();
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}};
		int[] r = t029.spiralOrder(matrix);
		for (int i : r) {
			System.out.println(i);
		}
	}
}
