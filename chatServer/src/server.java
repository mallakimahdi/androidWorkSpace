import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class server 
{
	ServerSocket serversocket;
	private ExecutorService runGame;
	private Lock gameLock;
	private Condition player1, player2;
	private Player[] player;
	private int currentPlayer;
	private final static int PLAYER_X = 0;
	private final static int PLAYER_Y = 1;
	private ServerSocket socket;
	private String[] board = new String[9];
	
	public server() 
	{
		runGame = Executors.newFixedThreadPool(2);
		gameLock = new ReentrantLock();
		
		player1 = gameLock.newCondition();
		player2 = gameLock.newCondition();
		gameLock.unlock();
		
		player = new Player[2];
		currentPlayer = PLAYER_X;
		
		try 
		{
			socket = new ServerSocket(12345, 2);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void execute()
	{
		for(int i=0 ; i<player.length ; i++)
		{
			try 
			{
				player[i] = new Player(socket.accept() , i);
				runGame.execute(player[i]);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		try
		{
			gameLock.lock();
			player[PLAYER_X].setSupspended(false);
			player2.signal();
		}
		finally
		{
			gameLock.unlock();
		}
	}
	
	public boolean isOccupied(int location)
	{
		if(board[location].equals("X") || board[location].equals("O"))
		{
			return true;
		}
		else
			return false;
	}
}
