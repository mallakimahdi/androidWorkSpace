import java.net.Socket;

public class Player implements Runnable
{
	private Socket socket;
	private int playerNumber;
	
	
	public Player(Socket socket, int playerNumber) 
	{
		this.socket = socket;
		this.playerNumber = playerNumber;
	}

	@Override
	public void run()
	{
		
	}

	public void setSupspended(boolean b) 
	{
		
	}
	
}
