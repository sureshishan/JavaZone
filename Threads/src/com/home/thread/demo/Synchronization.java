package com.home.thread.demo;

public class Synchronization 
{
	public static void main(String args[])
	{
		Shared s1 = new Shared();
		//Shared s2 = new Shared();
		
		FirstThread t1 = new FirstThread(s1);
		t1.setName("F1");
		t1.start();
		
		SecondThread t2 = new SecondThread(s1);
		t2.setName("S1");
		t2.start();
		
		
		
	}
}

class FirstThread extends Thread
{
	Shared shared;
	public FirstThread(Shared shared)
	{
		this.shared = shared;
	}
	public void run()
	{
		shared.test1();
	}
}

class SecondThread extends Thread
{
	Shared shared;
	public SecondThread(Shared shared)
	{
		this.shared = shared;
	}
	public void run()
	{
		shared.test1();
	}
}

class Shared
{
	public void test1()
	{
		synchronized(this)
		{
			for(int i = 0;i < 100;i++)
			{
				System.out.println(Thread.currentThread().getName() + ": Sync--" + i );
			}
		}
		for(int i = 0;i < 300;i++)
		{
			System.out.println(Thread.currentThread().getName() + ":Non-Sync--" + i );
		}
	}
	
	public void test2()
	{
		for(int i = 0;i < 100;i++)
		{
			System.out.println(Thread.currentThread().getName() + ":" + i );
		}
	}
} 