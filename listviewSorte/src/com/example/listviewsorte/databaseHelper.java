package com.example.listviewsorte;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class databaseHelper 
{
	Database db;
	SQLiteDatabase database;
	
	public databaseHelper(Database db) 
	{
		this.db = db;
	}
	
	public SQLiteDatabase open()
	{
		this.database = db.getWritableDatabase();
		return this.database;
	}
	
	public Cursor getAllDetaisl()
	{
		return database.rawQuery("select * from ", null);
	}
	
	
	public void close()
	{
		db.close();
	}
}
