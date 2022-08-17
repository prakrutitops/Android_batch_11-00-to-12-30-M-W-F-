package com.t178;

import java.util.Vector;

public class VectorEx 
{
	public static void main(String[] args) 
	{
		
		Vector v =new Vector<>(5);
		
		v.add("A");
		v.addElement("B");
		v.add("C");
		v.addElement("D");
		v.addElement("D");
		v.addElement("D");
		v.addElement("B");
		v.add("C");
		v.addElement("D");
		v.addElement("D");
		v.addElement("D");
		
		System.out.println(v.size());
		System.out.println(v.capacity());
		
		if(v.contains("E"))
		{
			System.out.println("TRUE");
		}
		else
		{
			System.out.println("FALSE");
		}
		
		System.out.println(v.firstElement());
		System.out.println(v.lastElement());
	
		
	}
}
