package com.a88;

class A1
{
	String name;
	void a1()
	{
		System.out.println("a1 accessed");
	}
}
class B1 extends A1
{
	void b1()
	{
		System.out.println("b1 accessed");
	}
}

public class SingleInEx 
{
	public static void main(String[] args) 
	{
		B1 b =new B1();
		
		b.a1();
		b.b1();
	}
}
