package lc.medium;

/*
 * Problems167:
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class Problems167 {

	// 方法1
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return new int[2];

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] { i + 1, j + 1 };
				}
			}
		}

		return new int[2];
	}

	// 方法2
	public static int[] twoSum2(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return new int[2];

		int len = numbers.length;
		// 若target<最小元素，或 target>两个最大元素之和
		if (numbers[0] > target || (numbers[len - 1] + numbers[len - 2]) < target)
			return new int[2];

		for (int i = 0; i < len - 1; i++) {
			int start = i + 1;
			int end = len - 1;
			int mid = (start + end) / 2;

			while (start <= end) {
				if (numbers[i] + numbers[mid] == target) {
					return new int[] { i + 1, mid + 1 };
				} else if (numbers[i] + numbers[mid] < target) {
					start = mid + 1;
					mid = (start + end) / 2;
				} else {
					end = mid - 1;
					mid = (start + end) / 2;
				}
			}
		}
		return new int[2];
	}

	// 方法3
	public static int[] twoSum3(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return new int[2];

		int len = numbers.length;
		int start = 0;
		int end = len-1;
		
		while(start < end){
			int sum = numbers[start] + numbers[end];
			if(sum == target)
				return new int[]{start+1, end+1};
			else if(sum < target){
				start++;
			} else {
				end--;
			}
		}
		
		return new int[2];
	}

	public static void main(String[] args) {
		int a[] = new int[] { 2, 3, 4 };
		int b[] = twoSum3(a, 6);
		System.out.println(b[0] + " " + b[1]);
	}

}
