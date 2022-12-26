package com.dsk.robot;

/**
 * 
 * @author Shakthi Kumar
 * Table class which says the poisition of the robot
 *
 */
public class Table {


    private int width;


    private int height;

    public Table(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public boolean checkCoordinates(final RoboPosition position) {
        return (position.getXAxis() <= this.width && position.getXAxis() >= 0 )
                && (position.getYAxis() <= this.height && position.getYAxis() >= 0);
    }
}