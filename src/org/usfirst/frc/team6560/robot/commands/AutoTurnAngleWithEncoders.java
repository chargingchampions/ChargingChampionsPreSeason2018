package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


public class AutoTurnAngleWithEncoders extends Command {
	
	private static final double correctionFactor = 2;
	private static final double radius = 1.2;
	private final double distance;
	private final double directionR;
	private final double speed;
	
	private final double slowDistance;
	
	private double startPositionL;
	private double startPositionR;
		
    /**
     * 
     * @param angle in degrees
     * @param time in seconds
     */
	public AutoTurnAngleWithEncoders(double angle, double time) {
       requires(Robot.driveTrain);
        
       this.directionR = (angle >= 0.0) ? 1.0 : -1.0;
       
       this.distance = Math.abs((angle/360)*2*Math.PI*radius);
       this.slowDistance = this.distance - 0.5;
       this.speed = this.distance/time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startPositionL = Robot.driveTrain.getEncoderPositionL();
    	startPositionR = Robot.driveTrain.getEncoderPositionR();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (getDistanceTraveledAvg() < slowDistance) {
    		drive(1.0); // drive at SPEED
    	} else {
    		drive(0.5); // drive at 0.2 * SPEED
    	}
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return getDistanceTraveledAvg() >= distance;
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
    
    private void drive(double speedMultiplier) {
    	double errorL = Math.max(0, getDistanceTraveledL() - getDistanceTraveledR()); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead
		double errorR = Math.max(0, getDistanceTraveledR() - getDistanceTraveledL()); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead

		double motorSpeed = speedMultiplier * speed;
		
    	Robot.driveTrain.setVelL(Math.max(motorSpeed * 0.9, motorSpeed - errorL * correctionFactor) * -directionR);
    	Robot.driveTrain.setVelR(Math.max(motorSpeed * 0.9, motorSpeed - errorR * correctionFactor) * directionR);
    }
    
    private double getDistanceTraveledAvg()
    {
    	return (Math.abs(getDistanceTraveledL()) + Math.abs(getDistanceTraveledR())) / 2.0;
    }
    
    private double getDistanceTraveledL()
    {
    	return Math.abs(Robot.driveTrain.getEncoderPositionL() - startPositionL);
    }
    
    private double getDistanceTraveledR()
    {
    	return Math.abs(Robot.driveTrain.getEncoderPositionR() - startPositionR);
    }
    

    
}
