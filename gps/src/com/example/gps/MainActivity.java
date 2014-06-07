package com.example.gps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity
{
	ListView lst_main;
	LocationManager locationmanager;
	ToggleButton btn_start;
	adapterNoteList adapter;
	ArrayList<structNoteList> items;
	Calendar calender;
	SimpleDateFormat sdf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lst_main = (ListView) findViewById(R.id.lst);
		btn_start = (ToggleButton) findViewById(R.id.toggleButton1);
		btn_start.setOnCheckedChangeListener(clickButton);
		
		calender = Calendar.getInstance();
		sdf = new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss ");
		
		items = new ArrayList<structNoteList>();
		
		adapter = new adapterNoteList(this, items);
		lst_main.setAdapter(adapter);
	}
	
	OnCheckedChangeListener clickButton = new OnCheckedChangeListener() 
	{
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
		{
			if(isChecked)
			{
				locationmanager = (LocationManager) MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
				locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, locationlistener);
				
				if(!locationmanager.isProviderEnabled(locationmanager.GPS_PROVIDER))
				{
					Toast.makeText(MainActivity.this, "please turn on gps", Toast.LENGTH_SHORT).show();
				}
			}
			else
			{
				locationmanager.removeUpdates(locationlistener);
			}
		}
	};
	
	LocationListener locationlistener = new LocationListener() 
	{
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) 
		{
			
		}
		
		@Override
		public void onProviderEnabled(String provider) 
		{
			
		}
		
		@Override
		public void onProviderDisabled(String provider) 
		{
			
		}
		
		@Override
		public void onLocationChanged(Location location) 
		{
			structNoteList item = new structNoteList();
			item.setLatitude(location.getLatitude());
			item.setLongitude(location.getLongitude());
			item.setTime(sdf.format(calender.getTime()));
			
			items.add(item);
			
			adapter.notifyDataSetChanged();
		}
	};
}
