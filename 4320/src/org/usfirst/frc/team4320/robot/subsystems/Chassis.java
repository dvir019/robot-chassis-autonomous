package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {

	private static Chassis instance = null;
	private static double MIN_SPEED = -1.0;
	private static double MAX_SPEED = 1.0;
	
	private WPI_TalonSRX leftTalon;
	private WPI_TalonSRX rightTalon;

	// Constructor and SingleRon

	/**
	 * The constructor of the class
	 */
	private Chassis() {
		leftTalon = new WPI_TalonSRX(RobotMap.LEFT_TALON);
		leftTalon.setSafetyEnabled(true);
		rightTalon = new WPI_TalonSRX(RobotMap.RIGHT_TALON);
		rightTalon.setSafetyEnabled(true);
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

	private static double normalizeSpeed(double speed) {
		if (speed > MAX_SPEED)
			speed = MAX_SPEED;
		else if (speed < MIN_SPEED)
			speed = MIN_SPEED;
		return speed;
	}

	public void setLeftTalon(double speed) {
		speed = normalizeSpeed(speed);
		leftTalon.set(speed);
	}

	public void setRightTalon(double speed) {
		speed = normalizeSpeed(speed);
		rightTalon.set(speed);
	}

	public void initDefaultCommand() {

	}
}
