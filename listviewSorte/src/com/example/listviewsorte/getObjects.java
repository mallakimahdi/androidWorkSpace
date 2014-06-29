package com.example.listviewsorte;

import android.content.Context;
import databases.dbHelperTrackingLog;
import databases.dbhelperBroadcastLog;

public class getObjects 
{
	private static dbHelperTrackingLog dbhelperTrakingLog;
	private static dbhelperBroadcastLog dbhelperBroadcastLog;

	public static dbHelperTrackingLog getHelperDBTrakingLog(Context context) 
	{
		if(dbhelperTrakingLog == null)
		{
			dbhelperTrakingLog = new dbHelperTrackingLog(context);
			dbhelperTrakingLog.open();
		}
		
		return dbhelperTrakingLog;
	}
	
	public static dbhelperBroadcastLog getHelperDBBroadcastlog(Context context)
	{
		if(dbhelperBroadcastLog == null)
		{
			dbhelperBroadcastLog = new dbhelperBroadcastLog(context);
			dbhelperBroadcastLog.open();
		}
		
		return dbhelperBroadcastLog;
	}
}
