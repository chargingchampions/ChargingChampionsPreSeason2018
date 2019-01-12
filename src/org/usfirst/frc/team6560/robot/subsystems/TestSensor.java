package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestSensor extends Subsystem {
	public final AnalogInput sensor0;
	public TestSensor()
	{
		sensor0 = new AnalogInput(0);
		sensor0.setAverageBits(4);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	private int counter = 0;
	private double voltage = 0;
	private double distance = 0;
    public void periodic()
    {

        	System.out.println("Voltage: " + getVoltage() + " Distance: " + getDistance());

    }
    
    public double getDistance()
    {
    	return 5 * ( sensor0.getAverageVoltage() / (5.0 / 1024.0)) ;
    }
    
    public double getVoltage()
    {
    	return  sensor0.getAverageVoltage();
    }
}

