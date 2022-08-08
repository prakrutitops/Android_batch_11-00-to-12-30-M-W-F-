package com.a88;

public class OverloadingEx 
{
	
	int cal(int a,int b)
	{
		return a+b;
	}
	double cal(double a,double b)
	{
		return a*b;
	}
	
	public static void main(String[] args) 
	{
		OverloadingEx o1 =new OverloadingEx();
		
		System.out.println(o1.cal(5,6));//addition
		System.out.println(o1.cal(2.99,3.99));//multiplication
		
		
	}
}
