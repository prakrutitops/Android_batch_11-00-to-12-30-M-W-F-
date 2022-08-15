package com.t158;

class Sender
{
	
	public void send(String msg)
	{
		System.out.println("Sending "+msg);
		
		System.out.println(msg+"Sent");
	}
}

class ThreadSend extends Thread
{
	Sender sender;
	String msg;
	
	public ThreadSend(Sender sender,String msg)
	{
		// TODO Auto-generated constructor stub
		this.sender=sender;
		this.msg=msg;
	}
	
	public void run()
	{
		synchronized (sender) 
		{
			sender.send(msg);	
		}
		
	}
}

public class SyncDemoEx 
{
	public static void main(String[] args) {
		
		Sender sender=new Sender();
		
		ThreadSend t1 = new ThreadSend(sender, "Hii");
		ThreadSend t2 = new ThreadSend(sender, "Byee");
		
		t1.start();
		t2.start();
		
	}
}
