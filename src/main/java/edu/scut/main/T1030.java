package edu.scut.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1030 {
	private int[][] dir1 = {{-1,0},{0,1},{1,0},{0,-1}};
	private int[][] dir2 = {{-1,-1},{-1,1},{1,-1},{1,1}};
	
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		boolean[][] visit = new boolean[R][C];
		for (int i = 0; i < visit.length; i++) {
			Arrays.fill(visit[i], false);
		}
		List<int[]> result = new ArrayList<int[]>();
		visit[r0][c0] = true;
		result.add(new int[]{r0,c0});
		
		List<int[]> tmpArr = new ArrayList<int[]>();
		tmpArr.add(result.get(0));
		int run = 1;
		while (!tmpArr.isEmpty()) {
			List<int[]> newTmpArr = new ArrayList<int[]>();
			for (int[] pos : tmpArr) {
				for (int[] dir : dir1) {
					int x = pos[0]+dir[0];
					int y = pos[1]+dir[1];
					if(0<=x&&x<R&&0<=y&&y<C&&!visit[x][y]) {
						result.add(new int[]{x,y});
						newTmpArr.add(result.get(result.size()-1));
						visit[x][y] = true;
					}
				}
			}
			int[] lPos = result.get(result.size()-1);
			int curDis = Math.abs(r0-lPos[0])+Math.abs(c0-lPos[1]);
			if(curDis==run*2) {
				for (int[] dir : dir2) {
					int x = r0+dir[0]*run;
					int y = c0+dir[1]*run;
					if(0<=x&&x<R&&0<=y&&y<C&&!visit[x][y]) {
						result.add(new int[]{x,y});
						newTmpArr.add(result.get(result.size()-1));
						visit[x][y] = true;
					}
				}
				run++;
			}
			tmpArr = newTmpArr;
		}
		for (int[] dir : dir2) {
			int x = r0+dir[0]*run;
			int y = c0+dir[1]*run;
			if(0<=x&&x<R&&0<=y&&y<C&&!visit[x][y]) {
				result.add(new int[]{x,y});
				visit[x][y] = true;
			}
		}
		return result.toArray(new int[R][C]);
    }
}
