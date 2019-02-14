package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.ManualRearHatch;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RearHatch extends Subsystem {
	private Solenoid extend;
	private Solenoid shoot;
	
	public RearHatch() {
		extend = new Solenoid(RobotMap.REAR_HATCH_EXTENSION_SOLENOID);
		shoot = new Solenoid(RobotMap.REAR_HATCH_SHOOTING_SOLENOID);
		
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new ManualRearHatch());
    }
    
    public void setExtend(boolean b) {
    	extend.set(b);
    }
    
    public void setShoot(boolean b) {
    	shoot.set(b);
    }
}

