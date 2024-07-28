package frc.robot.util;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class FloatableSolenoid {
    private DoubleSolenoidToggler one;
    private DoubleSolenoidToggler two;
    private boolean extended = false;
    private Subsystem subsystem;

    public FloatableSolenoid(Subsystem subsystem, int portOne, int portTwo, int portThree, int portFour) {
        one = new DoubleSolenoidToggler(portOne, portTwo);
        two = new DoubleSolenoidToggler(portThree, portFour);

        one.setOff();
        this.subsystem = subsystem;
    }

    public void floatPiston(){
        one.retract();
        two.retract();
    }

    public void retractPiston() {
        two.setOff();
        one.extend();
        extended = false;
    }

    public void extendPiston() {
        one.setOff();
        two.extend();
        extended = true;
    }

    /** Returns a Command that retracts this double solenoid. */
    public Command retractCommand() {
        return new SequentialCommandGroup(new InstantCommand(() -> floatPiston(), subsystem), new WaitCommand(0.1), new InstantCommand(() -> retractPiston()));
    }

    //** Returns a Command that retracts this double solenoid. */
    public Command extendCommand() {
        return new SequentialCommandGroup(new InstantCommand(() -> floatPiston(), subsystem), new WaitCommand(0.1), new InstantCommand(() -> extendPiston()));
    }

    /** Returns a Command that toggles this double solenoid. */
    public Command toggleCommand() {
        return new ConditionalCommand(retractCommand(), extendCommand(), this::isExtended);
    }

    public boolean isExtended() {
        return extended;
    }
}
