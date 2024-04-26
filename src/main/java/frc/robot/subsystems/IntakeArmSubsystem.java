package frc.robot.subsystems;

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
        this.leftMotor = new LazyTalon(IntakeArm.left, false, true);
        this.rightMotor = new LazyTalon(IntakeArm.right, true, true);
        this.encoder = new DutyCycleEncoder(IntakeArm.encoder);
    }

    public void turnIntake(double speed) {
        if (LimitDegrees.INTAKE_UP > this.encoder.getAbsolutePosition() && speed < 0) {
            this.setSpeed(speed);
        } else if (LimitDegrees.INTAKE_DOWN < this.encoder.getAbsolutePosition() && speed > 0) {
            this.setSpeed(speed);
        } else {
            this.stopModules();
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

    @Override
    public void putDashboard() {
        SmartDashboard.putNumber("Intake Arm Deg", this.encoder.getAbsolutePosition());
    }
}
