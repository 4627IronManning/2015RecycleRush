package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SpinLower extends CommandGroup {
    
    public  SpinLower() {
        addParallel(new ElToroArmsInSpin());
        addParallel(new LowerLiftAuto());
    }
}
