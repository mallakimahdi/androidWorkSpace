package com.example.frg2;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity 
{
	ListView lst;
	Button btnBack ,btnNext;
	adapter2 adapter;
	ArrayList<struct2> arrays;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnBack = (Button) findViewById(R.id.btnBack);
		btnNext = (Button) findViewById(R.id.btnNext);
		
		arrays = new ArrayList<struct2>();
		for(int i = 0; i<100 ; i++)
		{
			struct2 stru = new struct2();
			stru.setId(i);
			stru.setName("name"+i);
			
			arrays.add(stru);
		}

		WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		int width = display.getWidth();
		int count = width/70;
		int columns[] = {0,1};
		for(int i=0 ; i < count ; i++)
		{
			
		}
		
		adapter = new adapter2(this, arrays, columns);
		lst = (ListView) findViewById(R.id.lst);
		lst.setAdapter(adapter);
		
		btnBack.setOnClickListener(clickBack);
		btnNext.setOnClickListener(clickNext);
	}

	OnClickListener clickBack = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			
		}
	};
	OnClickListener clickNext = new OnClickListener() 
	{
		@Override
		public void onClick(View v) 
		{
			lst.setAdapter(adapter);
		}
	};
}
