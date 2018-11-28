package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.OI;
import org.usfirst.frc.team4320.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleDrive extends Command {
	
	private Chassis chassis;

    public TeleDrive() {
    	chassis=Chassis.getInstance();
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassis.setTankDrive(OI.getInstance().getLeftJoystickX(), OI.getInstance().getRightJoystickX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	chassis.setTankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
