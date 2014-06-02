import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class client 
{
	public client() 
	{
		try 
		{
			Socket socketConnection = new Socket("127.0.0.1",3600);
			socketConnection.getInetAddress().getHostName();
			
			ObjectOutputStream outputstream = new ObjectOutputStream(socketConnection.getOutputStream());
			ObjectInputStream inputstream = new ObjectInputStream(socketConnection.getInputStream());
			
			outputstream.flush();
			
			outputstream.writeUTF("hello");
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
