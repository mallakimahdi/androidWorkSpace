package com.example.servicebroadcastreceiver;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class Service1 extends Service 
{
	public boolean cancel;
	
	@Override
	public IBinder onBind(Intent intent) 
	{
		return null;
	}
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		
		Calendar calenderStartService = Calendar.getInstance();
		calenderStartService.setTimeInMillis(System.currentTimeMillis());
		calenderStartService.set(Calendar.HOUR_OF_DAY, 17);
		calenderStartService.set(Calendar.MINUTE, 04);
		calenderStartService.set(Calendar.SECOND, 00);
		
		Calendar calenderStopService = Calendar.getInstance();
		calenderStopService.setTimeInMillis(System.currentTimeMillis());
		calenderStopService.set(Calendar.HOUR_OF_DAY, 17);
		calenderStopService.set(Calendar.MINUTE, 05);
		calenderStopService.set(Calendar.SECOND, 00);
		
		Intent intentStart = new Intent(this, MyReceiver.class);
		intentStart.putExtra("act", 1);
		PendingIntent piStart = PendingIntent.getBroadcast(getBaseContext(), 1000, intentStart, PendingIntent.FLAG_ONE_SHOT);
		
		Intent intentStop = new Intent(this, MyReceiver.class);
		intentStop.putExtra("act", 0);
		PendingIntent piStop = PendingIntent.getBroadcast(getBaseContext(), 1001, intentStop, PendingIntent.FLAG_ONE_SHOT);
		
		//alarm manager for manage
		AlarmManager am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
		
		//for start and stop Service2 ** this work Control in MyReceiver.class file by value 1 & 2
		am.setRepeating(AlarmManager.RTC_WAKEUP, calenderStartService.getTimeInMillis(), AlarmManager.INTERVAL_DAY, piStart);
		am.setRepeating(AlarmManager.RTC_WAKEUP, calenderStopService.getTimeInMillis(), AlarmManager.INTERVAL_DAY, piStop);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) 
	{
		Toast.makeText(getBaseContext(), "service 1 started", Toast.LENGTH_SHORT).show();
		
		Notification notification = new Notification(R.drawable.ic_launcher, "myapp", System.currentTimeMillis());
		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(this, "service", "service is running" ,pendingIntent);
		
		startForeground(5481, notification);
		
		return START_STICKY;
	}
	
	Runnable run = new Runnable() 
	{
		@Override
		public void run() 
		{
			/*
			while(true)
			{
				sendToast("service1 is running");
				Log.i("run", "service1 is running");
				Intent i = new Intent();
				i.setAction("Custom_Intent");
				
				if(start)
				{
					i.putExtra("act", 1);
					sendBroadcast(i);
					sendToast("broadcast sended");
					start = false;
				}
				else
				{
					i.putExtra("act", 0);
					sendBroadcast(i);
					sendToast("broadcast sended");
					start = true;
				}
				
				
				try
				{
					Thread.sleep(10 * 1000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			*/
		}
	};
	
	private void sendToast(final String str)
	{
		parentApp.handler.post(new Runnable() 
		{
			@Override
			public void run() 
			{
				Toast.makeText(parentApp.context, str, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	/*
	@Override
	public void onDestroy() {
		if(timer != null)
		{
			timer.cancel();
		}
		super.onDestroy();
	}
	*/
}
