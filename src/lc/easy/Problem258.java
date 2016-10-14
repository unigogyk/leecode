package lc.easy;

/*
 * problem258:
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Hint:
	A naive implementation of the above process is trivial. Could you come up with other methods?
	What are all the possible results?
	How do they occur, periodically or randomly?
	You may find this Wikipedia article useful.
 */
public class Problem258 {

	public static int addDigits(int num) {
		int result = 0;
		
        if(num == 0)
        	result = 0;
        else {
        	int remainder = num%9;
        	
        	if(remainder == 0)
        		result = 9;
        	else
        		result = remainder;
        }
            
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(addDigits(38));
		System.out.println(addDigits(47));
		System.out.println(addDigits(0));
		System.out.println(addDigits(9));
		System.out.println(addDigits(18));
	}

}
