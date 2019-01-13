//package org.usfirst.frc.team6560.robot.commands;
//
//import org.usfirst.frc.team6560.robot.Robot;
//import org.usfirst.frc.team6560.robot.RobotMap;
//
//import com.ctre.phoenix.motorcontrol.ControlMode;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class AutoStraightForever extends Command {
//	// 1st test values: kI 2 * 10^-4
//	double speed;
//	
//	double kF;
//	double kI;
//
//    public AutoStraightForever() {
//        requires(Robot.driveTrain);
//        
//        setInterruptible(true);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	setValues();
//    }
//    
//    private void setValues() {
//    	Robot.driveTrain.motorL1.set(ControlMode.PercentOutput, 0.6);
//    	Robot.driveTrain.motorR1.set(ControlMode.PercentOutput, 0.6);
//
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	System.out.println(Robot.driveTrain.motorL1.getSelectedSensorVelocity() + ", " + Robot.driveTrain.motorR1.getSelectedSensorVelocity());
//
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	Robot.driveTrain.stop();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	Robot.driveTrain.stop();
//
//    }
//}
