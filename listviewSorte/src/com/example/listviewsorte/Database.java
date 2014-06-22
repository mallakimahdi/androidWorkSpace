package com.example.listviewsorte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper
{
	public Database(Context context) 
	{
		super(context, "TrackingLog.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL("create table TrackingLog (_id INTEGER PRIMARY KEY, VisitLat INTEGER, VisitLong INTEGER," +
				" IsSend INTEGER, IsMasfa INTEGER, date TEXT, IsVisitLoc INTEGER, IsValid INTEGER, " +
				"GpsDate TEXT, Url TEXT)");
		db.execSQL("insert into TrackingLog(_id) values(1),(2),(3),(4)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		
	}
}