package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceId.Intake;
import frc.robot.lib.LazyTalon;

public class IntakeSubsystem extends SubsystemBase {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;

    public IntakeSubsystem() {
        this.leftMotor = new LazyTalon(Intake.left, true, false);
        this.rightMotor = new LazyTalon(Intake.right, true, false);
    }

    public void setSpeed(double speed) {
        this.leftMotor.set(speed);
        this.rightMotor.set(speed);
    }

    public void stopModules() {
        this.leftMotor.stopMotor();
        this.rightMotor.stopMotor();
    }
}