package com.t158;



class A11 implements Runnable
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("Thread A: "+i);
		}
	}
}
class B11 implements Runnable
{
	
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("Thread B: "+i);
		}
	}
	
}
public class Example2 
{
	public static void main(String[] args) {
		
		Thread t1 =new Thread(new A11());
		
		Thread t2 =new Thread(new B11());
		
		t1.start();
		t2.start();
		
		
	}
}
