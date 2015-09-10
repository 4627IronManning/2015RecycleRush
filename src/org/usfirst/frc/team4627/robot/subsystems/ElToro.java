package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElToro extends Subsystem {
    
	Solenoid eltoroMove = new Solenoid(RobotMap.EL_TORO_DCV);
	CANTalon rightMotor = new CANTalon(RobotMap.EL_TORO_MOTOR_RIGHT);
	CANTalon leftMotor = new CANTalon(RobotMap.EL_TORO_MOTOR_LEFT);
	
    public void initDefaultCommand() {
    	
    }
    
    public void changeDCVState(boolean state) {
    	eltoroMove.set(!state);
    }
    
    public void setElToroArm (int speed){
    	leftMotor.set(speed);
    	rightMotor.set(-speed);
    }
    
}