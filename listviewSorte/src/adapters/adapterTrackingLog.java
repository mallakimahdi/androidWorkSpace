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

public class adapterTrackingLog extends SimpleCursorAdapter 
{
	private Cursor cursor;
	private LayoutInflater inflater;
	
	public adapterTrackingLog(Context context, int layout, Cursor cursor, String[] from, int[] to) 
	{
		super(context, layout, cursor, from, to, 0);
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
			convertview = inflater.inflate(R.layout.row_trackinglog_list, null);
			holder = new ViewHolder();
			
			holder.tvId = (TextView) convertview.findViewById(R.id.tvId);
			holder.tvVisitLat = (TextView) convertview.findViewById(R.id.tvVisitLat);
			holder.tvVisitLong = (TextView) convertview.findViewById(R.id.tvVisitLong);
			holder.tvIsSend = (TextView) convertview.findViewById(R.id.tvIsSend);
			holder.tvIsMasfa = (TextView) convertview.findViewById(R.id.tvIsMasfa);
			holder.tvDate = (TextView) convertview.findViewById(R.id.tvDate);
			holder.tvIsVisitLoc = (TextView) convertview.findViewById(R.id.tvIsVisitLoc);
			holder.tvIsValid = (TextView) convertview.findViewById(R.id.tvIsValid);
			holder.tvGpsDate = (TextView) convertview.findViewById(R.id.tvGpsDate);
			holder.tvUrl = (TextView) convertview.findViewById(R.id.tvUrl);
			
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
		public TextView tvId, tvVisitLat, tvVisitLong, tvIsSend, tvIsMasfa, 
						tvDate,tvIsVisitLoc, tvIsValid, tvGpsDate, tvUrl;
		
		public void fill(Cursor c, View view)
		{
			if(baseApplication.isTablet)
			{
				tvId.setText(c.getInt(c.getColumnIndex("_id"))+"");
				tvVisitLat.setText(c.getDouble(c.getColumnIndex("VisitLat"))+"");
				tvVisitLong.setText(c.getDouble(c.getColumnIndex("VisitLong"))+"");
				tvIsSend.setText(c.getInt(c.getColumnIndex("IsSend"))+"");
				tvIsMasfa.setText(c.getInt(c.getColumnIndex("IsMasfa"))+"");
				tvDate.setText(c.getInt(c.getColumnIndex("date"))+"");
				tvIsVisitLoc.setText(c.getInt(c.getColumnIndex("IsVisitLoc"))+"");
				tvIsValid.setText(c.getInt(c.getColumnIndex("IsValid"))+"");
				tvGpsDate.setText(c.getInt(c.getColumnIndex("GpsDate"))+"");
				tvUrl.setText(c.getInt(c.getColumnIndex("Url"))+"");
			}
			else
			{
				tvId.setText("id: "+c.getInt(c.getColumnIndex("_id"))+"");
				tvVisitLat.setText("visit Lat: "+c.getDouble(c.getColumnIndex("VisitLat"))+"");
				tvVisitLong.setText("visit Long: "+c.getDouble(c.getColumnIndex("VisitLong"))+"");
				tvIsSend.setText("is send: "+c.getInt(c.getColumnIndex("IsSend"))+"");
				tvIsMasfa.setText("is masfa: "+c.getInt(c.getColumnIndex("IsMasfa"))+"");
				tvDate.setText("date: "+ c.getInt(c.getColumnIndex("date"))+"");
				tvIsVisitLoc.setText("is visit loc: "+c.getInt(c.getColumnIndex("IsVisitLoc"))+"");
				tvIsValid.setText("is valid"+ c.getInt(c.getColumnIndex("IsValid"))+"");
				tvGpsDate.setText("gps date"+c.getInt(c.getColumnIndex("GpsDate"))+"");
				tvUrl.setText("url: "+c.getInt(c.getColumnIndex("Url"))+"");
			}
			
		}
	}
	
	
}
