package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.ControlMotor;
import org.usfirst.frc.team6560.robot.commands.ControlTestMotor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestMotor extends Subsystem {
	private static final double RAMP_TIME = 2.0;

	WPI_TalonSRX motorR1;
	WPI_TalonSRX motorR2;
	
	WPI_TalonSRX motorL1;
	WPI_TalonSRX motorL2;
		
	public TestMotor() {
		super();
		
		motorR1 = new WPI_TalonSRX(RobotMap.R1_ID);
		motorR2 = new WPI_TalonSRX(RobotMap.R2_ID);

	    motorL1 = new WPI_TalonSRX(RobotMap.L1_ID);
	    motorL2 = new WPI_TalonSRX(RobotMap.L2_ID);
	    
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
		setDefaultCommand(new ControlTestMotor());
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

    public void setVelL(double vel) {
    	motorL1.set(ControlMode.Velocity, vel);
    }
    
    public void setVelR(double vel) {
    	motorR1.set(ControlMode.Velocity, -vel);
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
    	motorL1.set(ControlMode.Velocity, 0);
    	motorR1.set(ControlMode.Velocity, 0);
    }
    
}

