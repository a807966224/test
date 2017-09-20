package com.practice.test.backstage.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 由service层引起的异常 均由此类派生
 * @author Scott
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends Exception{

	private Throwable nestedThrowable = null;

	  public ServiceException() {
	    super();
	  }

	  public ServiceException(String msg) {
	    super(msg);
	  }

	  public ServiceException(Throwable nestedThrowable) {
	    this.nestedThrowable = nestedThrowable;
	  }

	  public ServiceException(String msg, Throwable nestedThrowable) {
	    super(msg);
	    this.nestedThrowable = nestedThrowable;
	  }

	  @Override
	  public void printStackTrace() {
	    super.printStackTrace();
	    if (nestedThrowable != null) {
	      nestedThrowable.printStackTrace();
	    }
	  }

	  @Override
	  public void printStackTrace(PrintStream ps) {
	    super.printStackTrace(ps);
	    if (nestedThrowable != null) {
	      nestedThrowable.printStackTrace(ps);
	    }
	  }

	  @Override
	  public void printStackTrace(PrintWriter pw) {
	    super.printStackTrace(pw);
	    if (nestedThrowable != null) {
	      nestedThrowable.printStackTrace(pw);
	    }
	  }
	
}
