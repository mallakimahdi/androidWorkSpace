package com.example.listviewsorte;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
		
		TextView txtId = (TextView) convertView.findViewById(R.id.txtId);
		TextView txtVisitLat = (TextView) convertView.findViewById(R.id.txtVisitLat);
		TextView txtVisitLong = (TextView) convertView.findViewById(R.id.txtVisitLong);
		TextView txtIsSend = (TextView) convertView.findViewById(R.id.txtisSend);
		TextView txtIsMasfa = (TextView) convertView.findViewById(R.id.txtisMasfa);
		
		txtId.setText(item.getId()+"");
		txtVisitLat.setText(item.getVisitLat()+"");
		txtVisitLong.setText(item.getVisitLong()+"");
		txtIsSend.setText(item.isSend()+"");
		txtIsMasfa.setText(item.isMasfa() ? "1" : "0");
		
		return convertView;
	}
	
}
