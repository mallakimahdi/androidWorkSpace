package com.example.listviewsorte;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class databaseHelper 
{
	Database db;
	SQLiteDatabase database;
	
	public databaseHelper(Context context) 
	{
		this.db = new Database(context);
	}
	
	public SQLiteDatabase open()
	{
		this.database = db.getWritableDatabase();
		return this.database;
	}
	
	public Cursor getAllDetails()
	{
		return database.rawQuery("select * from TrackingLog", null);
	}
	
	
	public void close()
	{
		db.close();
	}
	
	public Cursor sortById(boolean asc)
	{
		String query;
		
		if(asc)
			query = "select * from TrackingLog ORDER BY _id";
		else
			query = "select * from TrackingLog ORDER BY _id DESC";
		
		return database.rawQuery(query, null);
	}
	
	public Cursor sortByDate(boolean asc)
	{
		return database.rawQuery("select * from TrackingLog ORDER BY date "+ asc != null ? "ASC" :"DESC", null);
	}
}
