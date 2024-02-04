package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterArmSubsystem;

public class ShooterArmCmd extends Command {
	private	final ShooterArmSubsystem shooterArmSubsystem;
	private final XboxController controller;

	public ShooterArmCmd(ShooterArmSubsystem shooterArmSubsystem, XboxController controller) {
		this.shooterArmSubsystem = shooterArmSubsystem;
		this.controller = controller;

		addRequirements(this.shooterArmSubsystem);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		double speed = MathUtil.applyDeadband(this.controller.getRightY(), Constants.DEAD_BAND);
		this.shooterArmSubsystem.setSpeed(speed);
	}

	@Override
	public void end(boolean interrupted) {
		this.shooterArmSubsystem.stopModules();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
