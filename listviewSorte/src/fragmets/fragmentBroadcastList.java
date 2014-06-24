package fragmets;

import com.example.listviewsorte.R;
import com.example.listviewsorte.G;
import com.example.listviewsorte.R.id;
import com.example.listviewsorte.R.layout;

import adapters.adapterBroadcastLog;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;

public class fragmentBroadcastList extends ListFragment 
{
	public Cursor cursor;
	public adapterBroadcastLog adapter;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		
		G.dbHelperBroadcastLog.open();
		cursor = G.dbHelperBroadcastLog.getAllBroadcastLog();
		
		adapter = new adapterBroadcastLog(getActivity().getBaseContext(),R.layout.row_broadcastlog_list 
										, cursor
										, new String[] {"_id"}
										, new int[] {R.id.txtIdBroadcastLog});
		setListAdapter(adapter);
	}
}
