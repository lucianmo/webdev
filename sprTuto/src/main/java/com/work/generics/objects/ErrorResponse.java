package com.work.generics.objects;

public class ErrorResponse {
	private ErrorInfo errorInfo;

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	@Override
    public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("ErrorResponse ["+getErrorInfo().toString()+"]");
		return sb.toString();
	}
}
