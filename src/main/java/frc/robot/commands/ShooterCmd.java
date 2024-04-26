package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCmd extends Command {
	private final ShooterSubsystem shooterSubsystem;
	private final Supplier<Boolean> isShooter;

	public ShooterCmd(ShooterSubsystem shooterSubsystem, Supplier<Boolean> isShooter) {
		this.shooterSubsystem = shooterSubsystem;
		this.isShooter = isShooter;
		this.addRequirements(this.shooterSubsystem);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		if (this.isShooter.get()) this.shooterSubsystem.shooting(1.0);
		else this.shooterSubsystem.shooting(0.0);
	}

	@Override
	public void end(boolean interrupted) {
		this.shooterSubsystem.stopModules();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
