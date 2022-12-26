package com.dsk.robot.util;
/**
 * 
 * @author Shakthi Kumar
 * Enum created to define and construct Directions
 * Enum is created for ease of validation and restric the directions definitely
 *
 */
public enum RobotDirection {
	NORTH("WEST", "EAST"), EAST("NORTH", "SOUTH"), SOUTH("EAST", "WEST"), WEST("SOUTH", "NORTH");

	private String left;
	private String right;

	private RobotDirection(final String left, final String right) {
        this.left = left;
        this.right = right;
    }

	public String getLeft() {
		return left;
	}

	public String getRight() {
		return right;
	}
	public static void main(String []args) {
	RobotDirection rb =	RobotDirection.valueOf("NORTH");
	System.out.println(rb);
	}
}
