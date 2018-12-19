package algorithm;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableColumnModelListener;
import javax.xml.transform.Templates;

import org.omg.CORBA.IdentifierHelper;

public class FrogPassRiver {
	public boolean recurse(int[] stones, int step) {
		boolean flag = false;
		if(stones == null) {
			return true;
		}
		if(stones.length == 1) {
			return true;
		}
		List<Integer> tem = new ArrayList<Integer>();
		for(int i = 1; i < stones.length;i++) {
			int tt = stones[i] - stones[0];		
			if(tt >= (step-1) && tt <= (step+1)) {
				tem.add(i);
			}
		}	
		if(tem.size() == 0) {
			return false;
		}
		for(int i = 0; i < tem.size(); i++) {
			int[] newstones = new int[stones.length - tem.get(i)];
			int k = 0;
			for(int j = tem.get(i); j < stones.length;j++) {			
				newstones[k++] = stones[j];
				//System.out.println(stones[j]);
			}
			if(recurse(newstones, stones[tem.get(i)]-stones[0])) {				
				flag = true;
			}
		}
		
		return flag;
	}
	public boolean canCross(int[] stones) {
		boolean flag = false;
		int step = 0;
		flag = recurse(stones, 0);		
		return flag;
	}
	public boolean canCross_second(int[] stones) {
		boolean flag = false;
		if(stones == null) {
			return true;
		}	
		if(stones.length == 0 || stones.length == 1) {
			return true;
		}
		if(stones[1] - stones[0] > 1) {
			return false;
		}
		List<distance> dif = new ArrayList<distance>();
		for(int i = 1; i < stones.length;i++) {
			distance dd = new distance();
			dd.diff = stones[i] - stones[i-1];
			dd.left = i-1;
			dd.right = i;
			dif.add(dd);
		}
		int index = 0;
		int max = 0; 
		int step = 0;
		int temindex = 0;
		boolean temflag = false;
		boolean  satisfy = false;
		int right = 0;
		while(index < stones.length) {
			max = 0;
			temflag = false;
			satisfy = false;
			for(distance item:dif) {
				if(item.left == index) {
					temflag = true;
				}
				if(max + item.diff > step+1) {
					break;
				}
				if(temflag && (max + item.diff <= (step+1))) {
					max += item.diff;	
					right = item.right;
					satisfy = true;					
				}
				
			}
			if(!satisfy) {
				return false;
			}	
			if((max >= (step - 1)) && (max <= (step + 1))) {
				step = stones[right] - stones[index];
				index = right;
				
			}else {
				return false;
			}
					
		}
		return flag;
	}
	
}

class distance{
	public int diff;
	public int left;
	public int right;
}