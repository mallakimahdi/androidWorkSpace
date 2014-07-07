package com.example.list_customers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class MainActivity extends Activity 
{
	public FragmentManager fm;
	public FragmentTransaction ft;
	private frg_right fragmentRight;
	private frg_left fragmentLeft;
	public OnArticleSelectedListener mListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fm = getFragmentManager();
		ft = fm.beginTransaction();
		
		if(baseApplication.isTablet)
		{
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
			
			fragmentRight = new frg_right();
			//fragmentLeft = new frg_left();
			
			ft.add(R.id.fragment_right, fragmentRight, "frag_right");
			//ft.add(R.id.fragment_left, fragmentLeft, "frag_left");
			ft.commit();
		}
		else
		{
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
			
			fragmentRight = new frg_right();
			ft.add(R.id.container, fragmentRight, "frag_right");
			ft.commit();
		}
		
		mListener = new OnArticleSelectedListener() 
		{
			@Override
			public void onReceived(Object data) 
			{
				fragmentLeft = (frg_left) fm.findFragmentByTag("frag_left");
				
				if(fragmentLeft == null)
					fragmentLeft = new frg_left();
				
				fragmentLeft.send(data);
			}
		};
	}
}