package com.example.servicebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver 
{
	private int counter = 0;
	private Context context;
	private Handler handler;
	private static boolean isCanceld;
	
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		this.context = context;
		handler = new Handler();
		
 		Toast.makeText(parentApp.context, "broadcast received an intent", Toast.LENGTH_SHORT).show();
		
		int receivedWork = intent.getExtras().getInt("act");
		
		switch(receivedWork)
		{
		case 1:
			Intent i1 = new Intent(context, Service2.class);
			context.startService(i1);
			isCanceld = false;
			doSomethingRepeatedly(context);
			break;
			
		case 0:
			Intent i2 = new Intent(context, Service2.class);
			context.stopService(i2);
			isCanceld = true;
			break;
		}
	}
	
	public void doSomethingRepeatedly(final Context context) 
	{
		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				while(true)
				{
					if(!isCanceld)
					{
						
						try 
						{
							handler.post(new Runnable() 
							{
								@Override
								public void run() 
								{
									Toast.makeText(context, ++counter +"", Toast.LENGTH_SHORT).show();
								}
							});
							
							Thread.sleep(4000);
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
						catch (Exception e2) 
						{
							e2.printStackTrace();
						}
					}
					else
					{
						break;
					}
				}
			}
		}).start();
	}
	
	
}
