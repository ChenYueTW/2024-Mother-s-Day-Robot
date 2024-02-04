package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceId.IntakeArm;
import frc.robot.lib.LazyTalon;

public class IntakeArmSubsystem extends SubsystemBase {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;

    public IntakeArmSubsystem() {
        this.leftMotor = new LazyTalon(IntakeArm.left, false);
        this.rightMotor = new LazyTalon(IntakeArm.right, true);
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
