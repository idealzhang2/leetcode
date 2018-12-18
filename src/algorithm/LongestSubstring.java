package algorithm;

import java.util.Vector;


public class LongestSubstring {
	private String LongestSubstring =  null;
	 public int GetLongestSubstring(String s) {
		 int  res = 0;
		 Vector vv = new Vector<>();
		if(s != null ) {
			if(s.equals("")) {
				res = 1;
			}
			int len = s.length();
			int index = 0;
			char tem ;
			int max = 0;
			vv.add(s.charAt(0));
			LongestSubstring = "";
			while(index <len) {
				tem = s.charAt(index);
				int position = 0;
				if((position = LongestSubstring.indexOf(tem)) >= 0) {
					max = max > LongestSubstring.length()? max:LongestSubstring.length();
					//System.out.println(tem);
					//System.out.println("before:  "+LongestSubstring);
					LongestSubstring = LongestSubstring.substring(position+1, LongestSubstring.length());
					//System.out.println("Sub:  "+LongestSubstring);
					LongestSubstring +=tem;
					//System.out.println("after:  "+LongestSubstring);
					
				}else {
					LongestSubstring += tem;
				}
				
				//System.out.println(LongestSubstring);
				index++;
			}		
			if(max > res) {
				res = max;
			}
		}
		 return res;
	 }

	 public int maxsizeofsubstring(String s) {
		 int start = 0,max = 0;
		 int arr[] = new int[128];
		 for(int i = 0; i < s.length();i++) {
			 start = start > arr[s.charAt(i)]? start:s.charAt(i);
			 max = max > (i - start)? max :(i-start+1);
			 arr[s.charAt(i)]=i+1;			 
		 }
		
		 return max;
	 }
}
