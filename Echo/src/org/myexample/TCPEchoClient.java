package org.myexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPEchoClient 
{
	public static void main(String[] args)
	{
		Socket socket = null;
		
		try
		{
			//Get address of the server
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			//Create a socket to server and the port it is listening on
			socket = new Socket(serverAddress, 8778);

			//Get a message to send to the server 
			System.out.print("Enter a message:");
			Scanner input = new Scanner(System.in);
			String inputMessage = input.nextLine();
			
			//Get output stream of socket
			PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
			
			//Write to server			
			socketWriter.println(inputMessage);
			
			//Get input stream of socket
			Scanner socketReader = new Scanner(socket.getInputStream());
			String message = socketReader.nextLine();
						
			System.out.println("Server:" + message);			
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(socket != null)
			{
				try
				{
					socket.close();
				}catch(IOException e)
				{
					e.printStackTrace();
				}				
			}
		}
	}
}
