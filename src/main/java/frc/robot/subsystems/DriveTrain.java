// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Commands;

public class DriveTrain extends SubsystemBase {
  
  private DifferentialDrive driveSystem = Constants.OperatorConstants.driveSystem;
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    Constants.OperatorConstants.leftDriveMotor2.addFollower(Constants.OperatorConstants.leftDriveMotor2);
    Constants.OperatorConstants.rightDriveMotor2.addFollower(Constants.OperatorConstants.rightDriveMotor1);
    
    setDefaultCommand(Commands.driveCommand);
    driveSystem.setDeadband(0.1);
  }

  public void arcadeDrive(XboxController driverController) {
    double forwardPower = driverController.getLeftY();
    double turnPower = driverController.getRightX();

    if (driverController.getLeftBumper()) turnPower *= 0.5;

    driveSystem.arcadeDrive(forwardPower, turnPower);
  }

  public void stop() {
    driveSystem.stopMotor();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
