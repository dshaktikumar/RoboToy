package com.dsk.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dsk.robot.util.RobotDirection;
/***
 * 
 * @author Shakthi Kumar
 *
 * Class to test Table
 */
public class TableTest {
	
	@Test
	public void testCheckCoordinatesValid() {
		RoboPosition roboNorth = new RoboPosition(4,4,RobotDirection.NORTH);
		Table table = new Table(4, 4);
		
		assertEquals(Boolean.TRUE,table.checkCoordinates(roboNorth));
	}
	@Test
	public void testCheckCoordinatesInvalid() {
		RoboPosition roboNorth = new RoboPosition(2,4,RobotDirection.NORTH);
		Table table = new Table(4, 4);
		assertEquals(Boolean.FALSE,table.checkCoordinates(roboNorth));
		
//		table.checkCoordinates(roboNorth);
	}
}
