package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Window;

public class myDialog extends ParentDialog 
{
	public myDialog(Activity context) 
	{
		super(context);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		//setTitle("دریافت اطلاعات");
		
		final Window window = getWindow();
		boolean useTitleFeature = false;
		if(window.getContainer() == null)
			useTitleFeature = window.requestFeature(Window.FEATURE_CUSTOM_TITLE);
		
		setContentView(R.layout.dialog_view);
		
		if(useTitleFeature)
			window.setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
	}
}
