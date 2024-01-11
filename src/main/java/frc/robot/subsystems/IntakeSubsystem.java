package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceId.Intake;
import frc.robot.lib.LazySpark;

public class IntakeSubsystem extends SubsystemBase {
    private final LazySpark intakeMotor;

    public IntakeSubsystem() {
        this.intakeMotor = new LazySpark(Intake.motor, false);
    }

    public void setSpeed(double speed) {
        this.intakeMotor.set(speed);
    }

    public void stopModules() {
        this.intakeMotor.stopMotor();
    }
}
