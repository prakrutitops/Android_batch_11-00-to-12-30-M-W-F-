package com.a108;

public class ThrowEx 
{
	static void validate(int age)
	{
		if(age>=18)
		{
			System.out.println("Eligible to Vote");
		}
		else
		{
			//throw new ArithmeticException("Not Valid");
			try 
			{
				throw new MyExceptionEx();
			}
			catch (MyExceptionEx e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("success");
	}
	public static void main(String[] args)
	{
		validate(12);
		System.out.println("success2");
	}
}
