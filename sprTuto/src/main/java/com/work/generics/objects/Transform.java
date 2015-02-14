package com.work.generics.objects;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transform {
	
   static final Logger logger = LoggerFactory.getLogger(Transform.class);
	 
   /**
    * Convert a JSON string in an POJO class.
    * @param <T>
    * @param theClass - the POJO class that is used to transform the JSON.
    * @param jsonInput - the JSON string that need to be converted
    * @return
    */
   public static <T> T convertToPOJOversion2 (Class<T> myPOJO, String jsonInput) {
      
      ObjectMapper mapper = new ObjectMapper();
      T obj = null;
      
      try {
         obj = (T) myPOJO.newInstance();
      } catch (InstantiationException e) {
         throw new Transform.TransformException("InstantiationException error when instantiate POJO class.", e);
      } catch (IllegalAccessException e) {
         throw new Transform.TransformException("IllegalAccessException error when instantiate POJO class.", e);
      }
      
      try {
         obj = mapper.readValue(jsonInput, myPOJO);
      } catch (JsonParseException e) {
         throw new Transform.TransformException("JsonParseException error when convert Json to POJO class.", e);
      } catch (JsonMappingException e) {
         throw new Transform.TransformException("JsonMappingException error when convert Json to POJO class.", e);
      } catch (IOException e) {
         throw new Transform.TransformException("IOException error when convert Json to POJO class.", e);
      }
      
      return obj;
   }
   
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		String jsonInput = "{\"ssoToken\":\"jlajd8LKJjlajl\"}";
		
		Reference sso = convertToPOJOversion2 (Reference.class, jsonInput);
		logger.info("  Convert to POJO: "+sso.toString());
		
		String jsonInputError = "{\"errorInfo\": {"+
   "\"errorMessage\": \"Error Code from MV Delegate: VALUE_TOO_LONG} and error description: The value for 'memberValidation.memberId' is too long.\","+
   "\"errorType\": \"Error returned from ???.com.\","+
   "\"errorCode\": \"0\"}}";
		
		ErrorResponse err = convertToPOJOversion2 (ErrorResponse.class, jsonInputError);
		logger.info("  Convert to POJO: "+err.toString());
	}

	/**
	 * 
	 *
	 */
	static class TransformException extends RuntimeException {
	   
	    public TransformException() {
	        super();
	    }
	    
	    public TransformException(String message) {
	        super(message);
	    }

	    public TransformException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
}
