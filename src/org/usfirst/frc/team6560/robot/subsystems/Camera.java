package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.networktables.ConnectionInfo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void periodic() {
		ConnectionInfo[] connections = Robot.nt.getConnections();
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

