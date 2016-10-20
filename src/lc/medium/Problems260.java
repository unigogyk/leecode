package lc.medium;

/*
 * problem260:
260. Single Number III
Given an array of numbers nums, in which exactly two elements appear only once 
and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
	1.The order of the result is not important. So in the above example, [5, 3] is also correct.
	2.Your algorithm should run in linear runtime complexity. 
		Could you implement it using only constant space complexity?
 */
public class Problems260 {

	public static int[] singleNumber(int[] nums) {
		int result = 0;
		
		for(int n : nums){
			result ^= n;
		}
		
		//如何想到这条语句能够求出两数的二进制形式最低(最右)位的不同位？
		//求两数最低位不相同值的位数
		//下面两条语句等价，因为Java中int是以补码表示的，而负数的补码是其（绝对值的反码 ＋１）
		int bit = result & (~(result - 1));
		// int bit = result & -result;
		
		int r1 = 0;
		int r2 = 0;
		for(int n : nums){
			if((bit & n) == 0){
				r1 ^= n;
			} else {
				r2 ^= n;
			}
		}
		
		return new int[]{r1, r2};
	}

	public static void main(String[] args) {
//		int x = 3 ^ 4;
//		System.out.println(x);
//		int bit = x & ~(x-1);
//		System.out.println(bit);
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] a = singleNumber(nums);
		System.out.println(a[0] + " " + a[1]);
	}

}
