//package org.usfirst.frc.team6560.robot.commands;
//
//import org.usfirst.frc.team6560.robot.Robot;
//import org.usfirst.frc.team6560.robot.RobotMap;
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
//    	speed = 0.0;
//    	kF = 0.0;
//    	//kI = 2.0E-4;
//    	setValues();
//    }
//    
//    private void setValues() {
//    	
//    	Robot.driveTrain.motorL1.config_kF(0, kF);
//    	Robot.driveTrain.motorR1.config_kF(0, kF);
//    	
//    	Robot.driveTrain.motorL1.config_kI(0, kI);
//    	Robot.driveTrain.motorR1.config_kI(0, kI);
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	System.out.println("kF: " + kF + " kI: " + kI);
//
//    	if (Math.abs(Robot.oi.logitechJoystick.getY()) > 0.2) {
//    		
//    		if (Robot.oi.logitechJoystick.getRawButton(RobotMap.Joysticks.SECOND_BUTTON_5)) {
//        		kF += 0.0001 * Robot.oi.logitechJoystick.getY();
//        		setValues();
//        	}
//        	
//    		else if (Robot.oi.logitechJoystick.getRawButton(RobotMap.Joysticks.SECOND_BUTTON_3)) {
//        		kI += 0.00001 * Robot.oi.logitechJoystick.getY();
//        		setValues();
//        	}
//        	else {
//        		speed += Robot.oi.logitechJoystick.getY();
//        	}
//    	}
//
//    	
//    	Robot.driveTrain.setVelL(speed);
//    	Robot.driveTrain.setVelR(speed);
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
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
