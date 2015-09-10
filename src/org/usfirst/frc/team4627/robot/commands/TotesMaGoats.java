package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TotesMaGoats extends CommandGroup {
    
    public  TotesMaGoats() {
    	//addSequential(new DriveForward(-0.2, 0.1)); //Get first tote
        addSequential(new RaiseLift());
        
        addSequential(new Spin(.7, 0.25));
        addSequential(new DriveForward(-0.6, 0.75)); //knock first can
        addSequential(new Spin(-0.5, 0.6));
        
        addSequential(new ElToroWheels(-1));

        addSequential(new DriveForward(-0.61, 0.6)); //approach second tote
        addParallel(new LowerLiftAuto());
        addSequential(new ElToroWheels(1));
        addSequential(new DriveForward(-0.6, 1.3));
        
        addParallel(new ElToroArmsInSpin()); //grab second tote
        //addSequential(new DriveForward(0.3, 0.3));
        addSequential(new WaitForLiftDown());

        addSequential(new DriveForward(-0.3, 0.2)); //lift second tote
        addSequential(new RaiseLift());
        
        addSequential(new Spin(.3, 0.55)); //knock second can
        addSequential(new DriveForward(-0.7, .65));
        addSequential(new Spin(-0.45, 0.55));
        
        addParallel(new ElToroWheels(1)); //approach third tote
        addSequential(new DriveForward(-0.5, 1.9));
        
        addSequential(new ElToroArmsIn()); //grab third tote (ElToro only)
        addParallel(new LowerLiftAuto());
        addSequential(new Wait(0.4));
        
        addSequential(new Spin(0.5, 0.95)); //get to AUTO zone
        
        
        //addSequential(new DriveForward(-1, 0.9));
        
        addSequential(new ElToroArmsOut()); //release stack
        addSequential(new ElToroWheels(0));
        addSequential(new WaitForLiftDown());
        
        //addSequential(new DriveForward(0.9, .45)); //back away
        
        
    }
}
