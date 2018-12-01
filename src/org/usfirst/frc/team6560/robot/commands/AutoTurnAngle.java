package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurnAngle extends Command {
	private static final double UNITS_PER_FULL_TURN = 8000.0; // the number of encoder units each motor should go (in opposite directions) to complete a full turn
	private static final double DEGREES_PER_FULL_TURN = 360.0;
	
	public static final double SPEED = 200.0;
	
    private double angle;
	private double direction;
	
    public AutoTurnAngle(double angle) {
       requires(Robot.driveTrain);
        
       this.angle = angle;
       this.direction = (angle >= 0.0) ? 1.0 : -1.0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetPositions();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double errorL = Math.max(0, Math.abs(Robot.driveTrain.getPositionL()) - Math.abs(Robot.driveTrain.getPositionR())); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead
    	double errorR = Math.max(0, Math.abs(Robot.driveTrain.getPositionR()) - Math.abs(Robot.driveTrain.getPositionL())); // errorR is how many units the right wheel is ahead of the left wheel; errorR is 0 if it is not ahead
    	
    	Robot.driveTrain.setVelL(Math.max(SPEED * 0.9, SPEED - errorL / 10) * direction);
    	Robot.driveTrain.setVelR(Math.max(SPEED * 0.9, SPEED - errorR / 10) * -direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.driveTrain.getPositionL()) / UNITS_PER_FULL_TURN >= Math.abs(angle) / DEGREES_PER_FULL_TURN && Math.abs(Robot.driveTrain.getPositionR()) / UNITS_PER_FULL_TURN >= Math.abs(angle) / DEGREES_PER_FULL_TURN;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
}
