package edu.scut.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T909 {
	public int snakesAndLadders(int[][] board) {
		
		int[] nboard = getNboard(board);
		int target = nboard.length-1;

        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] seen = new boolean[nboard.length];
        Arrays.fill(seen, false);

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Integer status = queue.poll();
                for (int j = status+1; j <= status+6&&j<=target; j++) {
                	int k = j;
    				if(nboard[k]!=-1) {  //只传送一次
    					seen[k] = true;
    					k = nboard[k]-1;
    				}
    				if (!seen[k]) {
                        if (k==target) {
                            return step;
                        }
                        queue.add(k);
                        seen[k] = true;
                    }
                						
        		}
            }
        }

        return -1;
    }
	
	private int[] getNboard(int[][] board) {
		int[] nboard = new int[board.length*board[0].length];
		int idx = 0;
		boolean flag = true;
		for (int r = board.length-1;r>=0;r--) {
			int[] row = board[r];
			if(flag) {
				for (int n : row)
					nboard[idx++] = n;
			}else {
				for (int i = row.length-1; i >=0; i--) {
					nboard[idx++] = row[i];
				}
			}
			flag=!flag;
		}
		return nboard;
	}
	
	
	public static void main(String[] args) {
//		int[][] board = {
//			{-1,-1,-1,-1,-1,-1},
//			{-1,-1,-1,-1,-1,-1},
//			{-1,-1,-1,-1,-1,-1},
//			{-1,35,-1,-1,13,-1},
//			{-1,-1,-1,-1,-1,-1},
//			{-1,15,-1,-1,-1,-1}
//		};
		
		int[][] board= {
			{-1,-1,30,14,15,-1},
			{3,9,-1,-1,-1,9},
			{12,5,7,24,-1,30},
			{10,-1,-1,-1,25,17},
			{32,-1,28,-1,-1,32},
			{-1,-1,23,-1,13,19}
		};
		
		T909 t909 = new T909();
		System.out.println(t909.snakesAndLadders(board));
	}
}
