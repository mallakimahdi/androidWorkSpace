package com.example.report;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class mysender implements ReportSender
{
	private HttpClient httpclient;
	private List<NameValuePair> params;
	private HttpPost httpPost;
	
	@Override
	public void send(CrashReportData errorContent) throws ReportSenderException 
	{
		Set set = errorContent.keySet();
		Iterator iterator = set.iterator();
		
		try 
		{
			httpclient = new DefaultHttpClient();
			httpPost = new HttpPost("http://192.168.0.139/mysite/crash_reporter2.php");
			params = new ArrayList<NameValuePair>();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		while(iterator.hasNext())
		{
			Object str = (Object) iterator.next();
			params.add(new BasicNameValuePair(str.toString(), errorContent.get(str)));
		}
		
		params.add(new BasicNameValuePair("USER_NAME", "123456"));
		
		try
		{
			httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
			httpclient.execute(httpPost);
		} 
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("ANDROID_VERSION", "1");
			obj.put("APP_VERSION_CODE", "123");
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		StringWriter out = new StringWriter();
		String str = obj.toString();
		
		LinkedList<String> s;
		
		
		try 
		{
			HttpURLConnection con = (HttpURLConnection) new URL("http://192.168.0.72:90/acra").openConnection();
			con.setRequestMethod("POST");
			byte[] mybytes = str.getBytes();                                                                                                                                                                            
			con.connect();
			con.getOutputStream().write(mybytes);
			con.disconnect();
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
