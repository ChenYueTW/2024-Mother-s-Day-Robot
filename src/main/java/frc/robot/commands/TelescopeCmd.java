package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TelescopeSubsystem;

public class TelescopeCmd extends Command {
	private final TelescopeSubsystem telescopeSubsystem;
	private final XboxController controller;

	public TelescopeCmd(TelescopeSubsystem telescopeSubsystem, XboxController controller) {
		this.telescopeSubsystem = telescopeSubsystem;
		this.controller = controller;

		addRequirements(this.telescopeSubsystem);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		if (this.controller.getYButton()) {
			this.telescopeSubsystem.move(true);
		} else if (this.controller.getAButton()) {
			this.telescopeSubsystem.move(false);
		} else {
			this.telescopeSubsystem.stopModules();
		}
	}

	@Override
	public void end(boolean interrupted) {
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
