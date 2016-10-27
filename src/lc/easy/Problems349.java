package lc.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Problems 349:
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
	Each element in the result must be unique.
	The result can be in any order.
 */
public class Problems349 {

	public int[] intersection(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for(int i : nums1)
			map1.put(i, i);
		
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for(int i : nums2)
			map2.put(i, i);
		
		Set<Integer> set = new HashSet<>();
		Iterator iter = map1.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry) iter.next();
			Integer k = (Integer) entry.getKey();
			if(map2.containsKey(k))
				set.add(k);
		}

		int[] result = new int[set.size()];
		int i = 0;
		for(Integer s : set){
			result[i] = s;
			i++;
		}
		return result;
	}
	
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		
		for(int i : nums1)
			set1.add(i);
		
		for(int i : nums2){
			if(set1.contains(i))
				set2.add(i);
		}
		
		int[] result = new int[set2.size()];
		int i = 0;
		for(Integer t : set2){
			result[i] = t;
			i++;
		}
		
		return result;
	}
	
	
	public int[] intersection3(int[] nums1, int[] nums2) {
		
		return null;
	}
	
	//快排
	public void fastSort(int[] num){
		int i = 0;
		int j = num.length-1;
		
		while(){
			
		}
		
	}

	public static void main(String[] args) {

	}

}
