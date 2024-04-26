package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceId.Intake;
import frc.robot.lib.IDashboardProvider;
import frc.robot.lib.LazyTalon;

public class IntakeSubsystem extends SubsystemBase implements IDashboardProvider {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;
    private double speed;

    public IntakeSubsystem() {
        this.registerDashboard();
        this.leftMotor = new LazyTalon(Intake.left, false, false);
        this.rightMotor = new LazyTalon(Intake.right, true, false);
    }

    public void intake(double speed) {
        this.speed = speed;
        this.leftMotor.set(speed);
        this.rightMotor.set(speed);
    }

    public void stopModules() {
        this.leftMotor.stopMotor();
        this.rightMotor.stopMotor();
    }

    public boolean isIntaking() {
        return this.speed != 0;
    }

    @Override
    public void putDashboard() {
        SmartDashboard.putBoolean("Is Intake", this.isIntaking());
    }
}
