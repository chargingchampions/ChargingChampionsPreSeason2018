package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.util.ElevatorLevel;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevatorLimitSwitch extends Command {
	public static final double ELEVATOR_MAX_OUTPUT = 0.2;

    public ManualElevatorLimitSwitch() {
    	requires(Robot.elevator);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.getLevel1().setOutput(0);
    	Robot.elevator.getLevel2().setOutput(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double y = Robot.oi.xbox.getRawAxis(RobotMap.Xbox.RIGHT_JOY_Y);
    	
    	if (Math.abs(y) > 0.1) {
    		setElevator(y);
    	} else {
    		setElevator(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.getLevel1().setOutput(0);
    	Robot.elevator.getLevel2().setOutput(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private void setElevator(double output) {    	
    	ElevatorLevel level1 = Robot.elevator.getLevel1();
    	ElevatorLevel level2 = Robot.elevator.getLevel2();
    	    	
    	if (output >= 0) {
        	if (!level2.getLimTop()) {
        		level1.setOutput(0);
        		level2.setOutput(output);
        	} else if (!level1.getLimTop()) {
        		level1.setOutput(output);
        		level2.setOutput(0);
        	} else {
        		level1.setOutput(0);
        		level2.setOutput(0);
        	}
    	} else {
        	if (!level1.getLimBottom()) {
        		level1.setOutput(output);
        		level2.setOutput(0);
        	} else if (!level2.getLimBottom()) {
        		level1.setOutput(0);
        		level2.setOutput(output);
        	} else {
        		level1.setOutput(0);
        		level2.setOutput(0);
        	}
    	}
    }
}
