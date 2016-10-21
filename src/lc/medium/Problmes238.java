package lc.medium;

/*
 * Problems 238. Product of Array Except Self
Given an array of n integers where n > 1, 
nums return an array output such that output[i] is equal to the 
product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * 
 */
public class Problmes238 {

	//方法1：返回的结果数组output，不算做额外空间
	public static int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		for(int i=0; i<nums.length; i++)
			output[i] = 1;
		
		//计算left[i]
		//output[i]表示数组nums中前i-1个数的乘积，不包括nums[i]
		//所以有: output[i + 1] = output[i] * num[i]
		for(int i=0; i<nums.length-1; i++){
			output[i+1] = output[i] * nums[i];
		}
		
		//product表示数组nums中后n-i个数的乘积，不包括nums[i]
		//所以有: right[i] = right[i + 1] * num[i]
		int product = 1;
		for(int j=nums.length-1; j>=0; j--){
			output[j] = output[j] * product;
			product = product * nums[j];
		}
		
		return output;
	}
	

	//方法2： Time Limit Exceeded 
	public static int[] productExceptSelf2(int[] nums) {
		int[] output = new int[nums.length];
		int product = 1;	//数组nums前i项的乘积
		
		for(int i=0; i<nums.length-1; i++){
			output[i] = product;
			for(int j=i+1; j<nums.length; j++){
				if(nums[j] != 0){
					output[i] *= nums[j];
				} else{
					output[i] = 0;
					break;
				}
			}
			product *= nums[i];
		}
		output[output.length-1] = product;
		
		return output;
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
//		int[] a = {0, 0};
		int[] b = productExceptSelf(a);
		
		for(int i : b)
			System.out.print(i + " ");

	}

}
