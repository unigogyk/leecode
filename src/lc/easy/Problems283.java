package lc.easy;

/*
 * problems283
283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
	1. You must do this in-place without making a copy of the array.
	2. Minimize the total number of operations.
	
Solution:
https://leetcode.com/articles/move-zeroes/

 */
public class Problems283 {

	public void moveZeroes(int[] nums) {
		int zeroCounts = 0;	//统计0的个数
		int i = 0;
		int j = 0;

		while (i < nums.length) {
			if (nums[i] == 0) {
				zeroCounts++;
				i++;
			} else {
				nums[j] = nums[i];
				i++;
				j++;
			}
		}

		//j之前的数都不是0，j之后有zeroCounts个0
		for (int k = j; k < nums.length; k++) {
			nums[k] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
