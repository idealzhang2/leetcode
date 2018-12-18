package mainpackage;

import java.util.List;

import algorithm.LinkedListCycle;
import algorithm.LongestSubstring;
import algorithm.Skyline;
import structure.ListNode;

public class Start {

	public static void main(String[] args) {
		LongestSubstring tt = new LongestSubstring();
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
		int[][] build = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		//int[][] build = {{0,2147483647,2147483647}};
		//System.out.println(2147483647 <= Integer.MAX_VALUE);
		Skyline sky = new Skyline();
		List<int[]> res = sky.getskyline_third_method(build);
		System.out.println("final result!");
		for(int[] item:res) {
			System.out.println(item[0]+"     "+item[1]);
		}
		
	}

}
