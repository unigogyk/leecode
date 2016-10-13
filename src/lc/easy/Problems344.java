package lc.easy;

/*
 * problem344:
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
public class Problems344 {

	public static String reverseString(String s) {
		if(s.length() == 0)
			return "";
		
		char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length-1;
		char temp;
		
		while(i < j){
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			i++;
			j--;
		}
		
		return String.valueOf(arr);
	}
	
	public static String reverseString2(String s) {
		int len = s.length();
		
		if(len == 0)
			return "";
		
		char[] arr = new char[len];
		
		for(int i=0; i<len; i++){
			arr[i] = s.charAt(len-i-1);
		}
		
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		System.out.println(reverseString2("hello"));
	}

}
