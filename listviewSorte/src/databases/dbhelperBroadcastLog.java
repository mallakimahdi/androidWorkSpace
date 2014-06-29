package databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class dbhelperBroadcastLog 
{
	private DatabaseBroadcastLog db;
	private SQLiteDatabase database;
	
	public dbhelperBroadcastLog(Context context) 
	{
		this.db = new DatabaseBroadcastLog(context);
	}
	
	public SQLiteDatabase open()
	{
		this.database = db.getWritableDatabase();
		return this.database;
	}
	
	public Cursor getAllBroadcastLog()
	{
		return database.rawQuery("select * from BroadcastLog;", null);
	}
	
	public Cursor sortById(boolean asc)
	{
		String order;
		
		if(asc)
			order = "_id";
		else
			order = "_id DESC";
		
		return database.query("BroadcastLog", null, null, null, null, null, order); 
	}
	
	public Cursor sortByDate(boolean asc)
	{
		String order;
		
		if(asc)
			order = "Date";
		else
			order = "Date DESC";
		
		return database.query("BroadcastLog", null, null, null, null, null, order);
	}
	
	public void close()
	{
		this.db.close();
	}
}
