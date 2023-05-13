package com.metattri.anp.TB2_CodingExamples.Sockets.singlethread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain
{
	public static void main(String[] args)
	{
		System.out.println("[Server Main] Starting server listening...");
		ServerSocket serverSocket = null;
		
		try
		{
			// Start a ServerSocket that lists on port 
			serverSocket = new ServerSocket(5051);
			
			while(true) //Loop forever listening for connections
			{
			// Wait for a client to connect
			Socket socket = serverSocket.accept();
			
			System.out.println("[Server Main] Received new connection");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			PrintWriter printWriter = new PrintWriter(writer, true);
						
			// Sends a message via the IO stream to the socket
			printWriter.println("Hello! dflgkdfjglfdkgjdflgkdfj");
			socket.close();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally //A finally block *always* gets executed. It will close the listening socket.
		{
			try 
			{
				serverSocket.close();
			}
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
		}
	}
}
