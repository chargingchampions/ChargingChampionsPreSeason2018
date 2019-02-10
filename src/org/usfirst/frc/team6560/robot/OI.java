package org.usfirst.frc.team6560.robot;

import org.usfirst.frc.team6560.robot.RobotMap.Joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final Joystick logitechJoystick;
	
	public OI() {
		logitechJoystick = new Joystick(Joysticks.LOGITECH_JOYSTICK_ID);

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

	}

}
