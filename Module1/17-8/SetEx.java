package com.t178;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx 
{
	public static void main(String[] args) 
	{
		
		HashSet set =new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("C");
		set.add("D");
		set.add("P");
		Iterator i = set.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
	}
}
