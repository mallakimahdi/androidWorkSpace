package com.example.listviewsorte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper
{
	public Database(Context context) 
	{
		super(context, "db.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL("CREATE TABLE 'main'.'details' ('id' INTEGER NOT NULL,'visitLat' INTEGER," +
				"'visitLong' INTEGER,'isSend' INTEGER,'isMasfa' INTEGER);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		
	}
}
