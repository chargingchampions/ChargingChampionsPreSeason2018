package org.usfirst.frc.team6560.robot;

import org.usfirst.frc.team6560.robot.RobotMap.Joysticks;
import org.usfirst.frc.team6560.robot.commands.AutoStraightDistance;
import org.usfirst.frc.team6560.robot.commands.AutoTurnAngleWithEncoders;
import org.usfirst.frc.team6560.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final Joystick logitechJoystick;
	public final AnalogInput sensor0;
	
	public OI() {
		logitechJoystick = new Joystick(Joysticks.LOGITECH_JOYSTICK_ID);
		sensor0 = new AnalogInput(0);
//		JoystickButton aButton = new JoystickButton(gamepad, Joysticks.A_BUTTON);
//		JoystickButton bButton = new JoystickButton(gamepad, Joysticks.B_BUTTON);
//		JoystickButton xButton = new JoystickButton(gamepad, Joysticks.X_BUTTON);
//		JoystickButton yButton = new JoystickButton(gamepad, Joysticks.Y_BUTTON);
//		JoystickButton leftIndex = new JoystickButton(gamepad, Joysticks.LEFT_INDEX_BUTTON);
//		JoystickButton rightIndex = new JoystickButton(gamepad, Joysticks.RIGHT_INDEX_BUTTON);
//		JoystickButton backButton = new JoystickButton(gamepad, Joysticks.BACK_BUTTON);
//		JoystickButton startButton = new JoystickButton(gamepad, Joysticks.START_BUTTON);
//		JoystickButton leftAxisButton = new JoystickButton(gamepad, Joysticks.LEFT_AXIS_BUTTON);
//		JoystickButton rightAxisButton = new JoystickButton(gamepad, Joysticks.RIGHT_AXIS_BUTTON);

		JoystickButton secondTrigger = new JoystickButton(logitechJoystick, Joysticks.SECOND_TRIGGER_BUTTON);
		JoystickButton secondRightThumb = new JoystickButton(logitechJoystick, Joysticks.SECOND_RIGHT_THUMB_BUTTON);
		JoystickButton secondButton3 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_3);
		JoystickButton secondButton4 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_4);
		JoystickButton secondButton5 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_5);
		JoystickButton secondButton6 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_6);
		JoystickButton secondButton7 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_7);
		JoystickButton secondButton8 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_8);
		JoystickButton secondButton9 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_9);
		JoystickButton secondButton10 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_10);
		JoystickButton secondButton11 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_11);
		JoystickButton secondButton12 = new JoystickButton(logitechJoystick, Joysticks.SECOND_BUTTON_12);
		
		secondButton10.whenPressed(new JoystickDrive());
		secondButton7.whenPressed(new AutoTurnAngleWithEncoders(90, 1));
		secondButton8.whenPressed(new AutoTurnAngleWithEncoders(-90, 1));

		secondButton12.whenPressed(new AutoStraightDistance(10, 10));
		secondButton11.whenPressed(new AutoStraightDistance(-10, 10));

				// drive buttons
		// i.e. yButton.whileHeld(new TankDriveStraight(0.5));

		// PID buttons
		/**
		secondButton3.whenPressed(new PIDSetIntake());
		secondButton4.whenPressed(new PIDSetSwitch());
		secondButton6.whenPressed(new PIDSetScale());
		secondButton5.whenPressed(new PIDSetDefault());
		**/
		
		
		/**
		secondButton11.whileHeld(new RotateSecondClimberIn());
		secondButton12.whileHeld(new RotateSecondClimberOut());
		**/
		
		
		//hold to go to safety
		//secondButton3.whenPressed(new RotateGrabberInSafety());

	}

}
