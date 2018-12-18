package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Templates;
public class Skyline {
	private List<int[]> res = new ArrayList<int[]>();
	/*
	 * get left nearest pointer
	 */
	public int[] getnearpointer(int pointer) {
		int[] re = new int[2];
		int x = res.get(0)[0];
		for(int[] item: res) {
			if(item[0] < pointer) {
				x = item[0];
			}else {				
			re[0] = item[0];
			re[1] = item[1];
			break;
			}
		}
		return re;
	}
	/*
	 * get the line pointer between new build  left pointer and right pointer
	 */
	public List<int[]> getrightset(int[] pointer){
		List<int[]> right = new ArrayList<int[]>();
		for(int[] item:res) {
			if(pointer[0]<=item[0] && item[0] <= pointer[1]) {
				right.add(item);
			}
		}
		return right;
	}
	/*
	 * sort res list increasely by x 
	 */
	public void listsort() {
		
		for(int i = 0; i < res.size();i++) {			
			int flag = i;
			for(int j = i+1;j < res.size();j++) {
				if(res.get(flag)[0] > res.get(j)[0] ) {
					flag = j;
				}
			}
			if(flag != i) {
				int tt = res.get(i)[0];
				res.get(i)[0] = res.get(flag)[0];
				res.get(flag)[0] = tt;
				tt = res.get(i)[1];
				res.get(i)[1] = res.get(flag)[1];
				res.get(flag)[1] = tt;
			}
		}
		
	}
	
	public void RemoveRepeat() {
		listsort();		
		for(int i = 0; i < res.size()-1;) {
			int[] tt = res.get(i);
			if(i+1 <res.size()) {
				if(res.get(i)[1] == res.get(i+1)[1]) {
					res.remove(i+1);
				}else {
					i += 1;
				}
			}
			
		}
	}
	public List<int[]> getSkyline(int[][] buildings) {
		
		if(buildings != null && buildings.length > 0) {
			int[] temp_build = new int[2];
			temp_build[0] = buildings[0][0];
			temp_build[1] = buildings[0][2];
			res.add(temp_build);
			temp_build[0] = buildings[0][1];
			temp_build[1] = 0;
			res.add(temp_build);
			for(int i = 1; i < buildings.length;i++) {
				int[] tem = new int[3];
					tem[0] = buildings[i][0];
					tem[1] = buildings[i][1];
					tem[2] = buildings[i][2];
					List<int[]> right = getrightset(tem);
					if(right.size() == 0 ) {
						if(res.get(res.size()-1)[0] < tem[0]) {
							int[] addpointer = new int[2];
							addpointer[0] = tem[0];
							addpointer[1] = tem[2];
							res.add(addpointer);
							addpointer[0] = tem[1];
							addpointer[1] = 0;
							res.add(addpointer);
						}else {
							int[]  leftnear = getnearpointer(tem[0]);
							if(leftnear[1] < tem[2]) {
								int[] addpointer = new int[2];
								addpointer[0] = tem[0];
								addpointer[1] = tem[2];
								res.add(addpointer);
								addpointer[0] = tem[1];
								addpointer[1] = leftnear[1];
								res.add(addpointer);
								listsort();
							}							
						}					
					}
					
					if(right.size() > 0) {						
							int[]  nearpointer = getnearpointer(tem[0]);
							if(nearpointer[1] < tem[2]) {
								int[] addpointer = new int[2];
								addpointer[0] = tem[0];
								addpointer[1] = tem[2];
								res.add(addpointer);
								listsort();
							}
							for(int[] in:right) {
								if(in[0] == tem[0]) {
									int index = res.indexOf(in);
									res.get(index)[1] = in[1] > tem[2] ? in[1]:tem[2];
								}else if(in[0] == tem[1]) {
									if(in[1] == tem[2]) {
										res.remove(in);
									}
								}else  {
									int index = res.indexOf(in);
									res.get(index)[1] = in[1] > tem[2]?in[1]:tem[2];
								}
							}
						
					}
			
			}
			
			RemoveRepeat();
		}
		return res;
	}
	
