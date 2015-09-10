package org.usfirst.frc.team4627.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4627.robot.commands.*;
import org.usfirst.frc.team4627.robot.subsystems.Chassis;
import org.usfirst.frc.team4627.robot.subsystems.ElToro;
import org.usfirst.frc.team4627.robot.subsystems.Forklift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final ElToro elToro = new ElToro();
	public static final Forklift lifter = new Forklift();
	public static final DigitalOutput arduinoInit = new DigitalOutput(2);
	public static final DigitalOutput teamColor = new DigitalOutput(3);
	public static OI oi;
	public static final Compressor compressor = new Compressor(0);
	Command autoCmd;
	SendableChooser autoChooser;
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	arduinoInit.set(false);
		oi = new OI();
		compressor.setClosedLoopControl(true);
        // instantiate the command used for the autonomous period
        autonomousCommand = null;
        SmartDashboard.putData(new TotesMaGoats());
        SmartDashboard.putData(new OneToteGet());
        SmartDashboard.putData(new TwoToteGet());
        SmartDashboard.putData(new OneEightyThreeTote());

        autoChooser = new SendableChooser();
        autoChooser.addDefault("Null", null);
        autoChooser.addObject("Drive Forwards", new DriveForward(-1, 1.5));
        autoChooser.addObject("Drive Forward over Step", new DriveForward(-1, 1.65));
        autoChooser.addObject("One Tote Over Platform, End In Auto", new OneToteGet());
        autoChooser.addObject("One Tote No Platform, End In Auto", new OneToteGetNoPlatform());
        autoChooser.addObject("One Tote No Pressure", new OneToteNoPressure());
        autoChooser.addObject("Two Tote Stack", new TwoToteGet());
        autoChooser.addObject("Three Tote Stack", new TotesMaGoats());
        SmartDashboard.putData("Chooser", autoChooser);
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Upper Switch", lifter.upLimSwt.get());
	}

    public void autonomousInit() {
    	DriverStation.Alliance color;
    	color = DriverStation.getInstance().getAlliance();
    	if (color == DriverStation.Alliance.Blue)
    		teamColor.set(false);
    	if (color == DriverStation.Alliance.Red)
    		teamColor.set(true);
    	
    	arduinoInit.set(true);
    	
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Upper Switch", lifter.upLimSwt.get());
    }

    public void teleopInit() {
    	
    	arduinoInit.set(true);
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	arduinoInit.set(false);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Upper Switch", lifter.upLimSwt.get());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
