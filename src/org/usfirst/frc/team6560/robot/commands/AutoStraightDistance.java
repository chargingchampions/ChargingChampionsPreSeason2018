package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


public class AutoStraightDistance extends Command {
	public static final double UNITS_PER_FOOT = 4096 / (Math.PI / 2.0);
	public static final double SPEED = 1000.0;
	
	private double stop_distance;
	private double direction;
	
	private boolean stop_distance_reached = false;
	
    public AutoStraightDistance(double distance) {
       requires(Robot.driveTrain);
        
       this.direction = (distance >= 0.0) ? 1.0 : -1.0;
       
       this.stop_distance = distance - (((SPEED * 10.0 / UNITS_PER_FOOT) * (DriveTrain.RAMP_TIME / 10.0)) / 2.0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetPositions();
    	stop_distance_reached = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if ((Math.abs(Robot.driveTrain.getPositionL()) / UNITS_PER_FOOT >= Math.abs(stop_distance)) && (Math.abs(Robot.driveTrain.getPositionR()) / UNITS_PER_FOOT >= Math.abs(stop_distance)))
    	{
    		Robot.driveTrain.stop();
    		stop_distance_reached = true;
    	}
    	else
    	{
    		double errorL = Math.max(0, Math.abs(Robot.driveTrain.getPositionL()) - Math.abs(Robot.driveTrain.getPositionR())); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead
        	double errorR = Math.max(0, Math.abs(Robot.driveTrain.getPositionR()) - Math.abs(Robot.driveTrain.getPositionL())); // errorR is how many units the right wheel is ahead of the left wheel; errorR is 0 if it is not ahead
        	
        	Robot.driveTrain.setVelL(Math.max(SPEED * 0.2, SPEED - errorL) * direction);
        	Robot.driveTrain.setVelR(Math.max(SPEED * 0.2, SPEED - errorR) * direction);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return stop_distance_reached && Robot.driveTrain.getVelL() < 10.0 && Robot.driveTrain.getVelR() < 10.0;
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
