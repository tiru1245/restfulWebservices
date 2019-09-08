package com.tiru.restfulwebservice.Exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timeStamp;
    private String message;
    private String details;
	public ExceptionResponse(Date timeStamp, String message, String details) {
		super();
		this.setTimeStamp(timeStamp);
		this.setMessage(message);
		this.setDetails(details);
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
    
    
}
