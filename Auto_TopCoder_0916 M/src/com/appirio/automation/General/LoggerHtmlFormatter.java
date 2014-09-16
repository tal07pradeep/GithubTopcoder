package com.appirio.automation.General;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

//This custom formatter formats parts of a log record to a single line
public class LoggerHtmlFormatter extends Formatter {
	// This method is called for every log records
	public String format(LogRecord rec) {
		String msg=formatMessage(rec);
		boolean noResult=true;
		String command=msg;
		String result="";
		int index=msg.indexOf("\nResult: ");
		if (index>=0)
		{
			noResult=false;
			command=msg.substring(0,index);
			command=command.replace("Executing Command: ", "");
			result=msg.substring(index);
			result=result.replace("\nResult: ", "");
			
		}
		StringBuffer buf = new StringBuffer(1000);
		// Bold any levels >= WARNING and color the complete row in red
		if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
			buf.append("<tr style=\"color:red\">");
		} 
		else {
			buf.append("<tr>");
		}
		buf.append("<td>");
		buf.append(rec.getLevel());
		buf.append("</td>");
		buf.append("<td>");
		buf.append(calcDate(rec.getMillis()));
		buf.append("</td>");
		if (noResult)
		{
			buf.append("<td colspan=2>");
			buf.append(command);
		}
		else
		{
			buf.append("<td>");
			buf.append(command);
			buf.append("<td>");
			buf.append(result);
			buf.append("</tr>\n");
			
		}
		return buf.toString();
	}

	private String calcDate(long millisecs) {
		SimpleDateFormat date_format = new SimpleDateFormat("MMM dd, yyyy HH:mm");
		Date resultdate = new Date(millisecs);
		return date_format.format(resultdate);
	}

	// This method is called just after the handler using this
	// formatter is created
	public String getHead(Handler h) {
		return "<HTML>\n<HEAD>\n" + (new Date()) + "\n</HEAD>\n<BODY>\n<PRE>\n"
				+ "<table border style=\"font-family:arial\">\n  "
				+ "<tr><th style=\"font-family:verdana\">Level</th>"
				+ "<th style=\"font-family:verdana\">Time</th>"
				+ "<th style=\"font-family:verdana\">Command</th>"
				+ "<th style=\"font-family:verdana\">Log Message</th></tr>\n";
	}

	// This method is called just after the handler using this
	// formatter is closed
	public String getTail(Handler h) {
		return "</table>\n  </PRE></BODY>\n</HTML>\n";
	}
}