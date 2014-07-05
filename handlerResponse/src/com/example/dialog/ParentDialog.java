package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ParentDialog extends Dialog
{
	Activity ActivityContext;
	int Dialog_Layout;

    public ParentDialog(Activity context) 
    {
        super(context);
        ActivityContext = context;
    }
    
    public ParentDialog(Activity context,int DialogStyle,int Dialog_Layout) 
    {
        super(context,DialogStyle);
        ActivityContext = context;
        this.Dialog_Layout = Dialog_Layout;
    }
  
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        setDialogDimensions();

 		this.setContentView(Dialog_Layout);
    }
    
    protected void setDialogDimensions()
    {
    	// retrieve display dimensions
 		Rect displayRectangle = new Rect();
 		Window window = ActivityContext.getWindow();
 		window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

 		// inflate and adjust layout
 		LayoutInflater inflater = (LayoutInflater)ActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 		View layout = inflater.inflate(Dialog_Layout, null);
 		
 		if(G.isTablet(ActivityContext))
 		{
 			layout.setMinimumWidth((int)(displayRectangle.width() * 2));
 			layout.setMinimumHeight((int)(displayRectangle.height() *  2));
 		}
 		else
 		{
 			layout.setMinimumWidth((int)(displayRectangle.width() * 1.5));
 			layout.setMinimumHeight((int)(displayRectangle.height() *  1.5));
 		}
 		
 		WindowManager.LayoutParams params = new WindowManager.LayoutParams();
 		params.gravity = Gravity.CENTER; 
 		this.getWindow().setAttributes(params);
    }


}

