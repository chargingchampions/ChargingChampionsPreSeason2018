package org.usfirst.frc.team6560.robot.util;

import org.usfirst.frc.team6560.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

public class ElevatorLevel {	
	WPI_TalonSRX motor;
	
	DigitalInput limTop;
	DigitalInput limBottom;
	
	public ElevatorLevel(int motorId, int limTopId, int limBottomId) {
		motor = new WPI_TalonSRX(motorId);
		Robot.initializeMotorManual(motor, 0.2);
		motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
		
		limTop = new DigitalInput(limTopId);
		limBottom = new DigitalInput(limBottomId);
	}
	
	public void update() {
		if ((!limTop.get() && requested > 0) || (!limBottom.get() && requested < 0)) {
			motor.set(ControlMode.PercentOutput, requested);
		} else {
			motor.set(ControlMode.PercentOutput, 0);
		}
	}
	
	public void setOutput(double output) {
		requested = output;
	}
	
	public boolean getLimTop() {
		return limTop.get();
	}
	
	public boolean getLimBottom() {
		return limBottom.get();
	}
	
	public int getPosition() {
		return motor.getSelectedSensorPosition(0);
	}
	
	public void setPosition(int pos) {
		motor.setSelectedSensorPosition(pos, 0, 30);
	}
	
	private double requested;
}
