package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevator extends Command {
	public static final double ELEVATOR_MAX_OUTPUT = 0.2;

    public ManualElevator() {
    	requires(Robot.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.setElevator1Output(0);
    	Robot.elevator.setElevator2Output(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double y1 = Robot.oi.xbox.getRawAxis(RobotMap.Xbox.LEFT_JOY_Y);
    	
    	if (Math.abs(y1) > 0.1) {
    		Robot.elevator.setElevator1Output(Math.min(y1 * ELEVATOR_MAX_OUTPUT, ELEVATOR_MAX_OUTPUT));
    	} else {
    		Robot.elevator.setElevator1Output(0);
    	}
    	
    	double y2 = Robot.oi.xbox.getRawAxis(RobotMap.Xbox.RIGHT_JOY_Y);
    	
    	if (Math.abs(y2) > 0.1) {
    		Robot.elevator.setElevator2Output(Math.min(y2 * ELEVATOR_MAX_OUTPUT, ELEVATOR_MAX_OUTPUT));
    	} else {
    		Robot.elevator.setElevator2Output(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setElevator1Output(0);
    	Robot.elevator.setElevator2Output(0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
