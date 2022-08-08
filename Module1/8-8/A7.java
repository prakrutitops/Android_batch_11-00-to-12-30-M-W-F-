package com.a88;

interface Print
{
	void print();
}
interface Show
{
	void show();
}
interface Xyz
{
	void xyz();
}

public class A7 implements Print,Show,Xyz
{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("showing");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("printing");
	}

	@Override
	public void xyz() {
		// TODO Auto-generated method stub
		System.out.println("xyz");
	}
	
	public static void main(String[] args) {
		
		
		A7 a1 =new A7();
		a1.print();
		a1.show();
		a1.xyz();
		
	}

}
