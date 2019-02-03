package org.usfirst.frc.team6560.robot.commands.vision;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.commands.AutoTurnAngleWithEncoders;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurnToTarget extends Command {
		
    public AutoTurnToTarget() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double distance = Robot.nt.getEntry("distance").getDouble(0.0);
    	double angle = Math.PI / 2 - Robot.nt.getEntry("angle").getDouble(0.0);
    	
    	if (distance == 0.0)
    	{
    		cancel = true;
    		return;
    	}
    	
    	double target_x = distance * Math.cos(angle);
    	double target_y = distance * Math.sin(angle);
    	
    	double relative_x = target_x + AutoVisionGroup.CAMERA_OFFSET_X;
    	double relative_y = target_y + AutoVisionGroup.CAMERA_OFFSET_Y;
    	
    	double relative_angle = Math.atan(relative_y / relative_x);
    	if (relative_angle < 0)
    	{
    		relative_angle += Math.PI;
    	}
    	
    	double turn_angle =  relative_angle - Math.PI / 2;
    	    	
    	turnCommand = new AutoTurnAngleWithEncoders(turn_angle * 180 / Math.PI, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	turnCommand.execute();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return turnCommand.isFinished() || cancel;
    }

    // Called once after isFinished returns true
    protected void end() {
    	turnCommand.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	turnCommand.interrupted();
    }
    
    private AutoTurnAngleWithEncoders turnCommand;
    private boolean cancel;
}
