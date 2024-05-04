package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceId.Shooter;
import frc.robot.lib.IDashboardProvider;
import frc.robot.lib.LazyTalon;

public class ShooterSubsystem extends SubsystemBase implements IDashboardProvider {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;
    private final PIDController shooterPid;

    public ShooterSubsystem() {
        this.registerDashboard();
        this.leftMotor = new LazyTalon(Shooter.up, false, false);
        this.rightMotor = new LazyTalon(Shooter.down, false, false);
        this.shooterPid = new PIDController(0.2, 3.5, 0.0);
    }

    public void shooting(boolean isShooting) {
        if (isShooting) {
            double output = this.shooterPid.calculate(this.getAverageSpeed(), 90.0);
            this.leftMotor.set(output);
            this.rightMotor.set(output);
        } else {
            this.stopModules();
        }
    }

    public void shoot() {
        this.shooting(true);
    }

    public double getAverageSpeed() {
        return (this.leftMotor.getVelocity().getValue() + this.rightMotor.getVelocity().getValue()) / 2.0;
    }

    public void stopModules() {
        this.leftMotor.stopMotor();
        this.rightMotor.stopMotor();
    }

    public boolean canShoot() {
        return this.getAverageSpeed() >= 80.0;
    }

    @Override
    public void putDashboard() {
        SmartDashboard.putNumber("AverageSp", this.getAverageSpeed());
        SmartDashboard.putBoolean("CanShoot", this.canShoot());
    }
}
