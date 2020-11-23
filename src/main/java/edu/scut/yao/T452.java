package edu.scut.yao;

import java.util.Arrays;
import java.util.Comparator;

public class T452 {
	public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

	
	public static void main(String[] args) {
		T452 t452 = new T452();
//		int[][] points = {{10,16},{2,8},{1,6},{7,12}};
		int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
		int n=t452.findMinArrowShots(points);
		System.out.println(n);
	}
}
