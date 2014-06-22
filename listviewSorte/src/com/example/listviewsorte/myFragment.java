package com.example.listviewsorte;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;

public class myFragment extends ListFragment 
{
	Cursor cursor;
	simpleAdapter adapter;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		
		parentApp.dbHelper.open();
		cursor = parentApp.dbHelper.getAllDetails();
		
		adapter = new simpleAdapter(getActivity().getBaseContext(), 
				R.layout.row_trackinglog_list , 
				cursor, 
				new String[]{"_id"}, 
				new int[]{R.id.txtId});
		
		
		setListAdapter(adapter);
	}
}
