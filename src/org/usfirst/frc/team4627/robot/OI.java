package org.usfirst.frc.team4627.robot;

import org.usfirst.frc.team4627.robot.commands.DriveForward;
import org.usfirst.frc.team4627.robot.commands.ElToroArmsIn;
import org.usfirst.frc.team4627.robot.commands.ElToroArmsOut;
import org.usfirst.frc.team4627.robot.commands.LowerAtStep;
import org.usfirst.frc.team4627.robot.commands.LowerLift;
import org.usfirst.frc.team4627.robot.commands.RaiseLift;
import org.usfirst.frc.team4627.robot.commands.SetElToroFeeders;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    Joystick driver = new Joystick(RobotMap.CONTROLLER_1);
    Joystick stacker = new Joystick(RobotMap.CONTROLLER_2);

    Button buttonA = new JoystickButton(stacker, RobotMap.BUTTON_A);
    Button buttonB = new JoystickButton(stacker, RobotMap.BUTTON_B);
    Button rightBumper = new JoystickButton(stacker, RobotMap.RIGHT_BUMPER);
    Button leftBumper = new JoystickButton(stacker, RobotMap.LEFT_BUMPER);
    
    Button driverRightBumper = new JoystickButton(driver, RobotMap.RIGHT_BUMPER);
    Button driverLeftBumper = new JoystickButton(driver, RobotMap.LEFT_BUMPER);
    
    Button buttonX = new JoystickButton(stacker, RobotMap.BUTTON_X);
    Button buttonY = new JoystickButton(stacker, RobotMap.BUTTON_Y);
    Button buttonBack = new JoystickButton(driver, RobotMap.BUTTON_BACK);
   
    public OI(){
    	buttonA.whenPressed(new ElToroArmsOut());
    	buttonB.whenPressed(new ElToroArmsIn());
    	buttonX.whenPressed(new LowerLift());
    	buttonY.whenPressed(new RaiseLift());
    	rightBumper.whenActive(new SetElToroFeeders());
    	leftBumper.whenActive(new SetElToroFeeders());
    	
    	driverRightBumper.whenPressed(new DriveForward(-0.9, .45));
    	driverLeftBumper.whenPressed(new LowerAtStep());
    	
    	buttonBack.whenPressed(new DriveForward(.35, 1));
    }
    
    public boolean getRightBumper(){
    	return this.rightBumper.get();
    }
    
    public boolean getLeftBumper(){
    	return this.leftBumper.get();
    }
    
    public boolean getAValue(){
    	return this.buttonA.get();
    }
  
    public double getLeftStickY() {
    	return driver.getRawAxis(RobotMap.LEFT_STICK_Y);
    }
    
    public double getLeftStickX(){
    	return (driver.getRawAxis(RobotMap.LEFT_STICK_X)*0.6);
    }
    
    public double getRightStickY() {
    	return driver.getRawAxis(RobotMap.RIGHT_STICK_Y);
    }
    
    public double getRightTrigger(){
    	return driver.getRawAxis(RobotMap.RIGHT_TRIGGER);
    }
    
    public double getLeftTrigger(){
    	return driver.getRawAxis(RobotMap.LEFT_TRIGGER);
    }
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}