	public List<int[]> getskyline_second_method(int[][] buildings){
		List<int[]>  res = new ArrayList<int[]>();
		List<point>   initlist = new ArrayList<point>();
		List<point>   finalpoint = new ArrayList<point>();
		if(buildings != null && buildings.length > 0) {
			// find the range of the building
		int min = buildings[0][0], max = 0;
		for(int[] item:buildings) {
			if(item[0] < min) {
				min = item[0];
			}
			if(item[1] > max) {
				max = item[1];
			}
		}
		// init the original point
		for(int i = min; i <= max;i++) {
			point pp = new point();
			pp.x = i;
			pp.hight = 0;
			initlist.add(pp);
		}
		// init the point list with the max between x and x+1
		for(int[] item: buildings) {
			for(point p:initlist) {
				if(item[0] <= p.x && p.x < item[1]) {
					p.hight = item[2] > p.hight?item[2]:p.hight;
				}
			}
		}
//		// test print the middle  result
//		System.out.println("after init!");
//		for(point p:initlist) {
//			System.out.println(p.x+"  "+p.hight);
//		}
		//combine  neighbors with the same hight
		
		for(int i = 0; i < initlist.size();i++) {
			point p = initlist.get(i);
			if(finalpoint.size() == 0) {
				finalpoint.add(p);
			}
			point last = finalpoint.get(finalpoint.size()-1);
			if(p.hight != last.hight) {
				finalpoint.add(p);
			}
		}
		
		// transmit point into int[]
			for(point p:finalpoint) {
				int[] tem = new int[2];
				tem[0] = p.x;
				tem[1] = p.hight;
				res.add(tem);
			}
		}
		return res;
	}
	public List<int[]> getskyline_third_method(int[][] buildings){
		List<int[]>  res = new ArrayList<int[]>();
		List<point>   initlist = new ArrayList<point>();
		List<point>   finalpoint = new ArrayList<point>();
		List<Integer>    bottomnumber = new ArrayList<Integer>();
		if(buildings != null && buildings.length > 0) {
			// find the range of the building
		int min = buildings[0][0], max = 0;
		for(int[] item:buildings) {
			if(!bottomnumber.contains(item[0])) {
				bottomnumber.add(item[0]);
			}
			if(!bottomnumber.contains(item[1])) {
				bottomnumber.add(item[1]);
			}		
		}
		Collections.sort(bottomnumber);
		for(Integer tem:bottomnumber) {
			point p = new point();
			p.x = tem;
			p.hight = 0;
			initlist.add(p);
		}
		
//		//delete the repeat elements
//		for(int i = 0; i < initlist.size();i++) {
//			point p = initlist.get(i);
////			if(i+1 < initlist.size()) {
////				if(initlist.get(i+1).x == p.x && initlist.get(i+1).hight == p.hight) {
////					initlist.remove(i+1);
////				}else {
////					i += 1;
////				}
////			}else {
////				break;
////			}
//			for(int j = 0; j < i;j++) {
//				point pp = initlist.get(j);
//				if(pp.x == p.x) {
//					initlist.remove(p);
//					break;
//				}
//			}
			
		//}
		// init the point list with the max between x and x+1
		for(int[] item: buildings) {
			for(point p:initlist) {
				if(item[0] <= p.x && p.x < item[1]) {
					p.hight = item[2] > p.hight?item[2]:p.hight;
				}
			}
		}
		//combine  neighbors with the same hight
		
		for(int i = 0; i < initlist.size();i++) {
			point p = initlist.get(i);
			if(finalpoint.size() == 0) {
				finalpoint.add(p);
			}
			point last = finalpoint.get(finalpoint.size()-1);
			if(p.hight != last.hight) {
				finalpoint.add(p);
			}
		}
		
		// transmit point into int[]
			for(point p:finalpoint) {
				int[] tem = new int[2];
				tem[0] = p.x;
				tem[1] = p.hight;
				res.add(tem);
			}
		}
		return res;
	}
}

class point{
	public int x;
	public int hight;
}