package edu.scut.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Board implements Cloneable{
	public int[][] board;
	public int[] cpos;
	
	public Board(int[][] board, int[] cpos) {
		this.board = board;
		this.cpos = cpos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(board);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(board, other.board))
			return false;
		return true;
	}

	@Override
	protected Board clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Board nboard = (Board) super.clone();
		int[][] ob = nboard.board;
		int[][] nb = new int[ob.length][];
		for(int i=0;i<ob.length;i++){
			nb[i] = new int[ob[i].length];
			System.arraycopy(ob[i], 0, nb[i], 0, nb[i].length);
		}
		nboard.board = nb;
		return nboard;
	}
}

public class T773 {
	public int slidingPuzzle(int[][] board) {
		HashSet<Board> seen = new HashSet<>();
		Queue<Board> queue = new LinkedList<>();
		
		Board target = new Board(new int[][]{{1,2,3},{4,5,0}}, new int[]{1,2});
		Board firt = new Board(board, findZero(board));
		if(firt.equals(target))
			return 0 ;
		seen.add(firt);
		queue.add(firt);
		
		int res = 0;
		int[][] direc = {{1,0},{-1,0},{0,1},{0,-1}};
		int r = board.length;
		int c = board[0].length;
		while (!queue.isEmpty()) {
			res++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Board curBoard = queue.poll();
				int[] cpos = curBoard.cpos;
				
				for (int j = 0; j < direc.length; j++) {
					int[] npos = {cpos[0]+direc[j][0],cpos[1]+direc[j][1]};
					if(npos[0]>=0&&npos[0]<r&&npos[1]>=0&&npos[1]<c) {
						try {
							Board nBoard = curBoard.clone();
							swap(nBoard.board, cpos, npos);
							nBoard.cpos = npos;
							
							if(!seen.contains(nBoard)) {
								if(nBoard.equals(target))
									return res;
								queue.offer(nBoard);
								seen.add(nBoard);
							}
							
						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
			
		return -1;
    }
	
	private int[] findZero(int[][] board) {
		int[] pos = {0,0};
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]==0) {
					pos = new int[]{i,j};
					return pos;
				}
			}
		}
		return pos;
	}
	
	private void swap(int[][] board, int[] p1, int[] p2) {
		int tmp = board[p1[0]][p1[1]];
		board[p1[0]][p1[1]] = board[p2[0]][p2[1]];
		board[p2[0]][p2[1]] = tmp;
	}
	
	public static void main(String[] args) {
//		int[][] board= {{1,2,3},{4,0,5}};
//		int[] cpos = {0,0};
//		
//		Board board1 = new Board(board, cpos);
//		
//		try {
//			Board board2 = board1.clone();
//			board2.board[0][0] = 2;
//			System.out.println(board1.board[0][0]);
//			System.out.println(board2.board[0][0]);
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		int[][] board = {{12,3},{4,0,5}};
//		Board board1 = new Board(board);
//		
//		int[][] board2 = {{1,2,3},{4,0,5}};
//		Board board3 = new Board(board);
//		System.out.println(board1.hashCode());
//		System.out.println(board3.hashCode());
//		
//		HashSet<Board> set = new HashSet<>();
//		set.add(board1);
//		
//		if(set.contains(board3))
//			System.out.println("contain");
		
		T773 t773 = new T773();
		int[][] board = {{3,2,4},{1,5,0}};
		System.out.println(t773.slidingPuzzle(board));
		
	}
}
