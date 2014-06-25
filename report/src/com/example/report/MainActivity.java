package com.example.report;

import org.acra.ACRA;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	String string;
	TextView txt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ACRA.getErrorReporter().putCustomData("USER_NAME", "1234567");
		
		txt.setText(string);
	}
}