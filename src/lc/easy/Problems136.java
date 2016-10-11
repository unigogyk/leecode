package lc.easy;

/*
 * problem:
Given an array of integers, every element appears twice except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 */
public class Problems136 {

	public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums){
            result = result ^ n;
        }
        return result;
    }
	
	public static void main(String[] args) {
		//Test Case
		//[1]
	}

}
