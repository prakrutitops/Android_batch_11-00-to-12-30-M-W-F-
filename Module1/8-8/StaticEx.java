package com.a88;

public class StaticEx 
{
	int id;
	String name;
	static String college="Atmiya";
	
	public StaticEx(int id,String name)
	{
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		
	}
	
	void display()
	{
		System.out.println(id+" "+name+" "+college);
	}
	static void change()
	{
		college="VVP";
	}
	
	public static void main(String[] args)
	{
		change();
		
		StaticEx s1 =new StaticEx(101, "Abc");
		StaticEx s2 =new StaticEx(102, "Pqr");
		StaticEx s3 =new StaticEx(103, "Xyz");
		
		s1.display();
		s2.display();
		s3.display();
		
	}
}
