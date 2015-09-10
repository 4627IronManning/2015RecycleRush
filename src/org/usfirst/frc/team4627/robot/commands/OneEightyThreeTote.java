package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OneEightyThreeTote extends CommandGroup {
    
    public  OneEightyThreeTote() {
    	
addSequential(new RaiseLift());
        
        addSequential(new ElToroWheels(-1));
        addSequential(new Spin(0.65, 1.23));
        addSequential(new ElToroWheels(1));
        
        addParallel(new LowerLiftAuto());
        addSequential(new DriveForward(-0.5, 1.2));
        addParallel(new DriveForward(-0.5, 0.3));
        addSequential(new ElToroArmsInAuto());
        addSequential(new Wait(1.5));
        addSequential(new ElToroArmsOut());
        addSequential(new ElToroWheels(0));
        
        addSequential(new WaitForLiftDown());
        addSequential(new Wait(0.5));
        
        addSequential(new RaiseLift()); //pick up second tote
        
    }
}
