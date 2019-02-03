//package org.usfirst.frc.team6560.robot.commands;
//
//import org.usfirst.frc.team6560.robot.Robot;
//
//import com.ctre.phoenix.motorcontrol.ControlMode;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class AutoArmTurn extends Command {
//
//    public AutoArmTurn() {
//    	requires(Robot.testArm);
//        
//        setInterruptible(true);
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    }
//
//    public void setValues() {
//    	
//    }
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	double z = Robot.oi.logitechJoystick.getZ();
//    	Robot.testArm.armL.set(ControlMode.PercentOutput, z/2);
//    	Robot.testArm.armR.set(ControlMode.PercentOutput, -z/2);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	Robot.testArm.armL.set(ControlMode.PercentOutput, 0);
//    	Robot.testArm.armR.set(ControlMode.PercentOutput, 0);
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	end();
//    }
//}
