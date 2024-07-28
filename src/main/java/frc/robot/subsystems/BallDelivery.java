// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Commands;

public class BallDelivery extends SubsystemBase {
  private Victor leftMotor = new Victor(Constants.OperatorConstants.LEFT_MOTOR);
  private Victor rightMotor = new Victor(Constants.OperatorConstants.RIGHT_MOTOR);

  private Solenoid pistons = new Solenoid(null, Constants.OperatorConstants.ballSolenoid);

  /** Creates a new ExampleSubsystem. */
  public BallDelivery() {
    raise();
    setDefaultCommand(Commands.launch);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */


  public Command power(double speed) {
    if (speed > 1) speed = 1;
    if (speed < -1) speed = -1;

    if (Math.abs(speed) > 0.1) {
      leftMotor.set(speed);
      rightMotor.set(-speed);
    } else {
      stop();
    }

    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public void stop() {
    leftMotor.set(0);
    rightMotor.set(0);
  }

  public double getSpeed() {
    return leftMotor.get();
  }
  
  public void raise() {
    pistons.set(false);
  }

  public void lower() {
    pistons.set(true);
  }

  public boolean isRaised() {
    return !pistons.get();
  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
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
