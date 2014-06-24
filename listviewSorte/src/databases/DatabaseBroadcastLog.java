package databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseBroadcastLog extends SQLiteOpenHelper 
{

	public DatabaseBroadcastLog(Context context) 
	{
		super(context, "BroadcastLog.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL("create table BroadcastLog(_id INTEGER PRIMARY KEY, " +
				"BroadcastType INTEGER, BroadcastText TEXT, " +
				"Date INTEGER, Description TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		
	}
	
}
