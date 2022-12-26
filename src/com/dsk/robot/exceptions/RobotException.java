package com.dsk.robot.exceptions;
/**
 * 
 * @author Shakthi Kumar
 * Generic Exception class to handle Robot exceptions
 *
 */
public class RobotException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RobotException(final String message) {
        super(message);
    }
}
