package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;
import org.usfirst.frc.team6560.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


public class AutoStraightDistance extends AutoBase {
	private static final double speed = 4;
	private static final double slowSpeed = 0.7;
	
	private double lastAccumulationDistance;
	private double accumulatedError;
		
    /**
     * 
     * @param distance in ft
     * @param index of speed to use
     */
	public AutoStraightDistance(double distance, double speedIndex) {
       super(speed, slowSpeed, distance, false);
    }
	
	@Override
	protected void initialize() {
		lastAccumulationDistance = getDistanceTraveledAvg();
		accumulatedError = 0;
	}
	
	@Override
	protected void execute() {
		super.execute();
		
		accumulatedError += (getDistanceTraveledAvg() - lastAccumulationDistance) * Math.sin(getAngleError());
		lastAccumulationDistance = getDistanceTraveledAvg();
		
		System.out.println(accumulatedError);
	}
	
	private double getAngleError() {
		return (getDistanceTraveledR() - getDistanceTraveledL()) / radius;
	}
}
