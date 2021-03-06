package com.appirio.automation.General;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class LoggerTextFormatter extends Formatter{
	    //
	    // Create a DateFormat to format the logger timestamp.
	    //
	    private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
	 
	    public String format(LogRecord record) {
	        StringBuilder builder = new StringBuilder(1000);
	        builder.append("[").append(record.getLevel()).append("]\t");
	        builder.append(df.format(new Date(record.getMillis()))).append("\t");
	        //builder.append("[").append(record.getSourceClassName()).append(".");
	        //builder.append(record.getSourceMethodName()).append("]\t");
	        builder.append(formatMessage(record));
	        builder.append("\n");
	        return builder.toString();
	    }
	 
	    public String getHead(Handler h) {
	        return super.getHead(h);
	    }
	 
	    public String getTail(Handler h) {
	        return super.getTail(h);
	    }


}
