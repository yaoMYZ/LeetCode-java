package edu.scut.yao;

public class T861 {
	public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]); // �����һ�н������з�ת�����Ԫ�ص�ʵ��ȡֵΪ 1 - A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }
	
	public static void main(String[] args) {
		int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}}; 
		T861 t861 = new T861();
		int ret = t861.matrixScore(A);
		System.out.println(ret);
	}
}
