// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.util.DoubleSolenoidToggler;
import frc.robot.util.FloatableSolenoid;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;

    //Drive Train motors
    public static final int[] LEFT_GROUP = { 0, 1 };
    public static final int[] RIGHT_GROUP = { 8, 9 };

    public static final PWMVictorSPX leftDriveMotor1 = new PWMVictorSPX(0);
    public static final PWMVictorSPX rightDriveMotor2 = new PWMVictorSPX(1);
    public static final PWMVictorSPX leftDriveMotor2 = new PWMVictorSPX(2);
    public static final PWMVictorSPX rightDriveMotor1 = new PWMVictorSPX(3);

    public static final DifferentialDrive driveSystem = new DifferentialDrive(leftDriveMotor1,rightDriveMotor1);
    public static final int LEFT_MOTOR = 3;
    public static final int RIGHT_MOTOR = 4;

    //Pneumatics
    public static final int ballSolenoid = 1;
    public static final DoubleSolenoidToggler hatchSolenoid = new DoubleSolenoidToggler(1, 0);
    public static final FloatableSolenoid extenderSolenoid = new FloatableSolenoid(RobotContainer.hatchDelivery, 1, 2, 3, 4);

    public static final int HD_LIMIT_SWITCH_PORT = 6;

    //Controller
    public static final int DRIVER_STICK_PORT = 9;
    public static final int OPERATOR_STICK_PORT = 1;
    
    public static final int BTN_A = 1;
    public static final int BTN_SELECT = 0;
    public static final int BTN_LEFT_BUMPER = 2;
    public static final int BTN_RIGHT_BUMPER = 3;
  }
}
