package com.a88;

abstract class K
{
	abstract void k1();
}

class L extends K
{

	@Override
	void k1() {
		// TODO Auto-generated method stub
		System.out.println("k1 accessed");
	}
	
}
public class AbstractionEx 
{
	public static void main(String[] args) 
	{
		
		L l1  =new L();
		l1.k1();
		
		
	}
}
