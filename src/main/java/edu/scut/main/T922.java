package edu.scut.main;

public class T922 {
	public int[] sortArrayByParityII(int[] A) {
		int oddIdx = 0;
		int evenIdx = 0;
		int aLen = A.length;
		while(oddIdx<aLen && evenIdx<aLen) {
			while(oddIdx<A.length) {
				if((A[oddIdx]%2==1) && (oddIdx%2!=1))
					break;
				oddIdx++;
			}
			if(oddIdx>=aLen)
				break;
			while(evenIdx<A.length) {
				if((A[evenIdx]%2==0) && (evenIdx%2!=0))
					break;
				evenIdx++;
			}
			if(evenIdx>=aLen)
				break;
			int tmp = A[oddIdx];
			A[oddIdx]=A[evenIdx];
			A[evenIdx]=tmp;
			oddIdx++;
			evenIdx++;
		}
		return A;
    }
}
