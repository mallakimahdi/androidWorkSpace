package com.example.list_customers;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;

public class frg_right extends Fragment 
{
	private OnArticleSelectedListener mListener;
	private Button btn_right;
	
	@Override
	public void onAttach(Activity activity) 
	{
		super.onAttach(activity);
		try
		{
			mListener = ((MainActivity)activity).mListener;
		}
		catch(ClassCastException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		return inflater.inflate(R.layout.layout_right,container ,false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		
		btn_right = (Button) getActivity().findViewById(R.id.btn_right);
		btn_right.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				mListener.onReceived("mahdi");
				/*
				frg_left fragment = (frg_left) ((MainActivity)getActivity()).fm.findFragmentByTag("frag_left");
				if(fragment == null)
					fragment = new frg_left();
				((MainActivity)getActivity()).ft = ((MainActivity)getActivity()).fm.beginTransaction();
				
				((MainActivity)getActivity()).ft.replace(R.id.container, fragment, "frag_left");
				((MainActivity)getActivity()).ft.addToBackStack(null);
				((MainActivity)getActivity()).ft.commit();
				*/
			}
		});
	}
	
	@Override
	public void onPause() 
	{
		super.onPause();
	}
}
