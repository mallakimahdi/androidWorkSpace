package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity 
{
	Button btnShowDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnShowDialog = (Button) findViewById(R.id.button);
		
		G.isTablet(this);
		
		btnShowDialog.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				myDialog mydialog = new myDialog(MainActivity.this);
				mydialog.show();
			}
		});
		//Handler handler = new Handler();
		myHandler handler = new myHandler(getMainLooper())
		{
			@Override
			public void handleMessage(Message msg) 
			{
				btnShowDialog.setText((String)msg.obj+"");
			}
		};
		
		Messenger msg = new Messenger(handler);
		Intent i = new Intent(this, myService.class);
		i.putExtra("messenger", msg);
		
		startService(i);
	}
	
	
}