package org.myexample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoServer 
{
	public static void main(String[] args)
	{
		Socket socketAtPort = null;
		
		try
		{
			System.out.println("Server----");
			
			//Accept a connection from client on port 8778
			ServerSocket serverSocket = new ServerSocket(8778);			
			socketAtPort = serverSocket.accept();
			
			//Get input and output streams to the socket
			Scanner socketReader = new Scanner(socketAtPort.getInputStream());
			PrintWriter socketWriter = new PrintWriter(socketAtPort.getOutputStream(), true);
			
			String incomingMessage = socketReader.nextLine();
			System.out.println("Client:" + incomingMessage);
			
			Scanner input = new Scanner(System.in);
			String message = input.nextLine();
			
			socketWriter.println(message);					
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(socketAtPort != null)
			{
				try
				{
					socketAtPort.close();
				}catch(IOException e)
				{					
				}				
			}
		}
		
	}
}
