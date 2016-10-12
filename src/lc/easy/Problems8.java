package lc.easy;

/*
 * problems8:
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. 
If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.
 */
public class Problems8 {

	public static int myAtoi(String str) {
		int result = 0;
		boolean isNeg = false;
		int max = (int)Math.pow(2, 32);
		int min = max*-1 -1;
		
		str = str.trim();
		for(int i=0; i<str.length(); i++){
			String s = str.substring(i, i+1);
			char ch = str.charAt(i);
			
			if(i == 0){		//第一个字符只能为“+”、“-”、或数字
				if(s.equals("-")){
					isNeg = true;
					continue;
				} else if(s.equals("+")){
					isNeg = false;
					continue;
				} else if(ch >= '0' && ch <= '9'){
					result = result*10 + Integer.parseInt(s);
				} else {
					return 0;
				}
			} else {	//除第一个字符，其余字符应当为0~9的数字。
				if(ch >= '0' && ch <= '9'){
					if(result > max/10){	//防止溢出
						if(isNeg){
							return min;
						} else{
							return max;
						}
					}
					if(result == max/10){
						int t = Integer.parseInt(s);
						if(isNeg){
							if(t>8)	//最小数min的个位数是8
								return min;
						} else{
							if(t>7)	//最大数max的个位数是7
								return max;
						}
					}
					result = result*10 + Integer.parseInt(s);
				}
				else{	//遇到非0~9的的字符，则返回该字母前边是数字。如：123a4，遇到a则返回123
					break;
				}
			}		
		}
		
		if(isNeg)
			return result*-1;
		else
			return result; 
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
		System.out.println(myAtoi("2147483646"));
		System.out.println(myAtoi("-2147483648"));
		System.out.println(myAtoi("2147483d23"));
		System.out.println(myAtoi("   2147483"));
	}

}
