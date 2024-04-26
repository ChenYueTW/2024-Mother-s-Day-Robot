package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeArmSubsystem;

public class IntakeArmCmd extends Command {
	private final IntakeArmSubsystem intakeArmSubsystem;
	private final Supplier<Double> turnIntake;

	public IntakeArmCmd(IntakeArmSubsystem intakeArmSubsystem, Supplier<Double> turnIntake) {
		this.intakeArmSubsystem = intakeArmSubsystem;
		this.turnIntake = turnIntake;
		this.addRequirements(this.intakeArmSubsystem);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		this.intakeArmSubsystem.turnIntake(this.turnIntake.get());
	}

	@Override
	public void end(boolean interrupted) {
		this.intakeArmSubsystem.stopModules();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
