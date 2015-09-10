package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CopyOfSpin extends Command {
	
	double m_speed, m_time;

    public CopyOfSpin(double speed, double time) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        m_speed = speed;
        m_time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(m_time);
    	Robot.chassis.setLeftMotors(this.m_speed);
    	Robot.chassis.setRightMotors(-this.m_speed);
    	
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
    	Robot.chassis.stopAllMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
