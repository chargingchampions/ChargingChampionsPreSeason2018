//package org.usfirst.frc.team6560.robot.commands;
//
//import org.usfirst.frc.team6560.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.Scheduler;
//
///**
// *
// */
//public class AutoAlignToWall extends Command {
//	private static final int SAMPLES = 10;
//	private static final double SENSOR_SEPARATION = 9.3 / 12.0;
//
//	private int samples;
//	
//	private double sensorTotalL;
//	private double sensorTotalR;
//	
//	private boolean sensingFinished;
//
//    public AutoAlignToWall() {
//
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	samples = 0;
//    	
//    	sensorTotalL = 0;
//    	sensorTotalR = 0;
//    	
//    	sensingFinished = false;
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	if (samples < SAMPLES)
//    	{
//    		sensorTotalL += Robot.testSensor.getDistanceL();
//    		sensorTotalR += Robot.testSensor.getDistanceR();
//    		
//    		++samples;
//    	}
//    	else
//    	{
//    		sensingFinished = true;
//    	}
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return sensingFinished;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	double sensorAvgL = sensorTotalL / samples;
//    	double sensorAvgR = sensorTotalR / samples;
//    	
//    	double sensorDiff = sensorAvgR - sensorAvgL;
//    	
//    	double angle = Math.atan(sensorDiff / SENSOR_SEPARATION);
//    	
//    	System.out.println("L: " + sensorAvgL + " " + "R: " + sensorAvgR + " Angle: " + angle * 180 / Math.PI);
//
//    	// Scheduler.getInstance().add(new AutoTurnAngleWithEncoders(angle * 180 / Math.PI, 0));
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
