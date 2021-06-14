package edu.scut.yao;

public class T278 {
	
	public int firstBadVersion(int n) {
		int target = -1;
		int sidx = 1;
		int edix = n;
		while(target==-1) {
			double diff = (edix-sidx)/2;
			int mid = (int) (Math.ceil(diff)+sidx);
			if(isBadVersion(mid)) {
				if(mid-1<1||!isBadVersion(mid-1)) {
					return mid;
				}else {
					edix = mid-1;
				}
			}else {
				sidx = mid+1;
			}
		}
		
        return target;
    }
	
	
	private boolean isBadVersion(int ver) {
		if(ver>=1702766719)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		T278 t278 = new T278();
		System.out.println(t278.firstBadVersion(2126753390));
	}
}
