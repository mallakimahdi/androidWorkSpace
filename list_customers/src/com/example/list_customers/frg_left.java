package com.example.list_customers;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class frg_left extends Fragment 
{
	Button btn_left;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		return inflater.inflate(R.layout.layout_left,container ,false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		btn_left = (Button) getActivity().findViewById(R.id.btn_left);
		
		/*
		Button btn = (Button) getActivity().findViewById(R.id.btn_left);
		btn.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				frg_right fragment = (frg_right) ((MainActivity)getActivity()).fm.findFragmentByTag("frag_right");
				if(fragment == null)
					fragment = new frg_right();
				((MainActivity)getActivity()).ft = ((MainActivity)getActivity()).fm.beginTransaction();
				
				((MainActivity)getActivity()).ft.replace(R.id.container, fragment, "frag_right");
				((MainActivity)getActivity()).ft.addToBackStack(null);
				((MainActivity)getActivity()).ft.commit();
			}
		});
		*/
	}
	
	@Override
	public void onPause() 
	{
		super.onPause();
	}
	
	public void send(Object obj)
	{
		btn_left.setText(obj+"");
	}
}
