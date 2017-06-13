package com.home.thread.demo;

public class ThreadDemo
{
	public static void main(String args[])
	{
		FirstThread t1 = new FirstThread();
		SecondThread t2 = new SecondThread();
		
		t1.start();
		
		t2.start();
		
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			
		}
		for(int i = 10000; i < 10100;i++)
		{
			System.out.println("MainThread:"+i);
		}
	}
}

class FirstThread extends Thread
{
	public void run()
	{
		for(int i = 0;i <= 100;i++)
		{
			if( i == 50)
			{
				try
				{
					Thread.sleep(500);
				}
				catch(InterruptedException e)
				{
				}
			}
			System.out.println("FirstThread:"+i);
		}
	}
}

class SecondThread extends Thread
{
	public void run()
	{
		for(int i = 0;i <= 100;i++)
		{
			System.out.println("SecondThread:"+i);
		}
	}
}

