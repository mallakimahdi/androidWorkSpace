package com.example.servicebroadcastreceiver;

import java.util.Calendar;

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
import android.util.Log;
import android.widget.Toast;

public class Service1 extends Service 
{
	private boolean start = true;
	
	@Override
	public IBinder onBind(Intent intent) 
	{
		return null;
	}
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		
		Calendar calenderStart = Calendar.getInstance();
		calenderStart.setTimeInMillis(System.currentTimeMillis());
		calenderStart.set(Calendar.HOUR_OF_DAY, 10);
		calenderStart.set(Calendar.MINUTE, 43);
		calenderStart.set(Calendar.SECOND, 00);
		
		Calendar calenderStop = Calendar.getInstance();
		calenderStop.setTimeInMillis(System.currentTimeMillis());
		calenderStop.set(Calendar.HOUR_OF_DAY, 10);
		calenderStop.set(Calendar.MINUTE, 44);
		calenderStop.set(Calendar.SECOND, 00);
		
		Intent intentStart = new Intent();
		intentStart.setAction("Custom_Intent");
		intentStart.putExtra("act", 1);
		PendingIntent piStart = PendingIntent.getBroadcast(getBaseContext(), 12345, intentStart, PendingIntent.FLAG_UPDATE_CURRENT);
		
		Intent intentStop = new Intent();
		intentStop.setAction("Custom_Intent");
		intentStop.putExtra("act", 0);
		PendingIntent piStop = PendingIntent.getBroadcast(getBaseContext(), 12346, intentStop, PendingIntent.FLAG_UPDATE_CURRENT);
		
		AlarmManager am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
		am.setInexactRepeating(AlarmManager.RTC_WAKEUP, calenderStart.getTimeInMillis(), AlarmManager.INTERVAL_DAY, piStart);
		am.setInexactRepeating(AlarmManager.RTC_WAKEUP, calenderStop.getTimeInMillis(), AlarmManager.INTERVAL_DAY, piStop);
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
}
