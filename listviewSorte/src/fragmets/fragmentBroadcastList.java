package fragmets;

import com.example.listviewsorte.R;
import com.example.listviewsorte.getObjects;
import com.tjerkw.slideexpandable.library.SlideExpandableListAdapter;

import adapters.adapterBroadcastLog;
import android.app.ListFragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragmentBroadcastList extends ListFragment 
{
	public Cursor cursor;
	public adapterBroadcastLog adapter;
	private Context mContext;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		mContext = getActivity().getApplicationContext();
		
		cursor = getObjects.getHelperDBBroadcastlog(mContext).getAllBroadcastLog();
		
		adapter = new adapterBroadcastLog(getActivity(),R.layout.row_broadcastlog_list 
										, cursor
										, new String[] {"_id"}
										, new int[] {R.id.txtIdBroadcastLog});
		//setListAdapter(adapter);
		
		setListAdapter(new SlideExpandableListAdapter(adapter, R.id.liRow, R.id.expandable));
		
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
