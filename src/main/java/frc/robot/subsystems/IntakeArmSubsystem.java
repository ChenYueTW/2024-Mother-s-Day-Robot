package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LimitDegrees;
import frc.robot.DeviceId.IntakeArm;
import frc.robot.lib.IDashboardProvider;
import frc.robot.lib.LazyTalon;

public class IntakeArmSubsystem extends SubsystemBase implements IDashboardProvider {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;
    private final DutyCycleEncoder encoder;

    public IntakeArmSubsystem() {
        this.registerDashboard();
        this.leftMotor = new LazyTalon(IntakeArm.left, true, true);
        this.rightMotor = new LazyTalon(IntakeArm.right, false, true);
        this.encoder = new DutyCycleEncoder(IntakeArm.encoder);
    }

    public void turnIntake(double speed) {
        if (this.getAbsolutePosition() >= 0 & this.getAbsolutePosition() <= LimitDegrees.INTAKE_UP || this.getAbsolutePosition() >= LimitDegrees.INTAKE_DOWN && this.getAbsolutePosition() <= 360.0) {
            this.setSpeed(speed);
        } else if (this.getAbsolutePosition() > LimitDegrees.INTAKE_UP & this.getAbsolutePosition() < 120.0 & speed > 0) {
            this.setSpeed(speed);
        } else if (this.getAbsolutePosition() < LimitDegrees.INTAKE_DOWN & this.getAbsolutePosition() > 220.0 & speed < 0) {
            this.setSpeed(speed);
        } else {
            this.setSpeed(0.0);
        }
    }

    public void setSpeed(double speed) {
        this.leftMotor.set(speed);
        this.rightMotor.set(speed);
    }

    public void stopModules() {
        this.leftMotor.stopMotor();
        this.rightMotor.stopMotor();
    }

    public double getAbsolutePosition() {
        return Units.rotationsToDegrees(this.encoder.getAbsolutePosition()) * LimitDegrees.INTAKE_GEAR_RATIO;
    }

    @Override
    public void putDashboard() {
        SmartDashboard.putNumber("Arm Pose", this.getAbsolutePosition());
    }
}
