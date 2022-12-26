package com.dsk.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.dsk.robot.exceptions.RobotException;
import com.dsk.robot.util.RobotDirection;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
/**
 * 
 * @author Shakthi Kumar
 *
 */
@TestMethodOrder(OrderAnnotation.class)
public class RobotTest {
	/**
	 * 
	 * @throws RobotException
	 */
	@Test
	@Order(1)
	public void testMove() throws RobotException{
		Robot rb = new Robot(new RoboPosition(1, 1, RobotDirection.NORTH));
		
		rb.move(new RoboPosition(2,2,RobotDirection.NORTH));
		assertEquals(new RoboPosition(2, 2, RobotDirection.NORTH), rb.getCurrentPosition());
		
	}
	
	@Test
	@Order(2)
	public void testReportPosition() throws RobotException{
		Robot rb = new Robot(new RoboPosition(2, 3, RobotDirection.EAST));
		rb.move(new RoboPosition(3, 3, RobotDirection.EAST));
		//System.out.println(rb.getCurrentPosition());
		//System.out.println(rb.reportPosition());
		assertEquals("3,3,EAST", rb.reportPosition());
	}
	
	@Test
	@Order(3)
	public void testDirectionLeft() throws RobotException{
		Robot rb = new Robot(new RoboPosition(2, 3, RobotDirection.SOUTH));
		rb.left();
		//System.out.println(rb.reportPosition());
		assertEquals(new RoboPosition(2, 3, RobotDirection.EAST), rb.getCurrentPosition());
	}
	@Test
	@Order(4)
	public void testDirectionRight() throws RobotException{
		Robot rb = new Robot(new RoboPosition(1, 2, RobotDirection.NORTH));
		rb.right();;
		//System.out.println(rb.reportPosition());
		assertEquals(new RoboPosition(1, 2, RobotDirection.EAST), rb.getCurrentPosition());
	}
	
}
