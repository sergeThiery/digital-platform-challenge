package com.challenge.common.api;

import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.challenge.common.exception.ChallengeTechnicalException;
import com.challenge.common.exception.ConstraintViolationException;

@Controller
public abstract class  AbstractController {
	

    /** Constant error code for internal server error */
    public static final String ERROR_CODE_INTERNAL = "challenge.internalError";

    /** Constant error code for validation error */
    public static final String ERROR_CODE_VALIDATION = "challenge.validationError";

    /** Constant error code for unauthorized error */
    public static final String ERROR_CODE_UNAUTHORIZED = "ccb.unauthorizedError";

    /**
    * ResourceBundleMessageSource object for handling messages
    */
    protected AbstractMessageSource messageSource;

    /**
    * you have to overwrite the setter to add a @Autowired and @Qualifier
    * annotation for the messageSource
    *
    * @param messageSource
    *        The MessageSource
    */
    public abstract void setMessageSource(AbstractMessageSource messageSource);

    /**
    * Method for handling CCBConstraintViolationExceptions thrown by the process.
    *
    * @param e The {@link CCBConstraintViolationException} that occurs when required json is missing
    * @return OK
    */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public JsonResponse handleConstraintViolationException(ConstraintViolationException e) {

          JsonResponse jsonResponse = null;
          // only use first element because only one message can be responded
//          ConstraintViolation violation = e.getConstraintViolations().iterator().next();
//
//          if (violation == null) {
//                 // report technical error in case no violation is attached
//                 jsonResponse = handleUnexpectedError(e, ERROR_CODE_INTERNAL);
//          } else {
//                 jsonResponse = handleUnexpectedError(e, violation.getMessage());
//          }

          return jsonResponse;
    }

    /**
    * Method for handling CCBExceptions from Process Layer. The localised message
    * for the errorKey will be resolved
    *
    * @param ex
    *        the CCBException to handle
    * @return the error message
    */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResponse handleCCBError(Exception ex) {

          String message = "Unknown error";
          try {
                 resolveLocalizedMessage(ex);
          } catch (Exception e) {

          }

          JsonError error = new JsonError(ERROR_CODE_INTERNAL, message);
          JsonResponse response = new JsonResponse(error);
          return response;
    }

    /**
    * Exception handler for {@link org.springframework.web.bind.MethodArgumentNotValidException} on
    * Spring MVC level
    *
    * @param ex
    *        the exception as input
    * @return returns validation failures contained in the exception
    */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<JsonResponse> handleSpringConstraintValidationException(MethodArgumentNotValidException ex) {

          StringBuilder sb = new StringBuilder("Validation error(s)-");
          for (FieldError error : ex.getBindingResult().getFieldErrors()) {
                 sb.append(" ").append(error.getDefaultMessage()).append(",");
          }
          String response = sb.toString();
          String message = new String(response.substring(0, response.lastIndexOf(',')));
          JsonError error = new JsonError(ERROR_CODE_VALIDATION, message);
          JsonResponse jsonResponse = new JsonResponse(error);

          return new ResponseEntity<JsonResponse>(jsonResponse, HttpStatus.OK);
    }

    /**
    * Method for handling all Throwables except CCBError.
    *
    * @param th
    *        the Throwable to handle
    * @return the error message
    */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public JsonResponse handleCCBError(Throwable th) {

          return handleUnexpectedError(th, ERROR_CODE_INTERNAL);
    }

    /**
    * Method to receive a localised message for a key
    *
    * @param msgId
    *        The key of the message
    * @param params
    *        Additional message parameters
    * @return a localised message
    */
    protected String resolveLocalizedMessage(String msgId, Object... params) {
//    	CcbContextHolder.getPortalLocale()

          return this.messageSource.getMessage(msgId, params, null);
    }

    /**
    * Method to receive a localised message for a CCBException object
    *
    * @param error
    *        The CCBException object
    * @return a localised message
    */
    protected String resolveLocalizedMessage(Exception error) {

//    	error.getErrorKey(), error.getParams(), CcbContextHolder.getPortalLocale()
          return this.messageSource.getMessage(null,null,null);
    }

//    /**
//    * Returns the key of the channel in which the login has been done
//    *
//    * @return channel key
//    */
//    public String getLoginChannel() {
//
//          return getAuthentication().getLoginChannel();
//    }

//    private CCBAuthentication getAuthentication() {
//
//          return (CCBAuthentication) SecurityContextHolder.getContext().getAuthentication();
//    }

    private JsonResponse handleUnexpectedError(Throwable e, String errorKey) {

          return createErrorResponse(errorKey);

    }

    /**
    * creates an {@link JsonResponse} containing an error. The message will be left <code>null</code>.
    * <p>
    * should be used only for technical exceptions or validation errors.
    *
    * @param errorKey the errorKey to set
    * @return a newly created JsonResponse
    */
    private JsonResponse createErrorResponse(String errorKey) {

          return createErrorResponse(errorKey, null);
    }

    /**
    * creates an {@link JsonResponse} containing an error out of the given exception.
    *
    * @param ex the exception to create an error response of
    * @return a newly created JsonResponse
    */
    protected JsonResponse createErrorResponse(Exception ex) {
    	
//    	ex.getErrorKey()

          return createErrorResponse(null, resolveLocalizedMessage(ex));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
 
        return processFieldErrors(fieldErrors);
    }
 
    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO dto = new ValidationErrorDTO();
 
        for (FieldError fieldError: fieldErrors) {
            String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            dto.addFieldError(fieldError.getField(), localizedErrorMessage);
        }
 
        return dto;
    }
    
    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale =  LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
 
        //If the message was not found, return the most accurate field error code instead.
        //You can remove this check if you prefer to get the default error message.
        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
            String[] fieldErrorCodes = fieldError.getCodes();
            localizedErrorMessage = fieldErrorCodes[0];
        }
 
        return localizedErrorMessage;
    }
 

    /**
    * creates an {@link JsonResponse} containing an error.
    *
    * @param errorKey the errorKey to set
    * @param message the (readable/localized) message to set
    * @return a newly created JsonResponse
    */
    protected JsonResponse createErrorResponse(String errorKey, String message) {

          JsonError error = new JsonError(errorKey, message);
          JsonResponse resonse = new JsonResponse(error);
          return resonse;
    }

	

	  @ExceptionHandler({ChallengeTechnicalException.class})
	  public String databaseError() {
	    // Nothing to do.  Returns the logical view name of an error page, passed
	    // to the view-resolver(s) in usual way.
	    // Note that the exception is NOT available to this view (it is not added
	    // to the model) but see "Extending ExceptionHandlerExceptionResolver"
	    // below.
	    return "databaseError";
	  }
	
	

}
