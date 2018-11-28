package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Chassis extends Subsystem {

	private static Chassis instance = null;
	private static final double MIN_SPEED = -1.0;
	private static final double MAX_SPEED = 1.0;
	
	private WPI_TalonSRX leftTalon;
	private WPI_TalonSRX rightTalon;
	private DifferentialDrive tankDrive;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private Chassis() {
		leftTalon = new WPI_TalonSRX(RobotMap.LEFT_TALON);
		leftTalon.setSafetyEnabled(true);
		rightTalon = new WPI_TalonSRX(RobotMap.RIGHT_TALON);
		rightTalon.setSafetyEnabled(true);
		
		tankDrive=new DifferentialDrive(leftTalon, rightTalon);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static Chassis getInstance() {
		if (instance == null)
			instance = new Chassis();
		return instance;
	}

	// Methods

	/**
	 * Normalize the given speed to the range [-1.0, 1.0]
	 * @param speed
	 * @return The normalized speed
	 */
	private static double normalizeSpeed(double speed) {
		if (speed > MAX_SPEED)
			speed = MAX_SPEED;
		else if (speed < MIN_SPEED)
			speed = MIN_SPEED;
		return speed;
	}

	/**
	 * 
	 * @param leftSpeed
	 * @param rightSpeed
	 */
	public void setTankDrive(double leftSpeed, double rightSpeed) {
		leftSpeed=normalizeSpeed(leftSpeed);
		rightSpeed=normalizeSpeed(rightSpeed);
		
		tankDrive.tankDrive(leftSpeed, rightSpeed);
	}

	public void initDefaultCommand() {

	}
}
