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
		double value = MathUtil.applyDeadband(this.controller.getLeftY(), Constants.DEAD_BAND);
		if (value < 0 ) {
			this.intakeArmSubsystem.toGoalDeg(DeviceConstants.INTAKE_ARM_MAX_TARGET);
		} else if (value > 0) {
			this.intakeArmSubsystem.toGoalDeg(DeviceConstants.INTAKE_ARM_MIN_TARGET);
		} else {
			this.intakeArmSubsystem.stopModules();
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
