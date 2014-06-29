package databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class dbHelperTrackingLog 
{
	private DatabaseTrackingLog db;
	private SQLiteDatabase database;
	
	public dbHelperTrackingLog(Context context) 
	{
		this.db = new DatabaseTrackingLog(context);
	}
	
	public SQLiteDatabase open()
	{
		this.database = db.getWritableDatabase();
		return this.database;
	}
	
	public Cursor getAllTrackingLog()
	{
		return database.query("TrackingLog", null, null, null, null, null, null);
	}
	
	public void close()
	{
		db.close();
	}
	
	public Cursor sortById(boolean asc)
	{
		String order;
		
		if(asc)
			order = "_id";
		else
			order = "_id DESC";
		
		return database.query("TrackingLog", null, null, null, null, null, order);
	}
	
	public Cursor sortByDate(boolean asc)
	{
		String order;
		
		if(asc)
			order = "date";
		else
			order = "date DESC";
		
		return database.query("TrackingLog", null, null, null, null, null, order);
	}
}
