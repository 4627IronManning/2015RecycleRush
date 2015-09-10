package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeControl extends Command {

    public ArcadeControl() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getAValue() == true){
    		end();
    	}
    	double y = Robot.oi.getLeftStickY();
    	double x = Robot.oi.getLeftStickX();
    	
    	double lSpeed = (y-x);
    	double rSpeed = (y+x);
    	
    	Robot.chassis.setLeftMotors(lSpeed);
    	Robot.chassis.setRightMotors(rSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
