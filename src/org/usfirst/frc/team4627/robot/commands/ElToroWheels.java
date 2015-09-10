package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElToroWheels extends Command {

	int m_speed;
	
    public ElToroWheels(int speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elToro);
        m_speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elToro.setElToroArm(m_speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
