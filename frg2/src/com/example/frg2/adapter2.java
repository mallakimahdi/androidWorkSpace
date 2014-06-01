package com.example.frg2;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class adapter2 extends ArrayAdapter<struct2> 
{
	Context context;
	LayoutInflater inflater;
	private int[] columns;
	
	public adapter2(Context context, ArrayList<struct2> arrays, int[] arrToAdapter) 
	{
		super(context, R.layout.rows, arrays);
		this.context = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.columns = arrToAdapter;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		struct2 item = getItem(position);
		convertView = inflater.inflate(R.layout.rows, null);
		
		LinearLayout linearlayout = (LinearLayout) convertView.findViewById(R.id.lstLinear);
		Object[] m = item.getItemsArray();
		convertView.setId((Integer) m[0]);
		
		for(int i=0 ; i<columns.length ; i++)
		{
			TextView txt = new TextView(context);
			txt.setText(m[columns[i]]+"");
			int width = 0;
			switch(columns[i])
			{
			case 0:
				width = 50;
				break;
			case 1:
				width = 120;
				break;
			}
			txt.setWidth(width);
			linearlayout.addView(txt);
		}
				
		
		
		return convertView;
	}
}
