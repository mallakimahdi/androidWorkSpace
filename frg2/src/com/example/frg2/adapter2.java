package com.example.frg2;

import java.util.ArrayList;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

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
				width = dipToPixels(context,80);
				break;
			case 1:
				width = dipToPixels(context,210);
				break;
			case 2:
				width = dipToPixels(context,230);
				break;
			case 3:
				width = dipToPixels(context,200);
				break;
			case 4:
				width = dipToPixels(context,250);
				break;
			}
			txt.setWidth(width);
			txt.setHeight(50);
			txt.setGravity(Gravity.CENTER);
			linearlayout.addView(txt);
		}
		
		return convertView;
	}
	
	public static int dipToPixels(Context context,float dipValue)
	{
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
	}
}
