package mainpackage;

import java.util.List;

import algorithm.FrogPassRiver;
import algorithm.LinkedListCycle;
import algorithm.LongestSubstring;
import algorithm.PowerOfFour;
import algorithm.Skyline;
import algorithm.SumOfTwoNumber;
import structure.ListNode;

public class Start {

	public static void main(String[] args) {
		//LongestSubstring tt = new LongestSubstring();
		//System.out.println(tt.GetLongestSubstring("kdafkrowkldjjdjdjfkdj"));;
		//System.out.println(tt.GetLongestSubstring("abcabcbb"));
		//System.out.println(tt.GetLongestSubstring("bbbbb"));
		//System.out.println(tt.maxsizeofsubstring(" "));
//		ListNode head = new ListNode(3);
//		ListNode  p = head;
//		p.next = new ListNode(2);
//		p = p.next;
//		p.next = new ListNode(0);
//		p = p.next;
//		p.next = new ListNode(-4);
//		p = p.next;
//		p.next = head.next;
//		LinkedListCycle  cycle = new LinkedListCycle();
//		System.out.println(cycle.hasCycle(head));
		//[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
//		int[][] build = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//		//int[][] build = {{0,2147483647,2147483647}};
//		//System.out.println(2147483647 <= Integer.MAX_VALUE);
//		Skyline sky = new Skyline();
//		List<int[]> res = sky.getskyline_third_method(build);
//		System.out.println("final result!");
//		for(int[] item:res) {
//			System.out.println(item[0]+"     "+item[1]);
//		}
//		int[]  nums = {2,7,11,15};
//		int target = 9;
//		SumOfTwoNumber  tt = new SumOfTwoNumber();
//		int[] res = tt.twoSum(nums, target);
//		System.out.println(res[0]);
//		System.out.println(res[1]);
//		PowerOfFour pp = new PowerOfFour();
//		int[] test = {1,4,16,32,50,64,256};
//		for(int i = 0; i < test.length;i++) {
//			System.out.println(test[i]+":       "+pp.isPowerOfFour(test[i]));
//		}
		//System.out.print(64%4);
		int[] stones = {0,1,3,5,6,8,12,17};
		//int[] stones = {0,1,2,3,4,8,9,11};
		//int[] stones = {0,2};
		FrogPassRiver  p = new FrogPassRiver();
		System.out.println(p.canCross_second(stones));
		
	}

}
