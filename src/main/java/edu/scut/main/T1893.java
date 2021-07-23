package edu.scut.main;

public class T1893 {
	public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];   // �������
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }
        // ǰ׺��
        int curr = 0;
        for (int i = 1; i <= 50; ++i) {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0) {
                return false;
            }
        }
        return true;
    }
	
	
}
