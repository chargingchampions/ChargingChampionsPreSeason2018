package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.JoystickElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private WPI_TalonSRX elevator;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator() {
		elevator = new WPI_TalonSRX(RobotMap.ELEVATOR);

		elevator.config_kF(0, 0);
	    elevator.config_kP(0, 0);
	    elevator.config_kD(0, 0);
	    elevator.config_kI(0, 0);
	    	    
	    elevator.configOpenloopRamp(2, 100);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickElevator());
    }
    
    public void setRawMotorOutput(double percent) {
    	elevator.set(ControlMode.PercentOutput, percent);
    }
    
}

