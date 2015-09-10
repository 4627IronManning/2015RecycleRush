package org.usfirst.frc.team4627.robot.subsystems;


import org.usfirst.frc.team4627.robot.RobotMap;

import org.usfirst.frc.team4627.robot.commands.GTADrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    //Constructors for each motor controller, CAN ids from RobotMap 
    CANJaguar leftTop = new CANJaguar(RobotMap.LEFT_TOP_MOTOR);
    CANJaguar leftBottom = new CANJaguar(RobotMap.LEFT_BOTTOM_MOTOR);
    CANJaguar rightTop = new CANJaguar(RobotMap.RIGHT_TOP_MOTOR);
    CANJaguar rightBottom = new CANJaguar(RobotMap.RIGHT_BOTTOM_MOTOR);
    
    public Chassis(){
    	//Configure jags
    	leftTop.setPercentMode();
    	leftTop.enableControl();
    	leftBottom.setPercentMode();
    	leftBottom.enableControl();
    	rightTop.setPercentMode();
    	rightTop.enableControl();
    	rightBottom.setPercentMode();
    	rightBottom.enableControl();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new GTADrive());
    }
    
    
    public void setLeftMotors(double speed) { //Reverse speed as left motors are inverse orientation of right
    	leftTop.set(-speed);
    	leftBottom.set(-speed);
    }
    
    public void setRightMotors(double speed) {
    	rightTop.set(speed);
    	rightBottom.set(speed);
    }
    
    public void stopAllMotors() { //turn off all the motors
    	rightTop.set(0);
    	rightBottom.set(0);
    	leftTop.set(0);
    	leftBottom.set(0);
    }
}

