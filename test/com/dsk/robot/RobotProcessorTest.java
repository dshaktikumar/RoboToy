package com.dsk.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.dsk.robot.exceptions.RobotException;

/**
 * 
 * @author Shakthi Kumar
 *
 * This is the class to run the challenge's test cases
 */
@TestMethodOrder(OrderAnnotation.class)
public class RobotProcessorTest {

	@Test
	@Order(1)
	public void testPositionRobot() throws RobotException{
		RobotProcessor proc = new RobotProcessor(new Table(4, 4), new Robot());
		proc.processCommand("PLACE 0,0,NORTH");
		proc.processCommand("MOVE");
		String procCommand = proc.processCommand("REPORT");
//		System.out.println(procCommand);
		assertEquals("0,1,NORTH", procCommand);
	}
	@Test
	@Order(2)
	public void testRightCommand() throws RobotException{
		RobotProcessor proc = new RobotProcessor(new Table(4, 4), new Robot());
		proc.processCommand("PLACE 0,0,NORTH");
		proc.processCommand("LEFT");
		String procCommand = proc.processCommand("REPORT");
		//System.out.println(procCommand);
		
		assertEquals("0,0,WEST", procCommand);
	}
	@Test
	@Order(3)
	public void testLeftCommand() throws RobotException{
		RobotProcessor proc = new RobotProcessor(new Table(4, 4), new Robot());
		proc.processCommand("PLACE 1,2,EAST");
		proc.processCommand("MOVE");
		String procCommand = proc.processCommand("REPORT");
		//System.out.println(procCommand);
		
		
		proc.processCommand("MOVE");
		//procCommand = proc.processCommand("REPORT");
		//System.out.println(procCommand);
		proc.processCommand("LEFT");
		//procCommand = proc.processCommand("REPORT");
				//System.out.println(procCommand);
		
		proc.processCommand("MOVE");

		procCommand = proc.processCommand("REPORT");
		//System.out.println(procCommand);

		assertEquals("3,3,NORTH", procCommand);
	}
	@Test
	@Order(4)
	public void testInvalidArguments() throws RobotException{
		RobotProcessor proc = new RobotProcessor(new Table(4, 4), new Robot());
		
		Exception exc = Assertions.assertThrows(RobotException.class,
				()->proc.processCommand("PALCE 1,2,EAST"));
		assertEquals(RobotException.class, exc.getClass());
	}
}
