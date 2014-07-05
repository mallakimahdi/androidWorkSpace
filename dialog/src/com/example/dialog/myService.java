package com.example.dialog;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class myService extends IntentService 
{

	public myService() 
	{
		super("hello");
	}

	@Override
	protected void onHandleIntent(Intent intent) 
	{
		Messenger m = intent.getParcelableExtra("messenger");
		
		Message msg = new Message();
		msg.obj = "mahdi";
		
		try 
		{
			m.send(msg);
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
	}

	
}
