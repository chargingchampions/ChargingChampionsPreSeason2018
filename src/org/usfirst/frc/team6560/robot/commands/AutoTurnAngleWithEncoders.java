package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


public class AutoTurnAngleWithEncoders extends AutoBase {
	private static final double radius = 1.212;

	private static final double speed = 1;
	private static final double slowSpeed = 0.2;

		
    /**
     * 
     * @param angle in degrees
     * @param index of speed to use
     */
	public AutoTurnAngleWithEncoders(double angle, double speedIndex) {
       super(speed, slowSpeed, (angle/360)*2*Math.PI*radius, true);
    }
}
