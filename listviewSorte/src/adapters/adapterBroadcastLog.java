package adapters;

import com.example.listviewsorte.R;
import com.example.listviewsorte.G;
import com.example.listviewsorte.R.id;
import com.example.listviewsorte.R.layout;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class adapterBroadcastLog extends adapterTrackingLog 
{
	private Cursor cursor;
	private LayoutInflater inflater;
	public static Context context;

	public adapterBroadcastLog(Context context, int layout, Cursor c, String[] from, int[] to) 
	{
		super(context, layout, c, from, to);
		this.cursor = c;
		c.moveToFirst();
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
		public void fill(Cursor c, View view)
		{
			TextView txtId = (TextView) view.findViewById(R.id.columnIdBroadcastLog);
			TextView txtBroadcastType = (TextView) view.findViewById(R.id.columnBroadcastType);
			TextView txtBroadcastText = (TextView) view.findViewById(R.id.columnBroadcastText);
			TextView txtDateBroadcastLog = (TextView) view.findViewById(R.id.columnDateBroadcastLog);
			TextView txtDescripotion = (TextView) view.findViewById(R.id.columnDescriptionBroadcastLog);
			
			
			if(G.isTablet)
			{
				txtId.setText(c.getInt(c.getColumnIndex("_id"))+"");
				txtBroadcastType.setText(c.getDouble(c.getColumnIndex("BroadcastType"))+"");
				txtBroadcastText.setText(c.getString(c.getColumnIndex("BroadcastText")));
				txtDateBroadcastLog.setText(c.getString(c.getColumnIndex("Date")));
				txtDescripotion.setText(c.getString(c.getColumnIndex("Description")));
			}
			else
			{
				txtId.setText("id: "+c.getInt(c.getColumnIndex("_id")));
				txtBroadcastType.setText("type: "+c.getDouble(c.getColumnIndex("BroadcastType"))+"");
				txtBroadcastText.setText("text: "+c.getString(c.getColumnIndex("BroadcastText")));
				txtDateBroadcastLog.setText("date: "+c.getString(c.getColumnIndex("Date")));
				txtDescripotion.setText("description: "+c.getString(c.getColumnIndex("Description")));
			}
		}
	}
}
