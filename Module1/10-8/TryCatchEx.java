package com.a108;

public class TryCatchEx 
{
	public static void main(String[] args) 
	{
		
		try
		{
			//Logic
			int data=10/0;
			System.out.println(data);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e);
		}
		
		finally
		{
			System.out.println("success");
		}
		
		
		
	}
}
