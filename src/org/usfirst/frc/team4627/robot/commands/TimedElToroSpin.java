package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedElToroSpin extends Command {
	
	double timer;

    public TimedElToroSpin(double time) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elToro);
        timer = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timer);
    	Robot.elToro.setElToroArm(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elToro.setElToroArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
