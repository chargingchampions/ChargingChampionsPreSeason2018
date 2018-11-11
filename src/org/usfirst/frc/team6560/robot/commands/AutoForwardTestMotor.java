package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoForwardTestMotor extends Command {
	public static final double UNITS_PER_FOOT = 4000;
	public static final double SPEED = 400.0;

    public AutoForwardTestMotor(double distance) {
        requires(Robot.testMotor);
        
       this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.testMotor.resetPositions();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double errorL = Math.max(0, Robot.testMotor.getPositionL() - Robot.testMotor.getPositionR()); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead
    	double errorR = Math.max(0, Robot.testMotor.getPositionR() - Robot.testMotor.getPositionL()); // errorR is how many units the right wheel is ahead of the left wheel; errorR is 0 if it is not ahead
    	
    	Robot.testMotor.setVelL(Math.max(SPEED / 2, SPEED - errorL / 10));
    	Robot.testMotor.setVelR(Math.max(SPEED / 2, SPEED - errorR / 10));

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.testMotor.getPositionL() / UNITS_PER_FOOT >= distance) && (Robot.testMotor.getPositionR() / UNITS_PER_FOOT >= distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.testMotor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private double distance;
}
