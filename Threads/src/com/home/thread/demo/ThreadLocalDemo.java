package com.home.thread.demo;

public class ThreadLocalDemo
{
	public static void main(String args[])
	{
		FirstThread ft = new FirstThread();
		Thread t1 = new Thread(ft);
		Thread t2 = new Thread(ft);
		t1.setName("ONE");
		t2.setName("TWO");
		t1.start();
		t2.start();
	}
}

class FirstThread implements Runnable
{
	ThreadLocal noOfStatementsExecuted = new ThreadLocal();
	
	//int noOfStatementsExecuted;
	public void run()
	{
		for(int i = 0;i < 100;i++)
		{
			noOfStatementsExecuted.set(i);
			//noOfStatementsExecuted++;
			System.out.println(Thread.currentThread().getName()+ ":" +noOfStatementsExecuted.get());
			//System.out.println(Thread.currentThread().getName()+ ":" +noOfStatementsExecuted);
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