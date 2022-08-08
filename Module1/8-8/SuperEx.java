package com.a88;

class MyColor
{
	
	String color="white";
	
}
class MyColor2 extends MyColor
{

	String color="black";
	
	void display()
	{
		System.out.println(color);
		System.out.println(super.color);
	}
}


public class SuperEx 
{
	public static void main(String[] args) 
	{
		MyColor2 m2 =new MyColor2();
		
		m2.display();
	}
}
