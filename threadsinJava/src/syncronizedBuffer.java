import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class syncronizedBuffer implements Buffer
{
	private final Lock accessLock = new ReentrantLock();
	private final Condition canWrite = accessLock.newCondition();
	private final Condition canRead = accessLock.newCondition();
	private ArrayBlockingQueue<Integer> buffer;
	private boolean occoupied = false;
	
	public syncronizedBuffer() 
	{
		buffer = new ArrayBlockingQueue<>(11);
	}

	@Override
	public void set(int value) 
	{
		accessLock.lock();
		
		try 
		{
			
			if(buffer.size() == 11)
			{
				System.out.println("producer waiting to put an item to array");
				canWrite.await();
			}
			
			buffer.put(value);
			System.out.println("writer writed: "+ value);
			
			canRead.signal();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			accessLock.unlock();
		}
	}

	@Override
	public int get() 
	{
		accessLock.lock();
		
		try 
		{
			if(buffer.isEmpty())
			{
				System.out.println("consumer waiting to take an item");
				canRead.await();
			}
			
			int itemTaked = buffer.take();
			System.out.println("item taked :"+itemTaked);
			
			canWrite.signal();
			
			return itemTaked;
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			accessLock.unlock();
		}
		
		return -1;
	}
}
