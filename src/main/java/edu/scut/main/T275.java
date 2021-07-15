package edu.scut.main;

public class T275 {
	public int hIndex(int[] citations) {
		int sidx = 0;
		int eidx = citations.length-1;
		while(eidx>=sidx) {
			int mid = (eidx-sidx)/2 + sidx;
			int h = citations.length-mid;
			if(mid==0) {
				if(citations[mid]>=h)
					return h;
			}
			if(citations[mid]>=h&mid-1>=0&&citations[mid-1]<h+1)
				return h;
			if(citations[mid]<h)
				sidx = mid+1;
			else {
				eidx = mid-1;
			}
			
		}
		return 0;
    }
	
	public static void main(String[] args) {
		T275 t275 = new T275();
		int[] citations = {1,1,2,3,4,5,7};
		System.out.println(t275.hIndex(citations));
	}
}
