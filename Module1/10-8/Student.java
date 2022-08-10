package com.a108;

import java.io.Serializable;

public class Student implements Serializable
{
	int id;
	String name;
	
	public Student(int id,String name)
	{
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
	}
}
