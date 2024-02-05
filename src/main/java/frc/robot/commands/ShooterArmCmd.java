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
		double value = MathUtil.applyDeadband(this.controller.getRightY(), Constants.DEAD_BAND);
		if (value > 0) {
			this.shooterArmSubsystem.setSpeed(1.0);
		} else if (value < 0) {
			this.shooterArmSubsystem.setSpeed(-1.0);
		} else {
			this.shooterArmSubsystem.stopModules();
		}		
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
