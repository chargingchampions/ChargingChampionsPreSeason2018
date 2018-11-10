package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlTestMotor extends Command {

    public ControlTestMotor() {
        requires(Robot.testMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.testMotor.onJoystickInput(0,0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.testMotor.onJoystickInput(Robot.m_oi.joystick.getX(), Robot.m_oi.joystick.getY());
    	Robot.testMotor.changeSpeed(Robot.m_oi.joystick.getThrottle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.testMotor.onJoystickInput(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
