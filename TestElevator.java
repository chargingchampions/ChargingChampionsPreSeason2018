package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.AutoElevatorMove;
import org.usfirst.frc.team6560.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestElevator extends Subsystem {
	public WPI_TalonSRX eleL;//left elevator motor
	public WPI_TalonSRX eleR;//right elevator motor
	public WPI_TalonSRX eleE;//elevator extend
	
	public TestElevator(){
		super();
		eleL = new WPI_TalonSRX(RobotMap.AL_ID);
		eleR = new WPI_TalonSRX(RobotMap.AR_ID);
		eleE = new WPI_TalonSRX(RobotMap.AR_ID);
		
		eleL.config_kF(0, 0.483307086);
		eleR.config_kF(0, 0.483307086);
		eleE.config_kF(0, 0.483307086);
	
		eleL.config_kP(0, 0);
		eleR.config_kP(0, 0);
		eleE.config_kP(0, 0);
	
		eleL.config_kD(0, 0);
		eleR.config_kD(0, 0);
		eleE.config_kD(0, 0);
	    
		eleL.config_kI(0, 0);
		eleR.config_kI(0, 0);
		eleE.config_kI(0, 0);
	    
		eleL.configOpenloopRamp(1, 30);
		eleR.configOpenloopRamp(1, 30);
		eleE.configOpenloopRamp(1, 30);
		
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new AutoElevatorMove());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

