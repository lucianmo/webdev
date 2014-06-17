package com.work.generics.objects;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transform {
	
   static final Logger logger = LoggerFactory.getLogger(Transform.class);
	 
   public static <T> T convertToPOJO (Class<T> theClass, String jsonInput) throws InstantiationException, IllegalAccessException {
	   
	      ObjectMapper mapper = new ObjectMapper();
	      T obj = theClass.newInstance();;
	      
	      try {
	         obj = mapper.readValue(jsonInput, theClass);
	      } catch (JsonParseException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (JsonMappingException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      return obj;
	   }
	   
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		String jsonInput = "{\"ssoToken\":\"jlajd8LKJjlajl\"}";
		
		Reference sso = convertToPOJO (Reference.class, jsonInput);
		logger.info("  Convert to POJO: "+sso.toString());
		
		String jsonInputError = "{\"errorInfo\": {"+
   "\"errorMessage\": \"Error Code from MV Delegate: VALUE_TOO_LONG} and error description: The value for 'memberValidation.memberId' is too long.\","+
   "\"errorType\": \"Error returned from Points.com MV Delegate.\","+
   "\"errorCode\": \"400\"}}";
		
		ErrorResponse err = convertToPOJO (ErrorResponse.class, jsonInputError);
		logger.info("  Convert to POJO: "+err.toString());
	}

}
