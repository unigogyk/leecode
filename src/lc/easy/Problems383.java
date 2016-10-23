package lc.easy;

/*
 * Problems 383. Ransom Note:
Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  
write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ; 
 otherwise,  it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class Problems383 {

	// 方法1
	public static boolean canConstruct(String ransomNote, String magazine) {
		char[] ran = ransomNote.toCharArray();
		char[] mag = magazine.toCharArray();

		int[] r = new int[26];
		int[] m = new int[26];

		// 统计字符串ransomNote中各个字符的个数
		for (int i = 0; i < ran.length; i++) {
			r[ran[i] - 97] += 1;
		}

		// 统计字符串magazine中各个字符的个数
		for (int i = 0; i < mag.length; i++) {
			m[mag[i] - 97] += 1;
		}

		// 若magazine中某个字符个数 < ransomNote中某个字符个数，则返回False
		for (int i = 0; i < r.length; i++) {
			m[i] -= r[i];
			if (m[i] < 0)
				return false;
		}
		return true;
	}

	// 方法2: 方法1的部分优化
	public static boolean canConstruct2(String ransomNote, String magazine) {
		char[] mag = magazine.toCharArray();
		int[] ch = new int[26];
		
		for(int i=0; i < mag.length; i++)
			ch[mag[i] - 'a'] += 1;
		
		char[] ran = ransomNote.toCharArray();

		for(char c : ran){
			ch[c - 'a'] -= 1;
			if(ch[c - 'a'] < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
		System.out.println(canConstruct("", "b"));
		System.out.println("-------------");
		System.out.println(canConstruct2("a", "b"));
		System.out.println(canConstruct2("aa", "ab"));
		System.out.println(canConstruct2("aa", "aab"));
		System.out.println(canConstruct2("", "b"));
	}

}
