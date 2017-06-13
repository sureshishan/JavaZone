package com.home.thread.demo;

public class ThreadGroupDemo
{
	public static void main(String args[])
	{
		ThreadGroup tg = new ThreadGroup("Group-A");
		
		FirstThread ft = new FirstThread();
		Thread t1 = new Thread(tg, ft);
		
		SecondThread st = new SecondThread();
		Thread t2 = new Thread(tg, st);
		
		t1.start();
		t2.start();
	}
}

class FirstThread implements Runnable
{
	public void run()
	{
		for(int i = 0;i < 100;i++)
		{
			System.out.println("FirstThread:"+i);
		}
	}
}

class SecondThread implements Runnable
{
	public void run()
	{
		for(int i = 0;i < 100;i++)
		{
			System.out.println("Second Thread:"+i);
		}
	}
}