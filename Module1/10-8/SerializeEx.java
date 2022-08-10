package com.a108;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeEx 
{
	public static void main(String[] args) 
	{
		
		try 
		{
			Student s1 =new Student(101,"Tops");
			FileOutputStream fout =new FileOutputStream("E://yash.txt");
			ObjectOutputStream out =new ObjectOutputStream(fout);
			out.writeObject(s1);
		}
		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("success");
		
	}
}
