package com.cg.Cric24.Player_Service.exception;
/**
 * This is the PlayerNotFoundException class
 * @author Akash Sarkar
 *
 */
public class PlayerNotfoundException extends Exception {
	
	public PlayerNotfoundException() {
		super();
	}

	public PlayerNotfoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public PlayerNotfoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PlayerNotfoundException(String arg0) {
		super(arg0);
	}

	public PlayerNotfoundException(Throwable arg0) {
		super(arg0);
	}
	
	

}
