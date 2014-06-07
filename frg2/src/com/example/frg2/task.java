package com.example.frg2;

import java.net.URL;

import android.os.AsyncTask;

public class task extends AsyncTask<URL, Integer, Long> 
{

	@Override
	protected Long doInBackground(URL... urls) 
	{
		int count = urls.length;
		
		return null;
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) 
	{
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute(Long result) 
	{
		super.onPostExecute(result);
	}
	
	@Override
	protected void onCancelled() 
	{
		// TODO Auto-generated method stub
		super.onCancelled();
	}
}
