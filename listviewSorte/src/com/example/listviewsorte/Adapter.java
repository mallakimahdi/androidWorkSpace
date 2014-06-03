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
	LayoutInflater inflater;
	
	public Adapter(Context context, ArrayList<struct> arrays) 
	{
		super(context, R.layout.row, arrays);
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		struct item = getItem(position);
		
		convertView = inflater.inflate(R.layout.row, null);
		
		LinearLayout linearRow = (LinearLayout) convertView.findViewById(R.id.linearRow);
		
		if(position % 2 == 0)
			linearRow.setBackgroundColor(Color.WHITE);
		else
			linearRow.setBackgroundColor(Color.parseColor("#E8E8E8"));
		
		TextView txtId = (TextView) convertView.findViewById(R.id.txtId);
		TextView txtVisitLat = (TextView) convertView.findViewById(R.id.txtVisitLat);
		TextView txtVisitLong = (TextView) convertView.findViewById(R.id.txtVisitLong);
		TextView txtIsSend = (TextView) convertView.findViewById(R.id.txtisSend);
		TextView txtIsMasfa = (TextView) convertView.findViewById(R.id.txtCalender);
		
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
}
