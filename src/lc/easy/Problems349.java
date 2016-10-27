package lc.easy;

import java.util.Arrays;
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
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int i = 0;
		int j = 0;
		Set<Integer> set = new HashSet<Integer>();
		
		while(i<nums1.length && j<nums2.length){
			while(i+1<nums1.length){
				if(nums1[i] == nums1[i+1])
					i++;
			}
			
			while(j+1<nums1.length){
				if(nums2[j] == nums2[j+1])
					j++;
			}
			
			if(nums1[i] == nums2[j]){
				set.add(nums1[i]);
			}
			i++;
			j++;
		}
		
		int[] result = new int[set.size()];
		int k = 0;
		for(Integer t : set){
			result[k] = t;
			k++;
		}
			
		return result;
	}
	
	

	public static void main(String[] args) {
		int[] a = new int[]{1,4,3,8,9};
		Arrays.sort(a);
		
		for(int i : a)
			System.out.print(i + " ");
	}

}
