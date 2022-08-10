package com.a108;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO 
{
	public static void main(String[] args) 
	{
		
		try 
		{
			String s="welcome to tops";
			FileOutputStream  fout = new FileOutputStream("E://abhishek.txt");
			fout.write(s.getBytes());	
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("success");
	}
}
