package lc.easy;

public class Problem389 {
	
	public static char findTheDifference(String s, String t) {
        int[] arr = new int[26];	//记录字符串s中各个字符出现的次数。下标0~25代表字符'a'~'z'
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        
        for(int i=0; i<sCharArr.length; i++){	//统计字符串s中各个字符出现的次数
        	arr[sCharArr[i]-'a'] += 1; 
        }
        
        for(int i=0; i<tCharArr.length; i++){	//字符串s中的字符在字符串t中每出现一次，数组arr对应的字母次数减1
        	arr[tCharArr[i]-'a'] -= 1;
        }
        
        /*for(int i=0; i<26; i++)
        	System.out.print(arr[i] + " ");
        
        System.out.println();*/
        
        for(int i=0; i<26; i++){	//从数组arr中寻找值为0的字符，这个字符就是t多出来的字符
        	if(arr[i] == -1)
        		return (char)(i+'a');
        }
        
        return '0';
    }
	
	//方法2：利用异或
	public static char findTheDifference2(String s, String t) {
		int result = 0;
		char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        
        for(int i=0; i<sCharArr.length; i++)
        	result = result ^ (sCharArr[i] - 'a');
        
        for(int i=0; i<tCharArr.length; i++)
        	result = result ^ (tCharArr[i] - 'a');
        
        return (char)(result + 'a');
		
	}

	public static void main(String[] args) {
//		System.out.println('c' - 'a');
		System.out.println(findTheDifference("", "g"));
		System.out.println(findTheDifference2("", "g"));
		System.out.println(findTheDifference("a", "ga"));
		System.out.println(findTheDifference2("a", "ga"));
	}

}
