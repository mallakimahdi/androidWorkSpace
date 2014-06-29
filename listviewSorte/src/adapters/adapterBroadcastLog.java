package adapters;

import com.example.listviewsorte.R;
import com.example.listviewsorte.baseApplication;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class adapterBroadcastLog extends SimpleCursorAdapter 
{
	private Cursor cursor;
	private LayoutInflater inflater;
	public static Context context;

	public adapterBroadcastLog(Context context, int layout, Cursor cursor, String[] from, int[] to) 
	{
		super(context, layout, cursor, from, to, 1);
		this.cursor = cursor;
		cursor.moveToFirst();
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public Cursor swapCursor(Cursor c1) 
	{
		super.swapCursor(c1);
		this.cursor = c1;
		notifyDataSetChanged();
		
		return cursor;
	}
	
	@Override
	public View getView(int position, View convertview, ViewGroup arg2) 
	{
		ViewHolder holder;
		cursor.moveToPosition(position);
		
		if(convertview == null)
		{
			convertview = inflater.inflate(R.layout.row_broadcastlog_list, null);
			holder = new ViewHolder();
			
			holder.tvId = (TextView) convertview.findViewById(R.id.tvIdBroadcastLog);
			holder.tvBroadcastType = (TextView) convertview.findViewById(R.id.tvBroadcastType);
			holder.tvBroadcastText = (TextView) convertview.findViewById(R.id.tvBroadcastText);
			holder.tvDateBroadcastLog = (TextView) convertview.findViewById(R.id.tvDateBroadcastLog);
			holder.tvDescripotion = (TextView) convertview.findViewById(R.id.tvDescriptionBroadcastLog);
			
			convertview.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertview.getTag();
		}
		
		holder.fill(cursor, convertview);
		
		return convertview;
	}
	
	static class ViewHolder
	{
		public TextView tvId, tvBroadcastType, tvBroadcastText, 
						tvDateBroadcastLog, tvDescripotion;
		
		public void fill(Cursor c, View view)
		{
			if(baseApplication.isTablet)
			{
				tvId.setText(c.getInt(c.getColumnIndex("_id"))+"");
				tvBroadcastType.setText(c.getDouble(c.getColumnIndex("BroadcastType"))+"");
				tvBroadcastText.setText(c.getString(c.getColumnIndex("BroadcastText")));
				tvDateBroadcastLog.setText(c.getString(c.getColumnIndex("Date")));
				tvDescripotion.setText(c.getString(c.getColumnIndex("Description")));
			}
			else
			{
				tvId.setText("id: "+c.getInt(c.getColumnIndex("_id")));
				tvBroadcastType.setText("type: "+c.getDouble(c.getColumnIndex("BroadcastType"))+"");
				tvBroadcastText.setText("text: "+c.getString(c.getColumnIndex("BroadcastText")));
				tvDateBroadcastLog.setText("date: "+c.getString(c.getColumnIndex("Date")));
				tvDescripotion.setText("description: "+c.getString(c.getColumnIndex("Description")));
			}
		}
	}
}
