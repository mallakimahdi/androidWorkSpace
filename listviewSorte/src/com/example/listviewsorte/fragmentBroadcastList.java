package com.example.listviewsorte;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;

public class fragmentBroadcastList extends ListFragment 
{
	Cursor cursor;
	simpleAdapterBroadcastLog adapter;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		
		adapter = new simpleAdapterBroadcastLog(getActivity().getBaseContext(), , c, from, to)
	}
}
