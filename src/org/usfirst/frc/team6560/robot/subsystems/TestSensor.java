package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestSensor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void periodic()
    {
    	System.out.println("Voltage: " + getVoltage() + " Distance: " + getDistance());
    }
    
    public double getDistance()
    {
    	return 5 * (Robot.oi.sensor0.getVoltage() / (5.0 / 1024.0)) ;
    }
    
    public double getVoltage()
    {
    	return Robot.oi.sensor0.getVoltage();
    }
}

