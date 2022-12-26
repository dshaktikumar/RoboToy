package com.dsk.robot;

import java.util.Objects;

import com.dsk.robot.exceptions.RobotException;
import com.dsk.robot.util.RobotDirection;

/**
 * 
 * @author Shakthi Kumar
 * Class to position the robot
 *
 */
public class RoboPosition {

    private int xAxis;

    private int yAxis;

    private RobotDirection currentDirection;

    public RoboPosition(final int xAxis, final int yAxis, final RobotDirection currentDirection) {
        this.currentDirection = currentDirection;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public RobotDirection getCurrentDirection() throws RobotException {
        if(null == this.currentDirection) {
            throw new RobotException("Invalid Direction");
        }
        return currentDirection;
    }

    public void setCurrentDirection(RobotDirection currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void newCoordinates(final int x, final int y) {
        this.xAxis += x;
        this.yAxis += y;
    }

	@Override
	public int hashCode() {
		return Objects.hash(currentDirection, xAxis, yAxis);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoboPosition other = (RoboPosition) obj;
		return currentDirection == other.currentDirection && xAxis == other.xAxis && yAxis == other.yAxis;
	}

	@Override
	public String toString() {
		return "RoboPosition [xAxis=" + xAxis + ", yAxis=" + yAxis + ", currentDirection=" + currentDirection + "]";
	}
	
}
