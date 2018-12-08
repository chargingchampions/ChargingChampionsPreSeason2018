package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


public class AutoTurnAngleWithEncoders extends Command {
	
	private final double angle;
	private final double direction;
	
	private final double slowAngle;
	
	private double startPositionL;
	private double startPositionR;
	private double speed;
		
    /**
     * 
     * @param angle in degrees
     * @param time in seconds
     */
	public AutoTurnAngleWithEncoders(double angle, double time) {
       requires(Robot.driveTrain);
        
       this.direction = (angle >= 0.0) ? 1.0 : -1.0;
       
       this.angle = Math.abs(angle);
       this.slowAngle = this.angle - 10.0;
       this.speed = this.angle/time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startPositionL = Robot.driveTrain.getEncoderPositionL();
    	startPositionR = Robot.driveTrain.getEncoderPositionR();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (getDistanceTraveledAvg() < slowAngle) {
    		drive(1.0); // drive at SPEED
    	} else {
    		drive(0.5); // drive at 0.2 * SPEED
    	}
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return getDistanceTraveledAvg() >= angle;
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
		
    	Robot.driveTrain.setVelL(Math.max(motorSpeed * 0.9, motorSpeed - errorL * Robot.driveTrain.UNITS_PER_FOOT) * direction);
    	Robot.driveTrain.setVelR(Math.max(motorSpeed * 0.9, motorSpeed - errorR * Robot.driveTrain.UNITS_PER_FOOT) * -direction);
    }
    
    private double getDistanceTraveledAvg()
    {
    	return (getDistanceTraveledL() + getDistanceTraveledR()) / 2.0;
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
