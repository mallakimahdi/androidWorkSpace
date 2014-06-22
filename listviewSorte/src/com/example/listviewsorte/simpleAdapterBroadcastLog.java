package com.example.listviewsorte;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class simpleAdapterBroadcastLog extends simpleAdapter 
{
	private Cursor c;
	private LayoutInflater inflater;

	public simpleAdapterBroadcastLog(Context context, int layout, Cursor c, String[] from, int[] to) 
	{
		super(context, layout, c, from, to);
		this.c = c;
		c.moveToFirst();
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public Cursor swapCursor(Cursor c1) 
	{
		super.swapCursor(c1);
		this.c = c1;
		notifyDataSetChanged();
		
		return c;
	}
	
	@Override
	public View getView(int position, View convertview, ViewGroup arg2) 
	{
		ViewHolder holder;
		c.moveToPosition(position);
		
		if(convertview == null)
		{
			convertview = inflater.inflate(R.layout.row_broadcastlog_list, null);
			holder = new ViewHolder();
			convertview.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertview.getTag();
		}
		holder.fill(c, convertview);
		
		return convertview;
	}
	
	static class ViewHolder
	{
		public void fill(Cursor c, View view)
		{
			TextView txtId = (TextView) view.findViewById(R.id.columnIdBroadcastLog);
			
			if(parentApp.isTablet)
			{
				txtId.setText(c.getInt(c.getColumnIndex("_id")));
			}
			else
			{
				txtId.setText("id: "+c.getInt(c.getColumnIndex("_id")));
			}
		}
	}
}
