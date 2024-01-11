package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceId.Shooter;
import frc.robot.lib.LazySpark;

public class ShooterSubsystem extends SubsystemBase {
    private final LazySpark leftMotor;
    private final LazySpark rightMotor;

    public ShooterSubsystem() {
        this.leftMotor = new LazySpark(Shooter.left, false);
        this.rightMotor = new LazySpark(Shooter.right, true);
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
