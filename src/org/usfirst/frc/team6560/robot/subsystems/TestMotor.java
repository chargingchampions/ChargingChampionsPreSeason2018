package org.usfirst.frc.team6560.robot.subsystems;

import org.usfirst.frc.team6560.robot.RobotMap;
import org.usfirst.frc.team6560.robot.commands.ControlMotor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestMotor extends Subsystem {
   

	WPI_TalonSRX motorR1;
	WPI_TalonSRX motorR2;
	WPI_TalonSRX motorL1;
	WPI_TalonSRX motorL2;
	
	private double speedMultiplyer = 0;
	
	private static double acceleration = 0.01;
	private static double deceleration = 0.01;
	
	private int speedIndex = 0;
	
	private double currentSpeedL = 0.0;
	private double currentSpeedR = 0.0;
	
	private double targetSpeedL = 0.0;
	private double targetSpeedR = 0.0;

	
	public TestMotor() {
		super();
		
		motorR1 = new WPI_TalonSRX(RobotMap.R1_ID);
		motorR2 = new WPI_TalonSRX(RobotMap.R2_ID);

	    motorL1 = new WPI_TalonSRX(RobotMap.L1_ID);
	    motorL2 = new WPI_TalonSRX(RobotMap.L2_ID);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	@Override
	public void periodic() {
		super.periodic();
		
		if(currentSpeedL < targetSpeedL * speedMultiplyer){
			if(currentSpeedL >= 0){
				currentSpeedL += acceleration;
			}else{
				currentSpeedL += deceleration;
			}
		}else{
			if(currentSpeedL <= 0){
				currentSpeedL -= acceleration;

			}else{
				currentSpeedL -= deceleration;

			}
		}
		
		if(currentSpeedR < targetSpeedR * speedMultiplyer){
			if(currentSpeedR >= 0){
				currentSpeedR += acceleration;
			}else{
				currentSpeedR += deceleration;
			}
		}else{
			if(currentSpeedR <= 0){
				currentSpeedR -= acceleration;

			}else{
				currentSpeedR -= deceleration;

			}
		}
		
    	motorR1.set(ControlMode.PercentOutput, currentSpeedR);
    	motorR2.set(ControlMode.PercentOutput, currentSpeedR);
    	motorL1.set(ControlMode.PercentOutput, currentSpeedL);
    	motorL2.set(ControlMode.PercentOutput, currentSpeedL);

	}
	
    public void initDefaultCommand() {
    }
    
    public void radin(double x, double y){
    	targetSpeedL = -(y+x);
    	targetSpeedR = (y-x);
    }

    public void onJoystickInput(double x, double y) {
    	onJoystickInputJack(x, y);
    }

    public void onJoystickInputAdrin(double x, double y) {
    	y= -y;

    	if(x>0){
    		if(y>0.5){
    			targetSpeedR = y-((1-Math.pow(Math.E, -2*x))/2); 
    			targetSpeedL = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
    		}else if(y>=-0.5&&y<=0.5){
    			targetSpeedR = y-((1-Math.pow(Math.E, -2*x))/0.86); 
    			targetSpeedL = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
    		}else if(y<-0.5){
    			targetSpeedR = y+((1-Math.pow(Math.E, -2*x))/2); 
    			targetSpeedL = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
    		}
    	}
    	
    	else if(x<0){
    		if(y>0.5){
    			targetSpeedL = y-((1-Math.pow(Math.E, -2*x))/2); 
    			targetSpeedR = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
    		}else if(y>=-0.5&&y<=0.5){
    			targetSpeedL = y-((1-Math.pow(Math.E, -2*x))/0.86); 
    			targetSpeedR = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
    		}else if(y<-0.5){
    			targetSpeedL = y+((1-Math.pow(Math.E, -2*x))/2); 
    			targetSpeedR = Math.pow(Math.abs(x)+Math.abs(y), 0.5);
    		}
    	}
    	
    }

    public static final double turnSpeed = 0.5;

    public void onJoystickInputJack(double x, double y) {
    	y = -y;
        double radius = Math.sqrt(x*x + y*y);
        double t = Math.atan2(y, x);

        if (radius < 0.05) {
            targetSpeedL = 0;
            targetSpeedR = 0;
            return;
        }

        double s = turnSpeed / 2;

        double cosSign = Math.copySign(1.0, Math.cos(t));
        double sinSign = Math.copySign(1.0, Math.sin(t));
        double tanSign = Math.copySign(1.0, Math.tan(t));

        double funcVal = Math.cos(2*t);

        double lFactor = -cosSign * (s + tanSign * 0.5) * funcVal - cosSign * s + sinSign * 0.5;
        double rFactor = cosSign * (s - tanSign * 0.5) * funcVal + cosSign * s + sinSign * 0.5;

        targetSpeedL = lFactor * radius;
        targetSpeedR = -rFactor * radius;
        
        System.out.println("hello");
    }
    
    public void changeSpeed(double speedGoal) {
    	speedMultiplyer = (speedGoal-1)/(2);
    	
    }
    
    
}

