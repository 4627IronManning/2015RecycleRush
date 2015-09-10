package org.usfirst.frc.team4627.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static int LEFT_STICK_X = 0;
	public static int LEFT_STICK_Y = 1;
	
	public static int RIGHT_STICK_Y = 5;
	
	public static int LEFT_TRIGGER = 2;
	public static int RIGHT_TRIGGER = 3;
	
	public static int BUTTON_A = 1;
	public static int BUTTON_B = 2;
	public static int BUTTON_X = 3;
	public static int BUTTON_Y = 4;
	public static int LEFT_BUMPER = 5;
	public static int RIGHT_BUMPER = 6;
	public static int BUTTON_BACK = 7;
	public static int BUTTON_START = 8;
	
	public static int CONTROLLER_1 = 0;
	public static int CONTROLLER_2 = 1;
    
	//good robot
	
	public static int LEFT_TOP_MOTOR = 7;
    public static int LEFT_BOTTOM_MOTOR = 8;
    public static int RIGHT_TOP_MOTOR = 5;
    public static int RIGHT_BOTTOM_MOTOR = 6;
	

	/*//second robot
    public static int LEFT_TOP_MOTOR = 3;
    public static int LEFT_BOTTOM_MOTOR = 4;
    public static int RIGHT_TOP_MOTOR = 1;
    public static int RIGHT_BOTTOM_MOTOR = 2;
    */
    
    public static int EL_TORO_MOTOR_RIGHT = 1;
    public static int EL_TORO_MOTOR_LEFT = 0;
    
    public static int EL_TORO_DCV = 0;
    public static int LIFTING_DCV= 1;
    
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
