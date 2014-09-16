package com.appirio.automation.GmailEvents;


public class EmailHeader {
	private String fromId;
	private String toId;
	private String toCc;
	private String toBcc;
	private String subject;
	private String date;
	private String messageId;
	private String replyTo;
	
	/**
	 * 
	 * @param FromId
	 * @param ToId
	 * @param ToCc
	 * @param ToBcc
	 * @param Subject
	 * @param Date
	 * @param MessageId
	 * @param ReplyTo
	 */
	public EmailHeader(String FromId, String ToId, String ToCc,String ToBcc, String Subject, String Date, String MessageId, String ReplyTo)
	{
		this.fromId=FromId;
		this.toId=ToId;
		this.setToCc(ToCc);
		this.setToBcc(ToBcc);
		this.subject=Subject;
		this.date=Date;
		this.messageId=MessageId;
		this.replyTo=ReplyTo;
	}
	public void setFromId(String FromId)
	{
		this.fromId=FromId;
	}
	public void setToId(String ToId)
	{
		this.toId=ToId;
	}
	public void setSubject(String Subject)
	{
		this.subject=Subject;
	}
	public void setDate(String Date)
	{
		this.date=Date;
	}
	public void setMessageId(String MessageId)
	{
		this.messageId=MessageId;
	}
	public void setReplyTo(String ReplyTo) 
	{
		this.replyTo = ReplyTo;
	}
	public void setToCc(String toCc) 
	{
		this.toCc = toCc;
	}
	
	public void setToBcc(String toBcc) {
		this.toBcc = toBcc;
	}
	
	public String getFromId()
	{
		return fromId;
	}
	public String getToId()
	{
		return toId;
	}
	public String getSubject()
	{
		return subject;
	}
	public String getDate()
	{
		return date;
	}
	public String getMessageId()
	{
		return messageId;
	}
	public String getReplyTo() 
	{
		return replyTo;
	}
	public String getToCc() {
		return toCc;
	}
	
	public String getToBcc() {
		return toBcc;
	}
	public void print() {
		System.out.println(
				"From:\t"+fromId+
				"\nTo:\t"+toId+
				"\nCc:\t"+toCc+
				"\nBcc:\t"+toBcc+
				"\nSubject:\t"+subject+
				"\nDate:\t"+date+
				"\nReplyTo:\t"+replyTo
				);
		
	}
	
}

