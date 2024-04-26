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
    private double speed;

    public ShooterSubsystem() {
        this.registerDashboard();
        this.leftMotor = new LazyTalon(Shooter.left, false, false);
        this.rightMotor = new LazyTalon(Shooter.right, false, false);
        this.shooterPid = new PIDController(0.0, 0.0, 0.0);
    }

    public void shooting(double speed) {
        double output = this.shooterPid.calculate(this.getAverageSpeed(), speed);
        this.speed = speed;
        this.leftMotor.set(output);
        this.rightMotor.set(output);
    }

    public double getAverageSpeed() {
        return (this.leftMotor.getVelocity().getValue() + this.rightMotor.getVelocity().getValue()) / 2.0;
    }

    public void stopModules() {
        this.leftMotor.stopMotor();
        this.rightMotor.stopMotor();
    }

    public boolean isShooting() {
        return this.speed != 0;
    }

    @Override
    public void putDashboard() {
        SmartDashboard.putNumber("Shooter Average Sp", this.getAverageSpeed());
        SmartDashboard.putBoolean("Is Shooting", this.isShooting());
    }
}
