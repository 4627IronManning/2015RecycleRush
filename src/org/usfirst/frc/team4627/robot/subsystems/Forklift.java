package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {
	
	Solenoid moveArm = new Solenoid(RobotMap.LIFTING_DCV);
	boolean state;
	public DigitalInput upLimSwt = new DigitalInput(0);
	public DigitalInput downLimSwt = new DigitalInput(1);
	
	public Forklift(){
		
		this.state = this.moveArm.get();
	}
	
    public void initDefaultCommand() {
        Robot.elToro.changeDCVState(true);
    }
    
    public boolean getState() {
    	return this.state;
    }
    
    public void moveUp(){
    	this.state = true;
    	this.moveArm.set(true);
    }
    
    public void moveDown(){
    	this.state = false;
    	this.moveArm.set(false);
    }
}