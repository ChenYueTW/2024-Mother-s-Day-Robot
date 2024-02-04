package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Constants.DeviceConstants;
import frc.robot.subsystems.IntakeArmSubsystem;

public class IntakeArmCmd extends Command {
	private final IntakeArmSubsystem intakeArmSubsystem;
	private final XboxController controller;

	public IntakeArmCmd(IntakeArmSubsystem intakeArmSubsystem, XboxController controller) {
		this.intakeArmSubsystem = intakeArmSubsystem;
		this.controller = controller;

		addRequirements(this.intakeArmSubsystem);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		double speed = MathUtil.applyDeadband(this.controller.getLeftY(), Constants.DEAD_BAND) * DeviceConstants.INTAKE_ARM_MAX;
		this.intakeArmSubsystem.setSpeed(speed);
	}

	@Override
	public void end(boolean interrupted) {
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
