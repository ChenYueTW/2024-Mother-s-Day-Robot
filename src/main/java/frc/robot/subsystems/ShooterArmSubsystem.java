package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceId.ShooterArm;
import frc.robot.lib.LazyTalon;

public class ShooterArmSubsystem extends SubsystemBase {
    private final LazyTalon motor;

    public ShooterArmSubsystem() {
        this.motor = new LazyTalon(ShooterArm.motor, false);
    }

    public void setSpeed(double speed) {
        this.motor.set(speed);
    }

    public void stopModules() {
        this.motor.stopMotor();
    }
}
