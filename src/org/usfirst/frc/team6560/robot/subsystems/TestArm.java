//package org.usfirst.frc.team6560.robot.subsystems;
//
//import org.usfirst.frc.team6560.robot.RobotMap;
//import org.usfirst.frc.team6560.robot.commands.AutoArmTurn;
//import org.usfirst.frc.team6560.robot.commands.JoystickDrive;
//
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */
//public class TestArm extends Subsystem {
//	
//	public WPI_TalonSRX armL;
//	public WPI_TalonSRX armR;
//	
//	public TestArm(){
//		super();
//		armL = new WPI_TalonSRX(RobotMap.AL_ID);
//		armR = new WPI_TalonSRX(RobotMap.AR_ID);
//		
//		armL.config_kF(0, 0.483307086);
//		armR.config_kF(0, 0.483307086);
//
//	    armL.config_kP(0, 0);
//	    armR.config_kP(0, 0);
//
//	    armL.config_kD(0, 0);
//	    armR.config_kD(0, 0);
//	    
//	    armL.config_kI(0, 0);
//	    armR.config_kI(0, 0);
//	    
//	    armL.configOpenloopRamp(1, 30);
//	    armR.configOpenloopRamp(1, 30);
//		
//	}
//
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//
//    public void initDefaultCommand() {
//    	setDefaultCommand(new AutoArmTurn());
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    }
//}
//
