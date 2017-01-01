package com.challenge.common.api;

import java.io.Serializable;

public class JsonError implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Code
	 */
    private String code;
    
    /**
     * message
     */
    private String message;

    /**
    * Default constructor which sets the error code and message.
    * 
     * @param code - error code in the form <functional-domain>.<errorIdentifer>
    * @param message - language dependent clear text representation of the error
    */
    public JsonError(String code, String message) {

          this.code = code;
          this.message = message;
    }

    /**
    * Set the error code
    * 
     * @param code the error code in the form <functional-domain>.<errorIdentifer>
    */
    public void setCode(String code) {

          this.code = code;
    }

    /**
    * @param message the new value of message
    */
    public void setMessage(String message) {

          this.message = message;
    }



}
