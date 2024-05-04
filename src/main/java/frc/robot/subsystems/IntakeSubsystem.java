package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.DeviceId.Intake;
import frc.robot.lib.IDashboardProvider;
import frc.robot.lib.LazyTalon;

public class IntakeSubsystem extends SubsystemBase implements IDashboardProvider {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;
    private final ShooterSubsystem shooterSubsystem;

    public IntakeSubsystem(ShooterSubsystem shooterSubsystem) {
        this.registerDashboard();
        this.leftMotor = new LazyTalon(Intake.left, false, false);
        this.rightMotor = new LazyTalon(Intake.right, false, false);
        this.shooterSubsystem = shooterSubsystem;
    }

    public void intake(double speed) {
        if (speed < 0 & this.shooterSubsystem.canShoot()) {
            this.wait(1500);
            Commands.run(this::autoShoot);
        } else if (speed > 0) {
            this.leftMotor.set(speed);
            this.rightMotor.set(speed);
        }
    }

    public Command autoShoot() {
        return new ParallelRaceGroup(
            new ParallelCommandGroup(
                Commands.runEnd(this.shooterSubsystem::shoot, this.shooterSubsystem::stopModules, this.shooterSubsystem),
                Commands.runEnd(this::outTake, this::stopModules, this)
            ),
            new WaitCommand(1.5)
        );
    }

    public void outTake() {
        this.wait(1000);
        this.leftMotor.set(-0.3);
        this.rightMotor.set(-0.3);
    }

    public void stopModules() {
        this.leftMotor.stopMotor();
        this.rightMotor.stopMotor();
    }

    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void putDashboard() {
    }
}
