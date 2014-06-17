package com.work.generics.objects;

public class ErrorInfo {
   private String errorMessage;
   private String errorType;
   private String errorCode;
    
   public ErrorInfo() {}
   
   public ErrorInfo(String errorMessage, String errorType, String errorCode) {
      this.errorMessage = errorMessage;
      this.errorType = errorType;
      this.errorCode = errorCode;
   }

   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   public String getErrorType() {
      return errorType;
   }

   public void setErrorType(String errorType) {
      this.errorType = errorType;
   }

   public String getErrorCode() {
      return errorCode;
   }

   public void setErrorCode(String errorCode) {
      this.errorCode = errorCode;
   }
   
	@Override
    public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[errorMessage="+errorMessage+"\n");
		sb.append("  errorType="+errorType+"\n");
		sb.append("  errorCode="+errorCode+"]");
				
		return sb.toString();
	}
}
