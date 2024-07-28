// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.DoubleSolenoidToggler;
import frc.robot.util.FloatableSolenoid;
import frc.robot.Constants;

public class HatchDelivery extends SubsystemBase {

  private DoubleSolenoidToggler grabberSolenoid = Constants.OperatorConstants.hatchSolenoid;
  private FloatableSolenoid extenderSolenoid = Constants.OperatorConstants.extenderSolenoid;

  private DigitalInput limitSwitch = new DigitalInput(Constants.OperatorConstants.HD_LIMIT_SWITCH_PORT);
  private Compressor c = new Compressor(null);

  /** Creates a new ExampleSubsystem. */
  public HatchDelivery() {
    c.enableDigital();
  }

  public void openGrabber() {
    grabberSolenoid.extend();;
  }

  public void closeGrabber() {
    grabberSolenoid.retract();
  }

  public boolean isGrabberOpen() {
    return grabberSolenoid.extended;
  }

  public void floatExtender() {
    extenderSolenoid.floatPiston();
  }

  public boolean isExtended() {
    return extenderSolenoid.isExtended();
  }

  public boolean getLimitSwitch() {
    return limitSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public Command getExtendCommand() {
    return extenderSolenoid.extendCommand();
  }

  public Command getRetractCommand() {
    return extenderSolenoid.retractCommand();
  }
}
