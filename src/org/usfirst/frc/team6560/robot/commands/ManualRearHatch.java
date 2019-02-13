package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualRearHatch extends Command {
    public ManualRearHatch() {
    	requires(Robot.rearHatch);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.rearHatch.setExtend(false);
    	Robot.rearHatch.setShoot(false);
    	
    	lastExtendButtonState = false;
    	extendState = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.logitech.getRawButton(RobotMap.Logitech.BUTTON_3) || Robot.oi.logitech.getRawButton(RobotMap.Logitech.BUTTON_4)) {
    		Robot.rearHatch.setShoot(true);
    	} else {
    		Robot.rearHatch.setShoot(false);
    	}
    	
    	boolean extendButtonState = Robot.oi.xbox.getRawButton(RobotMap.Xbox.BUTTON_X);
    	
    	if (extendButtonState && !lastExtendButtonState) {
    		extendState = !extendState;
    		Robot.rearHatch.setExtend(extendState);
    	}
    	
    	lastExtendButtonState = extendButtonState;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rearHatch.setExtend(false);
    	Robot.rearHatch.setShoot(false);
    }
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private boolean extendState;
    private boolean lastExtendButtonState;
}
