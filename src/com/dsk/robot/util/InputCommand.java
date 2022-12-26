package com.dsk.robot.util;
/**
 * 
 * @author Shakthi Kumar
 *
 * ENum that holds all commands
 */
public enum InputCommand {
	PLACE,MOVE,LEFT,RIGHT,REPORT;
	
	public static InputCommand getCommand(String command) {
		try {
		return InputCommand.valueOf(command);
		}catch(IllegalArgumentException ex) {
			System.out.println("Command "+command +" is invalid");
			throw ex;
		}
	}
}
