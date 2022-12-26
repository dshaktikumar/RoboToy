package com.dsk.robot;

import com.dsk.robot.exceptions.RobotException;
import com.dsk.robot.util.RobotDirection;

/**
 * Robot class with behavior MOVE, LEFT, RIGHT or REPORT
 */
public class Robot {

    private RoboPosition currentPosition;

    public Robot() { }
    

    public Robot(RoboPosition currentPosition) {
		super();
		this.currentPosition = currentPosition;
	}


	public RoboPosition getCurrentPosition() throws RobotException {

        if(null == this.currentPosition) {
            throw new RobotException("Incorrect position");
        }
        return currentPosition;
    }

    public void setNewPosition(final RoboPosition position) {
        this.currentPosition = position;
    }

    public void move(final RoboPosition nextPosition) {
        this.currentPosition = nextPosition;
    }


    public void left() throws RobotException {
        if(null == this.currentPosition) {
            throw new RobotException("Incorrect position");
        }
        this.currentPosition.setCurrentDirection(RobotDirection.valueOf(this.currentPosition.getCurrentDirection().getLeft()));
    }


    public void right() throws RobotException {
        if(null == this.currentPosition) {
            throw new RobotException("Incorrect position");
        }
        this.currentPosition.setCurrentDirection(RobotDirection.valueOf(this.currentPosition.getCurrentDirection().getRight()));
    }


    public String reportPosition() throws RobotException {
        StringBuilder report = new StringBuilder();
        report.append(this.getCurrentPosition().getXAxis())
                .append(",")
                .append(this.getCurrentPosition().getYAxis())
                .append(",")
                .append(this.getCurrentPosition().getCurrentDirection().toString());

        return report.toString();
    }

    public RoboPosition reportCurrentPosition() throws RobotException{
    	return this.currentPosition;
    }


	@Override
	public String toString(){
		
		return "Robot [currentPosition=" + currentPosition + "]";
	}

}
