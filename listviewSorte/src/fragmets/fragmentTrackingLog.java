package fragmets;

import com.example.listviewsorte.R;
import com.example.listviewsorte.getObjects;
import adapters.adapterTrackingLog;
import android.app.ListFragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragmentTrackingLog extends ListFragment 
{
	public Cursor cursor;
	public adapterTrackingLog adapter;
	private Context mContext;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		mContext = getActivity().getApplicationContext();
		
		cursor = getObjects.getHelperDBTrakingLog(mContext).getAllTrackingLog();
		
		adapter = new adapterTrackingLog(getActivity().getBaseContext(), 
				R.layout.row_trackinglog_list , 
				cursor, 
				new String[]{"_id"}, 
				new int[]{R.id.tvId});
		
		
		setListAdapter(adapter);
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
