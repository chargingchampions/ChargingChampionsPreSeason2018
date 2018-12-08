package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


public class AutoStraightDistance extends Command {
	public static final double UNITS_PER_FOOT = 4096 / (Math.PI / 2.0);
	public static final double SPEED = 400.0;
	
	private final double distance;
	private final double direction;
	
	private final double slowDistance;
	
	private double startPositionL;
	private double startPositionR;
		
    public AutoStraightDistance(double distance) {
       requires(Robot.driveTrain);
        
       this.direction = (distance >= 0.0) ? 1.0 : -1.0;
       
       this.distance = Math.abs(distance);
       this.slowDistance = this.distance - 3.0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startPositionL = getEncoderPositionL();
    	startPositionR = getEncoderPositionR();
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

		double motorSpeed = speedMultiplier * SPEED;
		
    	Robot.driveTrain.setVelL(Math.max(motorSpeed * 0.9, motorSpeed - errorL * UNITS_PER_FOOT * 2) * direction);
    	Robot.driveTrain.setVelR(Math.max(motorSpeed * 0.9, motorSpeed - errorR * UNITS_PER_FOOT * 2) * direction);
    }
     
    private double getEncoderPositionL() {
    	return Robot.driveTrain.getPositionL() /  UNITS_PER_FOOT;
    }
    
    private double getEncoderPositionR() {
    	return Robot.driveTrain.getPositionR() /  UNITS_PER_FOOT;
    }
    
    private double getDistanceTraveledAvg()
    {
    	return (getDistanceTraveledL() + getDistanceTraveledR()) / 2.0;
    }
    
    private double getDistanceTraveledL()
    {
    	return Math.abs(getEncoderPositionL() - startPositionL);
    }
    
    private double getDistanceTraveledR()
    {
    	return Math.abs(getEncoderPositionR() - startPositionR);
    }
    

    
}
