package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.Constants;

public class SwerveDriveCmd extends Command {
	private final SwerveSubsystem swerveSubsystem;
	private final XboxController controller;

	public SwerveDriveCmd(SwerveSubsystem swerveSubsystem, XboxController controller) {
		this.swerveSubsystem = swerveSubsystem;
		this.controller = controller;
		this.addRequirements(this.swerveSubsystem);
	}

	@Override
	public void initialize() {
		this.swerveSubsystem.resetPose(new Pose2d(0.0, 0.0, new Rotation2d(0.0)));
	}

	@Override
	public void execute() {
		double xSpeed = MathUtil.applyDeadband(this.controller.getLeftY(), Constants.DEAD_BAND) * Constants.MAX_SPEED;
		double ySpeed = MathUtil.applyDeadband(this.controller.getLeftX(), Constants.DEAD_BAND) * Constants.MAX_SPEED;
		double rotation = MathUtil.applyDeadband(this.controller.getRightX(), Constants.DEAD_BAND) * Constants.MAX_ANGULAR_SPEED;

		if (this.controller.getAButton()) {
			this.swerveSubsystem.resetGyro();
		}
		SmartDashboard.putNumber("Xspeed", xSpeed);
		SmartDashboard.putNumber("Yspeed", ySpeed);
		SmartDashboard.putNumber("RotationSP", rotation);

		this.swerveSubsystem.driveSwerve(xSpeed, ySpeed, rotation, Constants.gyroField);
	}

	@Override
	public void end(boolean interrupted) {
		this.swerveSubsystem.stopModules();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
