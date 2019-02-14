package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.ManualElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private WPI_TalonSRX elevator1;
	private WPI_TalonSRX elevator2;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator() {
		elevator1 = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_LVL_1);
		Robot.initializeMotorManual(elevator1);
		
		elevator2 = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_LVL_2);
		Robot.initializeMotorManual(elevator2);
	}
	
	public void periodic() {
	
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ManualElevator());
    }
    
    public void setElevator1Output(double output) {
    	elevator1.set(ControlMode.PercentOutput, output);
    }
    
    public void setElevator2Output(double output) {
    	elevator2.set(ControlMode.PercentOutput, output);
    }
    
    private double requested;
}

