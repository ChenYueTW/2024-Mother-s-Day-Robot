package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DeviceConstants;
import frc.robot.DeviceId.ShooterArm;
import frc.robot.lib.LazyTalon;

public class ShooterArmSubsystem extends SubsystemBase {
    private final LazyTalon motor;
    private final DutyCycleEncoder armEncoder;

    public ShooterArmSubsystem() {
        this.motor = new LazyTalon(ShooterArm.motor, false, true);
        this.armEncoder = new DutyCycleEncoder(0);
    }

    public double getDegrees() {
        return (Units.rotationsToDegrees(this.armEncoder.getAbsolutePosition() - DeviceConstants.SHOOTER_ARM_ENCODER_OFFSET) * DeviceConstants.SHOOTER_ARM_GEAR_RATIO * (DeviceConstants.SHOOTER_ARM_REVERSE ? -1 : 1));
    }

    public void setSpeed(double speed) {
        boolean atMaxLimit = this.getDegrees() >= DeviceConstants.SHOOTER_ARM_MAX_LIMIT;
        boolean atMinLimit = this.getDegrees() <= DeviceConstants.SHOOTER_ARM_MIN_LIMIT;

        if (!((atMaxLimit && speed < 0) || (atMinLimit && speed > 0)))  {
            this.motor.set(speed * DeviceConstants.SHOOTER_ARM_COEFFIFIENT);
        } else {
            this.stopModules();
        }
    }

    public void stopModules() {
        this.motor.stopMotor();
    }
}
