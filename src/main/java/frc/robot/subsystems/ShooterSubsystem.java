package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceId.Shooter;
import frc.robot.lib.LazyTalon;

public class ShooterSubsystem extends SubsystemBase {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;

    public ShooterSubsystem() {
        this.leftMotor = new LazyTalon(Shooter.left, false);
        this.rightMotor = new LazyTalon(Shooter.right, false);
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
