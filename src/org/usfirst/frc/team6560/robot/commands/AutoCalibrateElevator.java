package org.usfirst.frc.team6560.robot.commands;

import org.usfirst.frc.team6560.robot.commands.elevator_calibration.MoveDownAllTheWay;
import org.usfirst.frc.team6560.robot.commands.elevator_calibration.MoveUpABit;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCalibrateElevator extends CommandGroup {

    public AutoCalibrateElevator() {
        addSequential(new MoveUpABit(2));
        addSequential(new MoveDownAllTheWay(1));
        
        addSequential(new MoveUpABit(1));
        addSequential(new MoveDownAllTheWay(2));
    }
}
