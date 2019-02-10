package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
	private WPI_TalonSRX fork;
	
	public Grabber() {
		fork = new WPI_TalonSRX(RobotMap.FORK_MOTOR);
		
		fork.config_kF(0, 0);
		fork.config_kP(0, 0);
		fork.config_kD(0, 0);
		fork.config_kI(0, 0);
	    	    
		fork.configOpenloopRamp(2, 100);
	}
	
	public void setForkOutput(double output) {
    	fork.set(ControlMode.PercentOutput, output);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        
    }
}

