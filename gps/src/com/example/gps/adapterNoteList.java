package com.example.gps;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class adapterNoteList extends ArrayAdapter<structNoteList> 
{
	private LayoutInflater inflater;
	
	public adapterNoteList(Context context, List<structNoteList> array) 
	{
		super(context ,R.layout.row_list, array);
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	private static class viewHolder
	{
		TextView txt_Latitude, txt_Longitude, txt_time;
		
		public viewHolder(View v)
		{
			txt_Latitude = (TextView) v.findViewById(R.id.txt_Latitude);
			txt_Longitude = (TextView) v.findViewById(R.id.txt_Longitude);
			txt_time = (TextView) v.findViewById(R.id.txt_time);
		}
		public void fill(adapterNoteList adapterNoteList, structNoteList item, int position)
		{
			txt_Latitude.setText(item.getLatitude()+"");
			txt_Longitude.setText(item.getLongitude()+"");
			txt_time.setText(item.getTime()+"");
		}
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		viewHolder holder;
		structNoteList item = getItem(position);
		
		if(convertView == null)
		{
			convertView = inflater.inflate(R.layout.row_list, null);
			holder = new viewHolder(convertView);
			
			convertView.setTag(holder);
			convertView.setId(item.getId());
		}
		else
		{
			holder = (viewHolder) convertView.getTag();
			convertView.setId(item.getId());
		}
		
		holder.fill(this, item, position);
		return convertView;
	}
}
