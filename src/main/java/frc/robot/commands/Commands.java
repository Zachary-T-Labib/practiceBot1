package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.RobotContainer;

public class Commands {
    
    public static final Command emergencyStop = new InstantCommand(() -> RobotContainer.driveTrain.stop(), RobotContainer.driveTrain);

    public static final Command launch = new RunCommand(() ->
        RobotContainer.ballDelivery.power(RobotContainer.io.operatorController.getRightY()), RobotContainer.ballDelivery);

    public static final Command ballDeliveryReset = new InstantCommand(() -> {
        RobotContainer.ballDelivery.stop();
        RobotContainer.ballDelivery.raise();
    }, RobotContainer.ballDelivery);

    public static final Command toggleBallDeliveryPistons = new InstantCommand(() -> RobotContainer.ballDelivery.raise(), RobotContainer.ballDelivery);
    
    public static final Command grab = new SequentialCommandGroup (
        new InstantCommand(() -> RobotContainer.hatchDelivery.closeGrabber(), RobotContainer.hatchDelivery),
        RobotContainer.hatchDelivery.getExtendCommand(),
        new WaitUntilCommand(() -> RobotContainer.hatchDelivery.getLimitSwitch()),
        new InstantCommand(() -> RobotContainer.hatchDelivery.floatExtender(), RobotContainer.hatchDelivery),
        new WaitUntilCommand(() -> !RobotContainer.hatchDelivery.getLimitSwitch()),
        new InstantCommand(() -> RobotContainer.hatchDelivery.openGrabber(), RobotContainer.hatchDelivery),
        new WaitCommand(0.2),
        RobotContainer.hatchDelivery.getRetractCommand()
    );

    public static final Command release = new SequentialCommandGroup (
        new InstantCommand(() -> RobotContainer.hatchDelivery.openGrabber(), RobotContainer.hatchDelivery),
        RobotContainer.hatchDelivery.getExtendCommand(),
        new WaitUntilCommand(() -> RobotContainer.hatchDelivery.getLimitSwitch()),
        new InstantCommand(() -> RobotContainer.hatchDelivery.floatExtender(), RobotContainer.hatchDelivery),
        new WaitUntilCommand(() -> !RobotContainer.hatchDelivery.getLimitSwitch()),
        new InstantCommand(() -> RobotContainer.hatchDelivery.closeGrabber(), RobotContainer.hatchDelivery),
        new WaitCommand(0.2),
        RobotContainer.hatchDelivery.getRetractCommand()
    );

    public static final Command driveCommand = new RunCommand(() -> RobotContainer.driveTrain.arcadeDrive(RobotContainer.io.driveController), RobotContainer.driveTrain);
}
