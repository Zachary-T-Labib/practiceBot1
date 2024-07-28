package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Commands;

public class IO {
    public XboxController driveController = new XboxController(Constants.OperatorConstants.DRIVER_STICK_PORT);
    public XboxController operatorController = new XboxController(Constants.OperatorConstants.OPERATOR_STICK_PORT);

    JoystickButton grabButton = new JoystickButton(operatorController, Constants.OperatorConstants.BTN_LEFT_BUMPER);
    JoystickButton releaseButton = new JoystickButton(operatorController, Constants.OperatorConstants.BTN_RIGHT_BUMPER);

    JoystickButton togglePistonsButton = new JoystickButton(operatorController, Constants.OperatorConstants.BTN_A);
    JoystickButton ballDeliveryResetButton = new JoystickButton(operatorController, Constants.OperatorConstants.BTN_SELECT);

    public IO() {
        grabButton.onTrue(Commands.grab);
        releaseButton.onTrue(Commands.release);

        togglePistonsButton.onTrue(Commands.toggleBallDeliveryPistons);
        ballDeliveryResetButton.onTrue(Commands.ballDeliveryReset);
    }
}
