package com.t178;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx 
{
	public static void main(String[] args) 
	{
		ArrayList arrayList=new ArrayList<>();
		
		arrayList.add("Android");
		arrayList.add("Java");
		arrayList.add("Php");
		
		
		ArrayList arrayList2 =new ArrayList<>();
		
		arrayList2.add("Python");
		arrayList2.add("Ios");
		arrayList2.add("GD");
		arrayList2.add("Java");
		
		//System.out.println(arrayList);
	/*	arrayList.addAll(arrayList2);
		arrayList.remove(0);
		arrayList.remove("GD");
		
		arrayList.removeAll(arrayList2);*/
		
		arrayList.retainAll(arrayList2);
		
		Iterator i =arrayList.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
	}
}
