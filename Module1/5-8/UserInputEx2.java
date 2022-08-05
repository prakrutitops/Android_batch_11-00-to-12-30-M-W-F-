package com.a58;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class UserInputEx2 
{
	public static void main(String[] args) throws IOException 
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter y n");
		int id=sc.nextInt();		
		String id2=String.valueOf(id);
		FileOutputStream fout =new FileOutputStream("E://shama.txt");
		fout.write(id2.getBytes());
		System.out.println("success");
	}
}
