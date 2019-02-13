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
	private WPI_TalonSRX elevator;
	
	private DigitalInput limTop;
	private DigitalInput limBottom;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator() {
		elevator = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR);
		Robot.initializeMotorManual(elevator);
		
		limTop = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SWITCH_TOP);
		limBottom = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SWITCH_BOTTOM);
		
		requested = 0;
	}
	
	public void periodic() {
		if (requested > 0 && !limTop.get()) {
			elevator.set(ControlMode.PercentOutput, requested);
		} else if (requested < 0 && !limBottom.get()) {
			elevator.set(ControlMode.PercentOutput, requested);
		} else {
			elevator.set(ControlMode.PercentOutput, 0);
		}
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ManualElevator());
    }
    
    public void setElevatorOutput(double output) {
    	requested = output;
    }
    
    private double requested;
}

