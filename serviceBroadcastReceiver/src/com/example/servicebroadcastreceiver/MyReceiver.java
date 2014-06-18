package com.example.servicebroadcastreceiver;

import java.util.Timer;
import java.util.TimerTask;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver 
{
	private static Timer timer;
	private int counter = 0;
	private Context context;
	
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		timer = new Timer();
		this.context = context;
		
		Toast.makeText(parentApp.context, "broadcast received an intent", Toast.LENGTH_SHORT).show();
		
		int receivedWork = intent.getExtras().getInt("act");
		
		switch(receivedWork)
		{
		case 1:
			Intent i1 = new Intent(context, Service2.class);
			context.startService(i1);
			doSomethingRepeatedly(context);
			break;
			
		case 0:
			Intent i2 = new Intent(context, Service2.class);
			context.stopService(i2);
			if(timer != null)
			{
				timer.cancel();
				taskTo.cancel();
				timer = null;
				taskTo = null;
			}
				
			break;
		}
	}
	
	TimerTask taskTo = new TimerTask() 
	{
		
		@Override
		public void run() 
		{
			try 
			{
				updateUI.sendEmptyMessage(0);
			} 
			catch (Exception e) 
			{
				e.printStackTrace(); 
			}
		}
		
		private Handler updateUI = new Handler()
		{
			@Override
			public void dispatchMessage(Message msg) 
			{
			    super.dispatchMessage(msg);
			    Toast.makeText(context, ++counter +"", Toast.LENGTH_SHORT).show();
			}
		};
	};
	
	public void doSomethingRepeatedly(final Context context) 
	{
		timer.scheduleAtFixedRate(taskTo, 0, 4 * 1000);
	}
	
	
}
