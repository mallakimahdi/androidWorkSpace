import java.util.Random;


public class consumer implements Runnable 
{
	
	Buffer buffer;
	private static Random random = new Random();
	
	public consumer(Buffer buffer) 
	{
		this.buffer = buffer;
	}

	@Override
	public void run() 
	{
		for(int i=0 ; i<=10 ; i++)
		{
			try {
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffer.get();
		}
	}

}
