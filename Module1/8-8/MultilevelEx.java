package com.a88;

class A
{
	
	
	void a1()
	{
		System.out.println("a1 accessed");
	}
}
class B extends A
{
	void b1()
	{
		System.out.println("b1 accessed");
	}
}
class C extends B
{
	void c1()
	{
		System.out.println("c1 accessed");
	}
}

public class MultilevelEx 
{
	public static void main(String[] args) 
	{
		
		C c1 =new C();
		c1.a1();
		c1.b1();
		c1.c1();
		
	}
}
