package edu.scut.yao;

public class T374 {
	public static int pick = 6;
	
	public int guessNumber(int n) {
        int sidx = 1;
        int eidx = n;
        while(sidx<=eidx) {
        	int mid = (eidx-sidx)/2 + sidx;
        	if(guess(mid)==0) {
        		return mid;
        	}else if (guess(mid)==-1) {
				eidx = mid-1;
			}else {
				sidx = mid+1;
			}
        }
        return -1;
    }
	
	private int guess(int num) {
		if(num == pick) {
			return 0;
		}else if (num>pick) {
			return -1;
		}else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		T374 t374 = new T374();
		T374.pick = 1;
		int n = 1;
		System.out.println(t374.guessNumber(n));
	}
}
