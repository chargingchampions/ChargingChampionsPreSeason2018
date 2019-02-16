package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.ManualGrabber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
	private WPI_TalonSRX swing;
	private WPI_TalonSRX ball;
	
	public Grabber() {
		swing = new WPI_TalonSRX(RobotMap.GRABBER_SWINGING_MOTOR);
		
		ball = new WPI_TalonSRX(RobotMap.GRABBER_BALL_MOTOR);
	}
	
	public void setSwingOutput(double output) {
		swing.set(ControlMode.PercentOutput, output);
    }
	
	public void setBallOutput(double output) {
		ball.set(ControlMode.PercentOutput, output);
	}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new ManualGrabber());
    }
}

