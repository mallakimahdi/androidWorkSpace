package com.example.servicebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver 
{
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		Toast.makeText(parentApp.context, "broadcast received an intent", Toast.LENGTH_SHORT).show();
		
		int receivedWork = intent.getExtras().getInt("act");
		
		if(receivedWork == 1)
		{
			Intent i = new Intent(context, Service2.class);
			context.startService(i);
		}
		else if(receivedWork == 0)
		{
			Intent i = new Intent(context, Service2.class);
			context.stopService(i);
		}
	}
	
}
