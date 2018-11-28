package org.usfirst.frc.team4320.robot.commands;

import org.usfirst.frc.team4320.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 * Autonomous command.
 */
public class Autonomous extends TimedCommand {
	
	private Chassis chassis;

    public Autonomous(double timeout) {
        super(timeout);
        chassis=Chassis.getInstance();
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassis.setTankDrive(1, 1);
    }

    // Called once after timeout
    protected void end() {
    	chassis.setTankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
