package com.t178;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx 
{
	public static void main(String[] args) 
	{
		
		/*key,value pair*/
		
		HashMap<String,Integer> map =new HashMap<>();
		
		map.put("A", 101);
		map.put("B", 102);
		map.put("C", 103);
		map.put("D", 104);
		
		//for-each
		
		for(Map.Entry m:map.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
			
		}
		
		
		
	}
}
