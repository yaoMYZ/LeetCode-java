package edu.scut.jianzhi;

public class T011 {
	public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }


	public static void main(String[] args) {
		T011 t011 = new T011();
		int[] numbers = {3,3,1,3};
		int r = t011.minArray(numbers);
		System.out.println(r);
	}
}
