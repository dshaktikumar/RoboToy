package com.dsk.robot.engine;

import java.util.Scanner;

import com.dsk.robot.Robot;
import com.dsk.robot.RobotProcessor;
import com.dsk.robot.Table;
import com.dsk.robot.exceptions.RobotException;
/***
 * 
 * @author User
 * Class to simulate robot 
 *
 *This can be used as an alternative for Junit Test classes
 *
 */
public class RobotRunner {
	
	public static void main(String[] args) {
		boolean runRobot = true;
		System.out.println("This is a Robot on 5*5 dimensional Table:");
		System.out.println("Enter Commands to function Robot: ");
		System.out.println("1) PLACE X,Y,FACING_DIRECTION (NORTH|SOUTH|EAST|WEST)");
		System.out.println("2) MOVE, LEFT, RIGHT");
		System.out.println("3) REPORT");
		System.out.println("Enter::\n");
		Table start = new Table(4, 4);
		RobotProcessor simulator = new RobotProcessor(start, new Robot());

		Scanner sc = new Scanner(System.in);;
		while (runRobot) {
			try {
			String value = sc.nextLine();
			String retVal = simulator.processCommand(value);
			//System.out.println("Result::"+retVal);
			
			}catch(RobotException ex) {
				//ex.printStackTrace();
				System.err.println("Exception occured while processing Robo:"+ex);
			}catch(Exception ex) {
				//ex.printStackTrace();
				System.out.println("Exception occured :"+ex);
			}finally {
				System.out.println("\n Press \"N\" if you wish to quit OR press enter to continue::");
				String yOrNo = sc.nextLine();
				if("N".equals(yOrNo)) {
					System.out.println("Robot shut down***");
					if(sc!=null) {
						sc.close();
					}
					runRobot = false;	
					break;
				}else {
					System.out.println("This is a Robot on 5*5 dimensional Table:");
					System.out.println("Enter Commands to function Robot: ");
					System.out.println("1) PLACE X,Y,FACING_DIRECTION (NORTH|SOUTH|EAST|WEST)");
					System.out.println("2) MOVE, LEFT, RIGHT");
					System.out.println("3) REPORT");
					System.out.println("Enter::\n");
				}
				
			}
		}
	}
}
