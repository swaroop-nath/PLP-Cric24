package com.cg.cric24.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class BlogNotFoundException extends Exception {
	private String uriDetails;

	public String getUriDetails() {
	
		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return super.fillInStackTrace();
	}

	@Override
	public synchronized Throwable getCause() {
		return super.getCause();
	}

	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

	@Override
	public synchronized Throwable initCause(Throwable arg0) {
		return super.initCause(arg0);
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream arg0) {
		super.printStackTrace(arg0);
	}

	@Override
	public void printStackTrace(PrintWriter arg0) {
		super.printStackTrace(arg0);
	}

	@Override
	public void setStackTrace(StackTraceElement[] arg0) {
		super.setStackTrace(arg0);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public BlogNotFoundException() {
	}

	public BlogNotFoundException(String arg0) {
		super(arg0);
	}

	public BlogNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public BlogNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BlogNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
