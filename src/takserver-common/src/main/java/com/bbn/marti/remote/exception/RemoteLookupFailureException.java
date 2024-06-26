

package com.bbn.marti.remote.exception;

public class RemoteLookupFailureException extends RuntimeException {

	private static final long serialVersionUID = 7652374657L;

	public RemoteLookupFailureException() {
		super();
	}

	public RemoteLookupFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RemoteLookupFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public RemoteLookupFailureException(String message) {
		super(message);
	}

	public RemoteLookupFailureException(Throwable cause) {
		super(cause);
	}
}
