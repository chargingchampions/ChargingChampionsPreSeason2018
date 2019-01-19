package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutoElevatorMove extends Command {
	
	private boolean boundaryBot = true; // has the elevator touched the bottom when the arm is out?
	private boolean boundaryMid = true; // has the elevator touched the bottom when the arm is in?
	private boolean boundaryTop = false; //has the elevator gone to the top?
	private boolean boundaryIn = true;
	private boolean boundaryOut = false;
	
	private int canLower = 0; //can the elevator come down further?
	private int canHigher = 1; //can the elevator go up further?
	private int canExtend = 1; // can the arm go out more?
	private int canRetract = 0; // can the arm come in more?
	
	
	private static final double correctionFactor = 2.5;

	private final double speed;
	private final double slowSpeed;
	private final double distance;
	private final boolean invertL;
	
	private final double slowDistance;
	private final double direction;
	
	private double startPositionL;
	private double startPositionR;
	
	
    public AutoElevatorMove(){//double speed, double slowSpeed, double distance, boolean invertL){
    	requires(Robot.testElevator);
        
        setInterruptible(true);
        
        this.speed = 2.0;
		this.slowSpeed = 2.0;
		this.distance = Math.abs(2.0);
		this.invertL = true;
		
//		this.speed = speed;
//		this.slowSpeed = slowSpeed;
//		this.distance = Math.abs(distance);
//		this.invertL = invertL;
		
		this.slowDistance = this.distance - 1 * speed;
	    this.direction = (distance >= 0.0) ? 1.0 : -1.0;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    public void setValues() {
    	
    }
    // Called just before this Command runs the first time
    protected void initialize() {
Robot.driveTrain.setAutonomous();
    	startPositionL = Robot.driveTrain.getEncoderPositionL();
    	startPositionR = Robot.driveTrain.getEncoderPositionR();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int button = 2;
    	
    	preventCrash();
    	if(boundaryBot == true){
	    	if(button == 1){
	        	Robot.testElevator.eleL.set(ControlMode.PercentOutput, 50*canHigher);
	        	Robot.testElevator.eleR.set(ControlMode.PercentOutput, 50*canHigher);
	    	}else if(button == 2){
	    		
	    	}else if(button == 3){
	    		
	    	}else if(button == 4){
	    		
	    	}else if(button == 5){
	    		
	    	}else if(button == 6){
	    		
	    	}
    	}
    	
//    	double z = Robot.oi.logitechJoystick.getZ();
//    	Robot.testElevator.eleL.set(ControlMode.PercentOutput, z/2);
//    	Robot.testElevator.eleR.set(ControlMode.PercentOutput, -z/2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.testElevator.eleL.set(ControlMode.PercentOutput, 0);
    	Robot.testElevator.eleR.set(ControlMode.PercentOutput, 0);
    	//Robot.testElevator.eleE.set(ControlMode.PercentOutput, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    protected void preventCrash() { //prevents elevator from damaging robot
    	if(boundaryBot == true || (boundaryMid == true && boundaryIn == true)){
    		canLower = 0;
    	}else{
    		canLower = 1;
    	}
    	
    	if(boundaryTop == true){
    		canHigher = 0;
    	}
    	else{
    		canHigher = 1;
    	}
    	
    	if(boundaryIn == true || (boundaryBot == true)){
    		canRetract = 0;
    	}else{
    		canRetract = 1;
    	}
    	
    	if(boundaryOut == true){
    		canExtend = 0;
    	}else{
    		canExtend = 1;
    	}
    }
    
    private void drive(double motorSpeed) {
    	double errorL = Math.max(0, getDistanceTraveledL() - getDistanceTraveledR()); // errorL is how many units the left wheel is ahead of the right wheel; errorL is 0 if it is not ahead
		double errorR = Math.max(0, getDistanceTraveledR() - getDistanceTraveledL()); // errorR is how many units the right wheel is ahead of the left wheel; errorR is 0 if it is not ahead
		
    	Robot.driveTrain.setVelL(Math.max(motorSpeed * 0.9, motorSpeed - errorL * correctionFactor) * (invertL ? -direction : direction));
    	Robot.driveTrain.setVelR(Math.max(motorSpeed * 0.9, motorSpeed - errorR * correctionFactor) * direction);
    }
    
    private double getDistanceTraveledAvg()
    {
    	return (getDistanceTraveledL() + getDistanceTraveledR()) / 2.0;
    }
    
    private double getDistanceTraveledL()
    {
    	return Math.abs(Robot.driveTrain.getEncoderPositionL() - startPositionL);
    }
    
    private double getDistanceTraveledR()
    {
    	return Math.abs(Robot.driveTrain.getEncoderPositionR() - startPositionR);
    }
}
