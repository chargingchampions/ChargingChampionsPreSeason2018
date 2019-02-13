package org.usfirst.frc.team6560.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// drivetrain motors
	public static final int R1_MOTOR = 0;
    public static final int R2_MOTOR = 1;
    
    public static final int L1_MOTOR = 9;
    public static final int L2_MOTOR = 8;
    
    public static final int ELEVATOR_MOTOR = idk;
    public static final int ELEVATOR_LIMIT_SWITCH_TOP = idk;
    public static final int ELEVATOR_LIMIT_SWITCH_BOTTOM = idk;
    
    public static final int GRABBER_BALL_MOTOR = idk;
    public static final int GRABBER_SWINGING_MOTOR = idk;
    
    public static final int REAR_HATCH_SHOOTING_MOTOR = idk;
    public static final int REAR_HATCH_EXTENSION_MOTOR = idk;
        
	public static class Logitech {
		public static final int ID = 0;

		public static final int TRIGGER = 1;
		public static final int GRIP = 2;
		public static final int BUTTON_3 = 3;
		public static final int BUTTON_4 = 4;
		public static final int BUTTON_5 = 5;
		public static final int BUTTON_6 = 6;
		public static final int BUTTON_7 = 7;
	}
	
	public static class Xbox {
		public static final int ID = 1;
		
		public static final int LEFT_JOY_X = 1;
		public static final int LEFT_JOY_Y = 2;
		
		public static final int RIGHT_JOY_X = 4;
		public static final int RIGHT_JOY_Y = 5;
		
		public static final int BUTTON_X = 3;
	}
}
