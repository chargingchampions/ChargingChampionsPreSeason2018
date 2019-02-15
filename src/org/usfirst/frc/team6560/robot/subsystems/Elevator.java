package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.ManualElevatorLimitSwitch;
import org.usfirst.frc.team6560.robot.util.ElevatorLevel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private ElevatorLevel level1;
	private ElevatorLevel level2;
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator() {
		level1 = new ElevatorLevel(
				RobotMap.ELEVATOR_LEVEL_1_MOTOR,
				RobotMap.ELEVATOR_LEVEL_1_LIMIT_SWITCH_TOP,
				RobotMap.ELEVATOR_LEVEL_1_LIMIT_SWITCH_BOTTOM);
		level2 = new ElevatorLevel(
				RobotMap.ELEVATOR_LEVEL_2_MOTOR,
				RobotMap.ELEVATOR_LEVEL_2_LIMIT_SWITCH_TOP,
				RobotMap.ELEVATOR_LEVEL_2_LIMIT_SWITCH_BOTTOM);
	}
	
	public void periodic() {
		level1.update();
		level2.update();
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ManualElevatorLimitSwitch());
    }
    
    public ElevatorLevel getLevel1() {
    	return level1;
    }
    
    public ElevatorLevel getLevel2() {
    	return level2;
    }
    
    public ElevatorLevel getLevel(int i) {
    	if (i == 1) {
    		return level1;
    	} else if (i == 2) {
    		return level2;
    	} else {
    		throw new RuntimeException("Invalid level");
    	}
    }
}

