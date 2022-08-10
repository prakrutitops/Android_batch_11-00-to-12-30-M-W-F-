package com.a108;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeEx 
{
	
	public static void main(String[] args)
	{
		
		try 
		{
			ObjectInputStream in =new ObjectInputStream(new FileInputStream("E://yash.txt"));
			Student s=(Student) in.readObject();
			System.out.println(s.id+" "+s.name);
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


		
	}
	
}
