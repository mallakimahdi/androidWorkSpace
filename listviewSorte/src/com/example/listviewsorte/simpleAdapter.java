package com.example.listviewsorte;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class simpleAdapter extends SimpleCursorAdapter 
{
	private Cursor c;
	private LayoutInflater inflater;
	
	public simpleAdapter(Context context, int layout, Cursor c, String[] from, int[] to) 
	{
		super(context, layout, c, from, to, 0);
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
			convertview = inflater.inflate(R.layout.row_trackinglog_list, null);
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
			TextView txtId = (TextView) view.findViewById(R.id.txtId);
			TextView txtVisitLat = (TextView) view.findViewById(R.id.txtVisitLat);
			TextView txtVisitLong = (TextView) view.findViewById(R.id.txtVisitLong);
			TextView txtIsSend = (TextView) view.findViewById(R.id.txtIsSend);
			TextView txtIsMasfa = (TextView) view.findViewById(R.id.txtIsMasfa);
			TextView txtDate = (TextView) view.findViewById(R.id.txtDate);
			TextView txtIsVisitLoc = (TextView) view.findViewById(R.id.txtIsVisitLoc);
			TextView txtIsValid = (TextView) view.findViewById(R.id.txtIsValid);
			TextView txtGpsDate = (TextView) view.findViewById(R.id.txtGpsDate);
			TextView txtUrl = (TextView) view.findViewById(R.id.txtUrl);
			
			if(parentApp.isTablet)
			{
				txtId.setText(c.getInt(c.getColumnIndex("_id"))+"");
				txtVisitLat.setText(c.getDouble(c.getColumnIndex("VisitLat"))+"");
				txtVisitLong.setText(c.getDouble(c.getColumnIndex("VisitLong"))+"");
				txtIsSend.setText(c.getInt(c.getColumnIndex("IsSend"))+"");
				txtIsMasfa.setText(c.getInt(c.getColumnIndex("IsMasfa"))+"");
				txtDate.setText(c.getInt(c.getColumnIndex("date"))+"");
				txtIsVisitLoc.setText(c.getInt(c.getColumnIndex("IsVisitLoc"))+"");
				txtIsValid.setText(c.getInt(c.getColumnIndex("IsValid"))+"");
				txtGpsDate.setText(c.getInt(c.getColumnIndex("GpsDate"))+"");
				txtUrl.setText(c.getInt(c.getColumnIndex("Url"))+"");
			}
			else
			{
				txtId.setText("id: "+c.getInt(c.getColumnIndex("_id"))+"");
				txtVisitLat.setText("visit Lat: "+c.getDouble(c.getColumnIndex("VisitLat"))+"");
				txtVisitLong.setText("visit Long: "+c.getDouble(c.getColumnIndex("VisitLong"))+"");
				txtIsSend.setText("is send: "+c.getInt(c.getColumnIndex("IsSend"))+"");
				txtIsMasfa.setText("is masfa: "+c.getInt(c.getColumnIndex("IsMasfa"))+"");
				txtDate.setText("date: "+ c.getInt(c.getColumnIndex("date"))+"");
				txtIsVisitLoc.setText("is visit loc: "+c.getInt(c.getColumnIndex("IsVisitLoc"))+"");
				txtIsValid.setText("is valid"+ c.getInt(c.getColumnIndex("IsValid"))+"");
				txtGpsDate.setText("gps date"+c.getInt(c.getColumnIndex("GpsDate"))+"");
				txtUrl.setText("url: "+c.getInt(c.getColumnIndex("Url"))+"");
			}
			
		}
	}
	
	
}
