/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4320.robot;

import edu.wpi.first.wpilibj.Joystick;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static OI instance;
	
	private Joystick leftJoystick;
	private Joystick rightJoystick;
	
	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private OI() {
		leftJoystick=new Joystick(RobotMap.LEFT_JOYSTICK);
		rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static OI getInstance() {
		if (instance == null)
			instance = new OI();
		return instance;
	}

	// Methods
	
	/**
	 * Get the Y axis coordinate of the left joystick
	 * @return The Y axis coordinate of the left joystick
	 */
	public double getLeftJoystickX() {
		return leftJoystick.getX();
	}
	
	/**
	 * Get the Y axis coordinate of the right joystick
	 * @return The Y axis coordinate of the right joystick
	 */
	public double getRightJoystickX() {
		return rightJoystick.getX();
	}
}
