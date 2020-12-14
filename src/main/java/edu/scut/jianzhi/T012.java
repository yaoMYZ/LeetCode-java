package edu.scut.jianzhi;

import java.util.Arrays;

public class T012 {
	private boolean find = false;
	private int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
	private int row = -1;
	private int col = -1;
	public boolean exist(char[][] board, String word) {
		row = board.length;
		col = board[0].length;
		boolean[][] flags = new boolean[row][col];
		for (boolean[] bs : flags) {
			Arrays.fill(bs, true);
		}
		for (int i = 0; i < row; i++) {
			for (int j=0;j<col;j++) {
				if(board[i][j]==word.charAt(0)) {
					flags[i][j]=false;
					int[] nPos = {i,j};
					find(board, word, 1, flags, nPos);
					flags[i][j]=true;
				}
				if(find)
					return find;
			}
		}
		return find;
    }
	
	private void find(char[][] board, String word,int idx, boolean[][] flags,int[] curPos) {
		if(find)
			return;
		if(idx>=word.length()) {
			find = true;
			return;
		}
		for (int i = 0; i < pos.length; i++) {
			int r = curPos[0]+pos[i][0];
			int c = curPos[1]+pos[i][1];
			if(r>=0&&r<row&&c>=0&&c<col&&flags[r][c]&&word.charAt(idx)==board[r][c]) {
				flags[r][c] = false;
				int[] nPos = {r,c};
				find(board, word, idx+1, flags, nPos);
				flags[r][c] = true;
			}
			if(find)
				return;
		}
	}
	
//	public boolean exist(char[][] board, String word) {
//        char[] words = word.toCharArray();
//        for(int i = 0; i < board.length; i++) {
//            for(int j = 0; j < board[0].length; j++) {
//                if(dfs(board, words, i, j, 0)) return true;
//            }
//        }
//        return false;
//    }
//    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
//        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
//        if(k == word.length - 1) return true;
//        board[i][j] = '\0';
//        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || 
//                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
//        board[i][j] = word[k];
//        return res;
//    }

	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABDCED";
		T012 t012 = new T012();
		boolean r = t012.exist(board, word);
		System.err.println(r);
	}
}
