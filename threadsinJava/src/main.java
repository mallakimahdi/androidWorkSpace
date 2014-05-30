import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class main 
{
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Buffer syncronizedBuffer = new syncronizedBuffer();
		
		consumer co = new consumer(syncronizedBuffer);
		producer pro = new producer(syncronizedBuffer);
		
		executor.execute(co);
		executor.execute(pro);
		
		executor.shutdown();
	}
}
