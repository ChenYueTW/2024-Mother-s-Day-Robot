package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DeviceConstants;
import frc.robot.DeviceId.IntakeArm;
import frc.robot.lib.IDashboardProvider;
import frc.robot.lib.LazyTalon;

public class IntakeArmSubsystem extends SubsystemBase implements IDashboardProvider {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;
    private final DutyCycleEncoder encoder;
    private final PIDController pid;

    public IntakeArmSubsystem() {
        this.registerDashboard();
        this.leftMotor = new LazyTalon(IntakeArm.left, false, true);
        this.rightMotor = new LazyTalon(IntakeArm.right, true, true);
        this.encoder = new DutyCycleEncoder(1);
        this.pid = new PIDController(0.03, 0.0, 0.0);
    }

    public double getDegrees() {
        return ((Units.rotationsToDegrees(this.encoder.getAbsolutePosition()) + DeviceConstants.INTAKE_ARM_OFFSET) % 360) * (DeviceConstants.INTAKE_ARM_REVERSE ? -1 : 1) * DeviceConstants.INTAKE_ARM_GEAR_RATIO; 
    }

    public void toGoalDeg(double goalDeg) {
        double output = this.pid.calculate(this.getDegrees(), goalDeg) * DeviceConstants.INTAKE_ARM_COEFFIFIENT;
        SmartDashboard.putNumber("IntakeArm", output);
        this.leftMotor.set(output);
        this.rightMotor.set(output);
    }

    public void stopModules() {
        this.leftMotor.stopMotor();
        this.rightMotor.stopMotor();
    }

    @Override
    public void putDashboard() {
        SmartDashboard.putNumber("Intake Deg", this.getDegrees());
    }
}
