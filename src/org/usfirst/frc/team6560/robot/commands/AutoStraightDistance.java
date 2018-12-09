package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


public class AutoStraightDistance extends AutoBase {
	private static final double speed = 4;
	private static final double slowSpeed = 0.7;
		
    /**
     * 
     * @param distance in ft
     * @param index of speed to use
     */
	public AutoStraightDistance(double distance, double speedIndex) {
       super(speed, slowSpeed, distance, false);
    }

    
}
