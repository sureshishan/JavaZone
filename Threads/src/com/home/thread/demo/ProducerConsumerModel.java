package com.home.thread.demo;

import java.util.ArrayList;

public class ProducerConsumerModel
{
	public static void main(String args[])
	{
		ProductBuffer buffer = new ProductBuffer();
		Producer p = new Producer(buffer);
		p.start();
		Consumer c = new Consumer(buffer);
		c.start();
	}
}

class Product
{
	int id;
	String name;
	
	public String toString()
	{
		return id + ":" + name;
	}
}

class ProductBuffer
{
	ArrayList<Product> productList = new ArrayList<Product>();
	private static final int MAX_BUFFER_SIZE = 10;
	
	public synchronized void addProductsToBuffer(Product p)
	{
		System.out.println("Adding the product:"+p);
		if(productList.size() >= MAX_BUFFER_SIZE)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ex)
			{
				
			}
		}
		else
		{
			notifyAll();
			productList.add(p);
		}
	}
	
	public synchronized void consumeProductsFromBuffer()
	{
		if(productList.size() == 0)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ex)
			{
				
			}
		}
		else
		{
			notifyAll();
			System.out.println("Consumed Product:"+ productList.remove(0));
		}
	}
}

class Producer extends Thread
{
	ProductBuffer buffer;
	
	Producer(ProductBuffer buffer)
	{
		this.buffer = buffer;
	}
	
	public void run()
	{
		
		for(int i = 0;i < 30;i++)
		{
			Product p = new Product();
			p.id = i;
			p.name = "PRO-"+i;
			buffer.addProductsToBuffer(p);
		}
	}
}

class Consumer extends Thread
{
	ProductBuffer buffer;
	
	Consumer(ProductBuffer buffer)
	{
		this.buffer = buffer;
	}
	public void run()
	{
		for(int i = 0;i < 30;i++)
		{
			buffer.consumeProductsFromBuffer();
		}
	}
}

