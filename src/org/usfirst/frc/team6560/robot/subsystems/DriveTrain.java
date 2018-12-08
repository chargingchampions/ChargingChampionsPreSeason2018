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
	public static final double UNITS_PER_FOOT = 4096 / (Math.PI / 2.0);
	public static final double RAMP_TIME = 0;

	public WPI_TalonSRX motorR1;
	WPI_TalonSRX motorR2;
	
	public WPI_TalonSRX motorL1;
	WPI_TalonSRX motorL2;
	
	private double velL = 0.0;
	private double velR = 0.0;
		
	public DriveTrain() {
		super();
		
		motorR1 = new WPI_TalonSRX(RobotMap.R1_ID);
		motorR2 = new WPI_TalonSRX(RobotMap.R2_ID);

	    motorL1 = new WPI_TalonSRX(RobotMap.L1_ID);
	    motorL2 = new WPI_TalonSRX(RobotMap.L2_ID);
	    
	    motorL1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
	    motorR1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);

	    
	    motorL1.config_kF(0, 0);
	    motorR1.config_kF(0, 0);
	    
	    motorL1.config_kP(0, 0);
	    motorR1.config_kP(0, 0);
	   
	    motorL1.config_kD(0, 0);
	    motorR1.config_kD(0, 0);
	    
	    motorR1.config_kI(0, 0.001);
	    motorL1.config_kI(0, 0.001);


	    motorL1.setSensorPhase(true);
	    
	    motorR1.setInverted(true);
	    motorR2.setInverted(true);
	    
	    motorR1.setSensorPhase(true);
	    
	    motorR2.follow(motorR1);
	    motorL2.follow(motorL1);
	    
	    
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
		motorL1.set(ControlMode.Velocity, velL);
    	motorR1.set(ControlMode.Velocity, velR);
	}
	
	public void setDirectOutputL(double output) {
		motorL1.set(ControlMode.PercentOutput, output);
	}
	public void setDirectOutputR(double output) {
		motorR1.set(ControlMode.PercentOutput, output);
	}

	/**
	 * 
	 * @param vel in ft/s
	 */
    public void setVelL(double vel) {
    	velL = vel*UNITS_PER_FOOT/10;
    	updateMotorControllers();
    }
    
    /**
     * 
     * @param vel in ft/s
     */
    public void setVelR(double vel) {
    	velR = vel*UNITS_PER_FOOT/10;
    	updateMotorControllers();
    }
    
    /**
     * 
     * @return encoder distance in feet
     */
    public double getEncoderPositionL() {
    	return motorL1.getSelectedSensorPosition(0) /  UNITS_PER_FOOT;
    }
    
    /**
     * 
     * @return encoder distance in feet
     */
    public double getEncoderPositionR() {
    	return motorR1.getSelectedSensorPosition(0) /  UNITS_PER_FOOT;
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

    /**
     * 
     * @return vel in ft/s
     */
	public double getVelL() {
		return motorL1.getSelectedSensorVelocity(0) * 10 / UNITS_PER_FOOT;
	}
	
	/**
	 * 
	 * @return vel in ft/s
	 */
	public double getVelR() {
		return motorR1.getSelectedSensorVelocity(0) * 10 / UNITS_PER_FOOT;
	}
	
	
    
}

