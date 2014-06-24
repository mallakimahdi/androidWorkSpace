package fragmets;

import com.example.listviewsorte.R;
import com.example.listviewsorte.G;
import com.example.listviewsorte.R.id;
import com.example.listviewsorte.R.layout;

import databases.dbHelperTrackingLog;
import databases.dbhelperBroadcastLog;
import adapters.adapterTrackingLog;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;

public class fragmentTrackingLog extends ListFragment 
{
	public Cursor cursor;
	public adapterTrackingLog adapter;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		
		G.dbHelper = new dbHelperTrackingLog(getActivity().getBaseContext());
		//databaseHelper d = new databaseHelper(getActivity().getBaseContext());
		G.dbHelper.open();
		cursor = G.dbHelper.getAllTrackingLog();
		
		adapter = new adapterTrackingLog(getActivity().getBaseContext(), 
				R.layout.row_trackinglog_list , 
				cursor, 
				new String[]{"_id"}, 
				new int[]{R.id.txtId});
		
		
		setListAdapter(adapter);
	}
}
