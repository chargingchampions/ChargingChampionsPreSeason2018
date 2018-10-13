package org.usfirst.frc.team6560.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team6560.robot.RobotMap.CAN;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Motor extends Subsystem {

	public static double globalMotorSpeed;

	WPI_TalonSRX motor;



	public Motor() {
		globalMotorSpeed = 0.5;

		motor = new WPI_TalonSRX(0);

		motor.setSafetyEnabled(false);

	}

	/**
	 * sets the speeds of the drive train motors, positive is forward
	 * 
	 * @param left
	 * @param right
	 */
	public void setSpeed(double speed) {
		motor.set(speed*globalMotorSpeed);
	}
	


	public void increaseMotorSpeed() {
		if (globalMotorSpeed + 0.1 <= 1.0) {
			globalMotorSpeed += 0.1;
		}
	}

	public void decreaseMotorSpeed() {
		if (globalMotorSpeed - 0.1 >= 0.1) {
			globalMotorSpeed -= 0.1;
		}
	}

	public void initDefaultCommand() {
		setDefaultCommand(new org.usfirst.frc.team6560.robot.commands.ControlMotor());
	}

}
