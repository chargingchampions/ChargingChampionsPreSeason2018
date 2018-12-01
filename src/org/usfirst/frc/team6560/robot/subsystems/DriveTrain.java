package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public static final double RAMP_TIME = 2.0;

	WPI_TalonSRX motorR1;
	WPI_TalonSRX motorR2;
	
	WPI_TalonSRX motorL1;
	WPI_TalonSRX motorL2;
	
	private double velL = 0.0;
	private double velR = 0.0;
		
	public DriveTrain() {
		super();
		
		motorR1 = new WPI_TalonSRX(RobotMap.R1_ID);
		motorR2 = new WPI_TalonSRX(RobotMap.R2_ID);

	    motorL1 = new WPI_TalonSRX(RobotMap.L1_ID);
	    motorL2 = new WPI_TalonSRX(RobotMap.L2_ID);
	    
	    motorL1.setInverted(true);
	    motorL2.setInverted(true);
	    
	    motorR2.follow(motorR1);
	    motorL2.follow(motorL1);
	    
	    motorL1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
	    motorR1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
	    
	    motorL1.configClosedloopRamp(RAMP_TIME, 30);
	    motorR1.configClosedloopRamp(RAMP_TIME, 30);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}
    
//    public void radin(double x, double y){
//    	targetSpeedL = -(y+x);
//    	targetSpeedR = (y-x);
//    }
//
//    public void onJoystickInputAdrin(double x, double y) {
//    	y= -y;
//
//    	if(x>0){
//    		if(y>0.5){
//    			targetSpeedR = y-((1-Math.pow(Math.E, -2*x))/2); 
//    			targetSpeedL = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
//    		}else if(y>=-0.5&&y<=0.5){
//    			targetSpeedR = y-((1-Math.pow(Math.E, -2*x))/0.86); 
//    			targetSpeedL = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
//    		}else if(y<-0.5){
//    			targetSpeedR = y+((1-Math.pow(Math.E, -2*x))/2); 
//    			targetSpeedL = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
//    		}
//    	}
//    	
//    	else if(x<0){
//    		if(y>0.5){
//    			targetSpeedL = y-((1-Math.pow(Math.E, -2*x))/2); 
//    			targetSpeedR = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
//    		}else if(y>=-0.5&&y<=0.5){
//    			targetSpeedL = y-((1-Math.pow(Math.E, -2*x))/0.86); 
//    			targetSpeedR = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
//    		}else if(y<-0.5){
//    			targetSpeedL = y+((1-Math.pow(Math.E, -2*x))/2); 
//    			targetSpeedR = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
//    		}
//    	}
//    	
//    }

	public void updateMotorControllers() {
		System.out.println("Setting 'left, right' side drive to: " + velL + ", " + velR);
    	//passing the ControlMode.Velocity parameter seems to be causing issues
		//temporary fix is to remove it: motorL1.set(scaledVelL);
		motorL1.set(ControlMode.Velocity, velL);
    	motorR1.set(ControlMode.Velocity, velR);
	}

    public void setVelL(double vel) {
    	velL = vel;
    	updateMotorControllers();
    }
    
    public void setVelR(double vel) {
    	velR = vel;
    	updateMotorControllers();
    }
    
    public double getPositionL() {
    	return motorL1.getSelectedSensorPosition(0);
    }
    
    public double getPositionR() {
    	return motorR1.getSelectedSensorPosition(0);
    }
    
    
    public void resetPositions() {
    	motorL1.setSelectedSensorPosition(0, 0, 0); // TODO see if third argument is necessary
    	motorR1.setSelectedSensorPosition(0, 0, 0);
    }
    
    public void stop() {
    	velL = 0.0;
    	velR = 0.0;
    	
    	updateMotorControllers();
    }

	public double getVelL() {
		return motorL1.getSelectedSensorVelocity(0);
	}
	public double getVelR() {
		return motorR1.getSelectedSensorVelocity(0);
	}
	
	
    
}

