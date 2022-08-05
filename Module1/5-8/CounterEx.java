package com.a58;

public class CounterEx 
{
	static int count=0;
	
	public CounterEx() 
	{
	
		count++;
		System.out.println(count);
	}
	public static void main(String[] args) 
	{
		CounterEx c1 =new CounterEx();
		CounterEx c2 =new CounterEx();
		CounterEx c3 =new CounterEx();
	}
}
