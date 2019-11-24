package com.example.topcoder;
import com.example.topcoder.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class ColorfulDisks {
	public String[] singleColor(String[] disks){
		Map map = new HashMap();
		Map count = new HashMap();

		String max = "";
		int max_count = 0;

		for (String d : disks){
			String[] arr = d.split(" ");

			if (map.containsKey(arr[0])){
				map.put(arr[0], map.get(arr[0]) + ";" + arr[1]);
				count.put(arr[0], (int)count.get(arr[0]) + 1);
			} else  {
				map.put(arr[0], arr[1]);
				count.put(arr[0], 1);
			}

			if((int)count.get(arr[0]) > max_count){
				max_count = (int)count.get(arr[0]);
				max = arr[0];
			}
		}

		String max_str = (String)map.get(max);
		String[] max_list =  max_str.split(";");


		for(Object k:map.keySet()){
			String str = (String)map.get(k);
			String[] str_list =  str.split(";");
			HashSet<String> hset= new HashSet<>();

			int m = max_list.length;
			int n = str_list.length;

			// hset stores all the values of arr1
			for(int i = 0; i < m; i++)
			{
				if(!hset.contains(max_list[i]))
					hset.add(max_list[i]);
			}


			// loop to check if all elements of arr2 also
			// lies in arr1
			for(int i = 0; i < n; i++)
			{
				if(!hset.contains(str_list[i])) {
					return new String[]{};
				}
			}

		}

//		Util u = new Util();
//		for(Object k:map.keySet()){
//			String str = (String)map.get(k);
//			String[] str_list =  str.split(";");
//
//			if (! u.isSubset(max_list, str_list)){
//				return new String[]{};
//			}
//
//		}

		List<String> list=new ArrayList<>();
		for(Object c:count.keySet()){
//			System.out.println(c);
//			System.out.println(map.get(c));

			if (max_count == (int)count.get(c)){
				list.add((String)c);
			}
		}


		String[] ret= new String[list.size()];
		list.toArray(ret);

		return ret;
	}




	public static final void main(String[] args){
		//String[] disks = new String[] {"red 1", "blue 1", "green 1"};
//		String[] disks = new String[] {"black 2", "white 1"};
//		String[] disks = new String[] {"black 1", "white 1", "grey 1", "grey 2", "white 3", "black 3", "grey 3"};
		String[] disks = new String[] {"red 1", "red 2", "red 3", "red 2"};
		ColorfulDisks c = new ColorfulDisks();
		String[] ret = c.singleColor(disks);
		for (String s : ret) {
			System.out.println(s);
		}
	}
}


