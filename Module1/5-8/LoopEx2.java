package com.a58;

import java.util.Scanner;

public class LoopEx2 
{
	public static void main(String[] args) 
	{
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter your choice");
		int num=sc.nextInt();
		
		for(int i=1;i<=num;i++)
		{
			System.out.println("Hello From Tops");
		}
	}
}
