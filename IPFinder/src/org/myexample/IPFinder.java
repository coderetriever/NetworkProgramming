package org.myexample;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

//Finds the IP address of the localhost and a specified host
public class IPFinder 
{
	public static void main(String[] args)
	{
		try
		{
			//Get address of local host
			InetAddress address = InetAddress.getLocalHost();			
			System.out.println("Localhost is: " + address.toString());
			
			//Get address of a specified host
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the hostname:");
			String host = input.next();
			
			System.out.println("Address of " + host + " is:" + InetAddress.getByName(host));
		}catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
	}
}
