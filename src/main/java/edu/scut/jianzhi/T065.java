package edu.scut.jianzhi;

public class T065 {
	public int add(int a, int b) {
		while(b != 0) { // ����λΪ 0 ʱ����
	        int c = (a & b) << 1;  // c = ��λ
	        a ^= b; // a = �ǽ�λ��
	        b = c; // b = ��λ
	    }
	    return a;
    }

}
