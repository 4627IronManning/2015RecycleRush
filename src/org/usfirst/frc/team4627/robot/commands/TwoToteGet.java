package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TwoToteGet extends CommandGroup {
    
    public  TwoToteGet() {
    	addSequential(new RaiseLift());
        
        addSequential(new ElToroWheels(-1));
        addSequential(new Spin(0.4, 2.7));
        addSequential(new Spin(-0.4, 0.18));
        addSequential(new ElToroWheels(1));
        
        
        addSequential(new DriveForward(-0.5, 1.1));
        addParallel(new LowerLiftAuto());
        addParallel(new DriveForward(-0.5, 0.6));
        addSequential(new ElToroArmsInAuto());
        
        addSequential(new Wait(1.4));
        addSequential(new DriveForward(0.2, 0.4));
              
        addSequential(new ElToroArmsOut());
        
        addSequential(new ElToroWheels(-1));
        
        addSequential(new WaitForLiftDown());
        addSequential(new Wait(0.15));
        
        addSequential(new RaiseLift());
        addSequential(new Wait(0.15));
        
        addSequential(new Spin(-0.5, 1.1));
        
        addParallel(new LowerLift());      
        addSequential(new DriveForward(-0.54, 3));
        
        addSequential(new WaitForLiftDown());
        addSequential(new Wait(0.05));
        addSequential(new DriveForward(0.6, 1));
        
    }
}
