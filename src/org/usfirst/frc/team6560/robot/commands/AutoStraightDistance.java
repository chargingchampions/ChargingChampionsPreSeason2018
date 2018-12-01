package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStraightDistance extends Command {
	public static final double UNITS_PER_FOOT = 4000;
	public static final double SPEED = 400.0;
	private double distance;
    private double speed;

    public AutoStraightDistance(double distance, double speed) {
        requires(Robot.driveTrain);
        
       this.distance = distance;
       this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetPositions();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double errorL = Math.max(0, Robot.driveTrain.getPositionL() - Robot.driveTrain.getPositionR()); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead
    	double errorR = Math.max(0, Robot.driveTrain.getPositionR() - Robot.driveTrain.getPositionL()); // errorR is how many units the right wheel is ahead of the left wheel; errorR is 0 if it is not ahead
    	
    	Robot.driveTrain.setVelL(Math.max(SPEED / 2, SPEED - errorL / 10)*speed);
    	Robot.driveTrain.setVelR(Math.max(SPEED / 2, SPEED - errorR / 10)*speed);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.driveTrain.getPositionL() / UNITS_PER_FOOT >= distance) && (Robot.driveTrain.getPositionR() / UNITS_PER_FOOT >= distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
}
