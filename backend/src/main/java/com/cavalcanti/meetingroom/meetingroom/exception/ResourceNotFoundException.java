package com.cavalcanti.meetingroom.meetingroom.exception;


import java.io.Serializable;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class ResourceNotFoundException  extends Exception implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
