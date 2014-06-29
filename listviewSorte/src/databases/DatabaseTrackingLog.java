package databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseTrackingLog extends SQLiteOpenHelper
{
	public DatabaseTrackingLog(Context context) 
	{
		super(context, "TrackingLog.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		
		db.execSQL("create table if not exists TrackingLog (_id INTEGER PRIMARY KEY, VisitLat INTEGER, VisitLong INTEGER," +
				" IsSend INTEGER, IsMasfa INTEGER, date TEXT, IsVisitLoc INTEGER, IsValid INTEGER, " +
				"GpsDate TEXT, Url TEXT)");
		db.execSQL("insert into TrackingLog(_id) values(1)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		
	}
}