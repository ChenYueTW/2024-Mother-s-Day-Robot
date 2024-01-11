package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCmd extends Command {
	private final ShooterSubsystem shooterSubsystem;
	private final XboxController controller;

	public ShooterCmd(ShooterSubsystem shooterSubsystem, XboxController controller) {
		this.shooterSubsystem = shooterSubsystem;
		this.controller = controller;

		addRequirements(this.shooterSubsystem);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		if (this.controller.getAButton()) {
			this.shooterSubsystem.setSpeed(1.0);
		} else if (this.controller.getBButton()) {
			this.shooterSubsystem.setSpeed(-1.0);
		} else {
			this.shooterSubsystem.stopModules();
		}
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
