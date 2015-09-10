package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullToteGet extends CommandGroup {
    
    public  FullToteGet() {
    	
    	addSequential(new SpinLower());
    	addSequential(new DriveForward(-.2, .75));
    	addSequential(new RaiseLift());

    }
}
