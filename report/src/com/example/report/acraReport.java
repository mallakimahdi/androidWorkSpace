package com.example.report;

import org.acra.*;
import org.acra.annotation.*;
import android.app.Application;

@ReportsCrashes(
		formKey = "",
		formUri = "http://192.168.0.139/mysite/crash_reporter2.php",
		mode = ReportingInteractionMode.TOAST,
		resToastText = R.string.crash_report_message,
		logcatArguments = {"-t", "100", "-v", "long", "*:E"}
)

public class acraReport extends Application
{	
	@Override
	public void onCreate()
	{
		ACRA.init(this);
		ACRA.getErrorReporter().putCustomData("USER_NAME", "123456");
		
		super.onCreate();
	}
}
