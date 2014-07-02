package com.example.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;
import org.apache.http.HttpConnection;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.os.Environment;

public class mysender implements ReportSender
{
	HttpClient httpclient;
	List<NameValuePair> params;
	HttpPost httpPost;
	
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
	}
	
}
