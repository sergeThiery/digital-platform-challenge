package com.challenge.common.api;

import java.io.Serializable;

public class JsonResponse implements Serializable{
	
	/**
     * 
      */
     private static final long serialVersionUID = -6682860261281215288L;

     private JsonError error;

     private JsonResult result;

     public JsonResponse(JsonError error) {

           this.error = error;
     }

     public JsonResponse(JsonResult result) {

           this.result = result;
     }

     /**
     * @return error
     */
     public JsonError getError() {

           return this.error;
     }

     /**
     * @return result
     */
     public JsonResult getResult() {

           return this.result;
     }



}
