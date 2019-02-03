package org.usfirst.frc.team6560.robot.commands.vision;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoVisionGroup extends CommandGroup {
	public static final double CAMERA_OFFSET_X = 1;
	public static final double CAMERA_OFFSET_Y = 1.5;
	public static final double WALL_PADDING = 2;
	
    public AutoVisionGroup() {
    	addSequential(new AutoTurnToTarget());
        addSequential(new AutoDriveToTarget());
    }
}
