package com.example.action;

import java.util.regex.Pattern;

import com.actionbarsherlock.app.SherlockActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends SherlockActivity
{
	EditText edt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Pattern CODE_PATTERN = Pattern.compile("([0-9]{0,4})|([0-9]{4}-)+|([0-9]{4}-[0-9]{0,4})+");
		edt = (EditText) findViewById(R.id.edt);
		
		edt.addTextChangedListener(new TextWatcher() 
		{
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) 
			{
				
			}
			
			private String formatNumbersAsCode(String input) 
			{
				int groupDigits = 0;
				String tmp = "";
				
				for(int i=0; i<input.length(); i++)
				{
					tmp += input.charAt(i);
					++groupDigits;
					if(groupDigits == 4)
					{
						tmp += "-";
						groupDigits = 0;
					}
				}
				return tmp;
			}

			private String keepNumberOnly(String input) 
			{
				return input.toString().replaceAll("[^0-9]", "");
			}

			@Override
			public void afterTextChanged(Editable s) 
			{
				Log.w("", "input"+s.toString());
				
				if(s.length() > 0 && !CODE_PATTERN.matcher(s).matches())
				{
					String input = s.toString();
					String numbersOnly = keepNumberOnly(input);
					String code = formatNumbersAsCode(numbersOnly);
					
					Log.w("", "numbersOnly : "+numbersOnly);
					Log.w("", "code : "+ code);
					
					edt.removeTextChangedListener(this);
					edt.setText(code);
					edt.setSelection(code.length());
					edt.addTextChangedListener(this);
				}
			}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) 
			{
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) 
	{
		/*
		View cView = getLayoutInflater().inflate(R.layout.c_view, null);
		com.actionbarsherlock.app.ActionBar actionbar = getSupportActionBar();
		actionbar.setCustomView(cView);
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		
		ImageView actionBarLogo = (ImageView) cView.findViewById(R.id.btnSearch);
		actionBarLogo.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "button clicked", Toast.LENGTH_SHORT).show();
			}
		});
		*/
		return true;
	}
	
}
