package com.example.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Server
{
	@Element
	private int port;
	
	@Element
	private String host;
	
	public Server() 
	{}
	
	public Server(int port, String host)
	{
		setPort(port);
		setHost(host);
	}
	
	public int getPort() 
	{
		return port;
	}

	public void setPort(int port) 
	{
		this.port = port;
	}

	public String getHost() 
	{
		return host;
	}

	public void setHost(String host) 
	{
		this.host = host;
	}
}
