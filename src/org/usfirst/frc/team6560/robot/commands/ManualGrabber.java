package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualGrabber extends Command {
	public static final double SWING_OUTPUT = 0.2;
	public static final double BALL_OUTPUT = 0.2;

    public ManualGrabber() {
    	requires(Robot.grabber);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grabber.setSwingOutput(0);
    	Robot.grabber.setBallOutput(0);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.logitech.getPOV() == 0) {
    		Robot.grabber.setSwingOutput(SWING_OUTPUT);
    	} else if (Robot.oi.logitech.getPOV() == 180) {
    		Robot.grabber.setSwingOutput(-SWING_OUTPUT);
    	} else {
    		Robot.grabber.setSwingOutput(0);
    	}
    	
    	if (Robot.oi.logitech.getRawButton(RobotMap.Logitech.TRIGGER)) {
    		Robot.grabber.setBallOutput(BALL_OUTPUT);
    	} else if (Robot.oi.logitech.getRawButton(RobotMap.Logitech.GRIP)){
    		Robot.grabber.setBallOutput(-BALL_OUTPUT);
    	} else {
    		Robot.grabber.setBallOutput(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.grabber.setSwingOutput(0);
    	Robot.grabber.setBallOutput(0);
    }
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
