package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlTestMotor extends Command {
	public static final double TURN_SPEED = 0.5;

    public ControlTestMotor() {
        requires(Robot.testMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.testMotor.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.testMotor.setSpeedMultiplier(0.5);
    	
    	double x = Robot.oi.getLeftXAxis();
    	double y = Robot.oi.getLeftYAxis();
    	
        double radius = Math.sqrt(x*x + y*y);
        double t = Math.atan2(y, x);

        if (radius < 0.05) {
            Robot.testMotor.stop();
            return;
        }

        double s = TURN_SPEED / 2;

        double cosSign = Math.copySign(1.0, Math.cos(t));
        double sinSign = Math.copySign(1.0, Math.sin(t));
        double tanSign = Math.copySign(1.0, Math.tan(t));

        double funcVal = Math.cos(2*t);

        double lFactor = -cosSign * (s + tanSign * 0.5) * funcVal - cosSign * s + sinSign * 0.5;
        double rFactor = cosSign * (s - tanSign * 0.5) * funcVal + cosSign * s + sinSign * 0.5;

        Robot.testMotor.setVelL(lFactor * radius);
        Robot.testMotor.setVelR(rFactor * radius);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.testMotor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
