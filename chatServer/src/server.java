import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class server 
{
	ServerSocket serversocket;
	
	public server() 
	{
		try 
		{
			serversocket = new ServerSocket(3600, 5);
			Socket socketconnection = serversocket.accept();
			
			ObjectInputStream inputstream = new ObjectInputStream(socketconnection.getInputStream());
			ObjectOutputStream outputstream = new ObjectOutputStream(socketconnection.getOutputStream());
			
			
			socketconnection.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
}
