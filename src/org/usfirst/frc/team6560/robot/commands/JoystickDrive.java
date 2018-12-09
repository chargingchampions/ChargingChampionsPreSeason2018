package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickDrive extends Command {
	public static final double TURN_SPEED = 0.5;
	public static final double MAX_SPEED = 10;

    public JoystickDrive() {
        requires(Robot.driveTrain);
        setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Running JoystickDrive command...");
    	Robot.driveTrain.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
    	double x = -Robot.oi.logitechJoystick.getX();
    	double y = Robot.oi.logitechJoystick.getY();
    	
    	double multiplier = (Robot.oi.logitechJoystick.getThrottle() + 1.0) / 2 * MAX_SPEED;
    	
        double radius = Math.sqrt(x*x + y*y);
        double t = Math.atan2(y, x);

        if (radius < 0.05) {
            Robot.driveTrain.stop();
            return;
        }

        double s = TURN_SPEED / 2;

        double cosSign = Math.copySign(1.0, Math.cos(t));
        double sinSign = Math.copySign(1.0, Math.sin(t));
        double tanSign = Math.copySign(1.0, Math.tan(t));

        double funcVal = Math.cos(2*t);

        double lFactor = -cosSign * (s + tanSign * 0.5) * funcVal - cosSign * s + sinSign * 0.5;
        double rFactor = cosSign * (s - tanSign * 0.5) * funcVal + cosSign * s + sinSign * 0.5;
        
        Robot.driveTrain.setVelL(lFactor * radius * multiplier);
        Robot.driveTrain.setVelR(rFactor * radius * multiplier);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
