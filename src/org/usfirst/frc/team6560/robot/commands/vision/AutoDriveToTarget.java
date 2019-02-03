package org.usfirst.frc.team6560.robot.commands.vision;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.commands.AutoStraightDistance;
import org.usfirst.frc.team6560.robot.commands.AutoTurnAngleWithEncoders;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveToTarget extends Command {
    public AutoDriveToTarget() {
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
    	
    	double relative_distance = Math.sqrt(relative_x * relative_x + relative_y * relative_y);
    	    	    	
    	driveCommand = new AutoStraightDistance(relative_distance - AutoVisionGroup.WALL_PADDING, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveCommand.execute();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return driveCommand.isFinished() || cancel;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveCommand.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveCommand.interrupted();
    }
    
    private AutoStraightDistance driveCommand;
    private boolean cancel = false;
}
