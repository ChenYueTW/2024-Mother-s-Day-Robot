package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCmd extends Command {
	private final IntakeSubsystem intakeSubsystem;
	private final Supplier<Boolean> isIntake, isOuttake;

	public IntakeCmd(IntakeSubsystem intakeSubsystem, Supplier<Boolean> isIntake, Supplier<Boolean> isOuttake) {
		this.intakeSubsystem = intakeSubsystem;
		this.isIntake = isIntake;
		this.isOuttake = isOuttake;
		this.addRequirements(this.intakeSubsystem);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		if (this.isIntake.get()) this.intakeSubsystem.intake(0.6);
		else if (this.isOuttake.get()) this.intakeSubsystem.intake(-0.6);
		else this.intakeSubsystem.stopModules();
	}

	@Override
	public void end(boolean interrupted) {
		this.intakeSubsystem.stopModules();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
