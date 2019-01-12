package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestSensor extends Subsystem {
	public final AnalogInput sensorL;
	public final AnalogInput sensorR;
	public TestSensor()
	{
		sensorL = new AnalogInput(0);
		sensorL.setAverageBits(2);
		
		sensorR = new AnalogInput(0);
		sensorR.setAverageBits(2);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void periodic()
    {
    }
    
    // distances are in feet
    
    public double getDistanceL()
    {
    	return getDistance(sensorL.getAverageVoltage());
    }
    
    public double getDistanceR()
    {
    	return getDistance(sensorR.getAverageVoltage());
    }
    
    private double getDistance(double voltage)
    {
    	return (5 * (voltage / (5.0 / 1024.0))) / 304.8;
    }
}

