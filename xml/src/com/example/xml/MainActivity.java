package com.example.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	TextView txt;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		txt = (TextView) findViewById(R.id.txt);

		String path = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator + "example.xml";
		
		Serializer serializer = new Persister();
		List<Server> server = new ArrayList<Server>();
		int[] arrInt = new int[5];
		
		for(int i=0; i<5 ; i++)
		{
			Server se = new Server(i, "server"+i);
			arrInt[i] = i;
			server.add(se);
		}
		
		Struct struct = new Struct(1, "mahdi", server, arrInt);
		
		File outputToXML = new File(path);
		
		try
		{
			serializer.write(struct, outputToXML);
			Log.i("serialized", "successfully serialized");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		File input = new File(path);
		Struct struct2 = null;
		
		try 
		{
			struct2 = serializer.read(Struct.class, input);
			Log.i("deserialize", "successfully deserialized");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		List<Server> s = struct2.getSer();
		Server serv = s.get(3);
		
		txt.setText(serv.getHost()+"");
	}
}
