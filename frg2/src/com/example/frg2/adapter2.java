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
	private int start, end;
	private int[] columns;
	
	public adapter2(Context context, ArrayList<struct2> arrays, int[] columns) 
	{
		super(context, R.layout.rows, arrays);
		this.context = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.columns = columns;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		struct2 item = getItem(position);
		convertView = inflater.inflate(R.layout.rows, null);
		
		LinearLayout linearlayout = (LinearLayout) convertView.findViewById(R.id.lstLinear);
		Object[] m = item.getItemsArray();
		
		for(int i=0 ; i<columns.length ; i++)
		{
			TextView txt = new TextView(context);
			txt.setText(m[columns[i]]+"");
			linearlayout.addView(txt);
		}
				
		convertView.setId((Integer) m[0]);
		
		return convertView;
	}
}
