package com.example.listviewsorte;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<struct>
{
	private LayoutInflater inflater;
	private Context context;
	
	public Adapter(int row, Context context, ArrayList<struct> arrays)
	{
		super(context, row, arrays);
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		struct item = getItem(position);
		
		convertView = inflater.inflate(R.layout.row_trackinglog_list, null);
		
		TextView txtId = (TextView) convertView.findViewById(R.id.txtId);
		TextView txtVisitLat = (TextView) convertView.findViewById(R.id.txtVisitLat);
		TextView txtVisitLong = (TextView) convertView.findViewById(R.id.txtVisitLong);
		TextView txtIsSend = (TextView) convertView.findViewById(R.id.txtIsSend);
		TextView txtIsMasfa = (TextView) convertView.findViewById(R.id.txtIsMasfa);
		
		txtId.append(item.getId()+"");
		
		
		
		return convertView;
		
		/*
		if(parentApp.isTablet)
		{
			convertView = inflater.inflate(R.layout.row_trackinglog_list, null);
			LinearLayout linearRow = (LinearLayout) convertView.findViewById(R.id.linearRow);
			
			if(position % 2 == 0)
				linearRow.setBackgroundColor(Color.WHITE);
			else
				linearRow.setBackgroundColor(Color.parseColor("#E8E8E8"));
			
			TextView txtId = (TextView) convertView.findViewById(R.id.txtId);
			TextView txtVisitLat = (TextView) convertView.findViewById(R.id.txtVisitLat);
			TextView txtVisitLong = (TextView) convertView.findViewById(R.id.txtVisitLong);
			TextView txtIsSend = (TextView) convertView.findViewById(R.id.txtIsSend);
			TextView txtIsMasfa = (TextView) convertView.findViewById(R.id.txtIsMasfa);
			
			int mount = item.getGc().get(GregorianCalendar.MONTH);
			int day = item.getGc().get(GregorianCalendar.DAY_OF_MONTH);
			
			txtId.setText(item.getId()+"");
			txtVisitLat.setText(item.getVisitLat()+"");
			txtVisitLong.setText(item.getVisitLong()+"");
			txtIsSend.setText(item.isSend()+"");
			txtIsMasfa.setText(item.getGc().get(GregorianCalendar.YEAR) + " - "
								+ ((mount < 10) ? "0" : "") + mount + " - "
								+ ((day < 10) ? "0" : "") + day);
			
			return convertView;
		}
		else
		{
			convertView = inflater.inflate(R.layout.row_trackinglog_list, null);
			LinearLayout linearRowMob = (LinearLayout) convertView.findViewById(R.id.LinearRoot);
			
			TextView txt = (TextView) convertView.findViewById(R.id.txtRowMob);
			txt.setText("");

			txt.append("id: "+getStr(item.getId().toString(), 5));
			txt.append("latitude: "+getStr(item.getVisitLat().toString(), 8));
			txt.append("longtitude: "+getStr(item.getVisitLong().toString(), 8));
			txt.append("is Send? "+getStr(item.getIsSend().toString(), 2));
			
			return convertView;
		}
		*/
	}
	
	private String getStr(String str, int length)
	{
		StringBuilder builder = new StringBuilder();
		int count = 0;
		for(int i=0 ; i<length ; i++)
		{
			if(count < str.length())
				builder.append(Character.toString(str.charAt(i)));
			else
				builder.append("  ");
			count++;
		}
		
		return builder.toString();
	}
}