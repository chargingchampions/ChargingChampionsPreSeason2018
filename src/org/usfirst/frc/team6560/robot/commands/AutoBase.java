package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AutoBase extends Command {
	private static final double correctionFactor = 2.5;

	private final double speed;
	private final double slowSpeed;
	private final double distance;
	private final boolean invertL;
	
	private final double slowDistance;
	private final double direction;
	
	private double startPositionL;
	private double startPositionR;
	
	public AutoBase(double speed, double slowSpeed, double distance, boolean invertL) {
	    requires(Robot.driveTrain);
	    


		this.speed = speed;
		this.slowSpeed = slowSpeed;
		this.distance = Math.abs(distance);
		this.invertL = invertL;
		
		this.slowDistance = this.distance - 1 * speed;
	    this.direction = (distance >= 0.0) ? 1.0 : -1.0;
	    
	}
	
	protected void initialize() {
		Robot.driveTrain.setAutonomous();
		
    	startPositionL = Robot.driveTrain.getEncoderPositionL();
    	startPositionR = Robot.driveTrain.getEncoderPositionR();
    }
	
	@Override
	public void execute() {
    	if (getDistanceTraveledAvg() < slowDistance) {
    		drive(speed); // drive at SPEED
    	} else {
    		drive(slowSpeed); // drive at 0.2 * SPEED
    	}
    }
    
    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
    	return getDistanceTraveledAvg() >= distance;
    }
	
    public void end() {
    	Robot.driveTrain.stopImmediately();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    public void interrupted() {
    	end();
    }
    
    private void drive(double motorSpeed) {
    	double errorL = Math.max(0, getDistanceTraveledL() - getDistanceTraveledR()); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead
		double errorR = Math.max(0, getDistanceTraveledR() - getDistanceTraveledL()); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead
		
    	Robot.driveTrain.setVelL(Math.max(motorSpeed * 0.9, motorSpeed - errorL * correctionFactor) * (invertL ? -direction : direction));
    	Robot.driveTrain.setVelR(Math.max(motorSpeed * 0.9, motorSpeed - errorR * correctionFactor) * direction);
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
