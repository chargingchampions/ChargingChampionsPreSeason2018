package org.usfirst.frc.team6560.robot.commands.elevator_calibration;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.util.ElevatorLevel;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveDownAllTheWay extends Command {
	public static final double OUTPUT = 0.2;
	private final int levelIndex;
	
	private ElevatorLevel level;

    public MoveDownAllTheWay(int levelIndex) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.levelIndex = levelIndex;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	level = Robot.elevator.getLevel(levelIndex);
    	level.setOutput(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	level.setOutput(-OUTPUT);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return level.getLimBottom();
    }

    // Called once after isFinished returns true
    protected void end() {
    	level.setPosition(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
