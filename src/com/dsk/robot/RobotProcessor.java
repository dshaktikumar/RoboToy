package com.dsk.robot;

import com.dsk.robot.exceptions.RobotException;
import com.dsk.robot.util.InputCommand;
import com.dsk.robot.util.RobotDirection;
/**
 * 
 * @author Shakthi Kumar
 *
 * Core Processor class to position the robot
 * Accepts command, validates
 *
 */
public class RobotProcessor {

    private Table surface;

    private Robot robot;


    public RobotProcessor(final Table surface, final Robot robot) {
        this.surface = surface;
        this.robot = robot;
    }
/**
 * 
 * @param position
 * @throws RobotException
 */
    public void positionRobot(final RoboPosition position) throws RobotException {

        if(!this.surface.checkCoordinates(position)) {
            throw new RobotException("Invalid coordinates!");
        }

        this.robot.setNewPosition(position);
    }

    /**
     * Processes input command and validates the command across with Enums
     * @param input
     * @return
     * @throws RobotException
     */
    public String processCommand(final String input) throws RobotException {
        String result = null;
        String[] commands = input.split(" ");
        if(commands.length > 0) {

            InputCommand InputCommand = com.dsk.robot.util.InputCommand.getCommand(commands[0]);

            switch (InputCommand) {
                case PLACE:
                    this.positionRobot(this.getPosition(InputCommand, commands));
                    break;
                case MOVE:
                    RoboPosition nextPosition = this.getNextPosition();

                    if(this.surface.checkCoordinates(nextPosition)) {
                        this.robot.move(nextPosition);
                    }
                    break;
                case REPORT:
                    result = this.robot.reportPosition();
                    break;
                case RIGHT:
                    this.robot.right();
                    break;
                case LEFT:
                    this.robot.left();
                    break;
                default:
                    throw new RobotException("Incorrect command");
            }
        } else {
            throw new RobotException("Incorrect command");
        }

        return result;
    }


    private RoboPosition getPosition(final InputCommand InputCommand, final String[] input) throws RobotException {
        String[] commands;
        int xAxis = 0;
        int yAxis = 0;
        RoboPosition position = null;
        if (InputCommand == com.dsk.robot.util.InputCommand.PLACE) {
            try {
                commands = input[1].split(",");

                xAxis = Integer.parseInt(commands[0]);
                yAxis = Integer.parseInt(commands[1]);
                RobotDirection RobotDirection = com.dsk.robot.util.RobotDirection.valueOf(commands[2]);
                position = new RoboPosition(xAxis, yAxis, RobotDirection);

            } catch (Exception e) {
                throw new RobotException("Exception occured");
            }
        }

        return position;
    }


  private RoboPosition getNextPosition() throws RobotException {
        RoboPosition nextPosition = new RoboPosition(this.robot.getCurrentPosition().getXAxis(),
                this.robot.getCurrentPosition().getYAxis(),
                this.robot.getCurrentPosition().getCurrentDirection());
        switch (this.robot.getCurrentPosition().getCurrentDirection()) {
            case NORTH:
                nextPosition.newCoordinates(0, 1);
                break;
            case EAST:
                nextPosition.newCoordinates(1, 0);
                break;
            case SOUTH:
                nextPosition.newCoordinates(0, -1);
                break;
            case WEST:
                nextPosition.newCoordinates(-1, 0);
                break;
        }

        return nextPosition;
    }
}