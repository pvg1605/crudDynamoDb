package com.app.exception;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


public class ErrorDetails {
	public ErrorDetails(Date date, String message2, String description) {
		this.timestamp=date;
		this.message=message2;
		this.details=description;
	}
	@Setter @Getter
	private Date timestamp;
	@Setter @Getter
    private String message;
	@Setter @Getter
    private String details;
}

