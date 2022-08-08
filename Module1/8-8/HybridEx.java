package com.a88;

class P1
{
	void p1()
	{
		System.out.println("p1 accessed");
	}
}
class Q extends P1
{
	void q()
	{
		System.out.println("q accessed");
	}
}
interface R 
{
	void r();
}
class S extends Q implements R
{
	void s()
	{
		System.out.println("s accessed");
	}

	@Override
	public void r() 
	{
		// TODO Auto-generated method stub
		System.out.println("r accessed");
	}
}


public class HybridEx 
{
	public static void main(String[] args) 
	{
		S s1 =new S();
		
		s1.p1();
		s1.q();
		s1.r();
		s1.s();
	}
}
