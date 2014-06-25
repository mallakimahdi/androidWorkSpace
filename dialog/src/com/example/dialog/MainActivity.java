package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
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
		
	}
}