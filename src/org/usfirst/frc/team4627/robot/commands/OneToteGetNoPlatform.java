package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OneToteGetNoPlatform extends CommandGroup {
    
    public  OneToteGetNoPlatform() {
    	addSequential(new RaiseLift());
    	
    	addSequential(new Spin(0.5, 0.75));
    	addParallel(new LowerLift());
    	
    	addSequential(new DriveForward(-0.7, 2));
    	addSequential(new WaitForLiftDown());
    	addSequential(new DriveForward(0.85, .43));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
