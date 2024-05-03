package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.IntakeArmCmd;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.ShooterCmd;
import frc.robot.commands.SwerveDriveCmd;
import frc.robot.subsystems.IntakeArmSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {
	private final GamepadJoystick driverJoystick = new GamepadJoystick(GamepadJoystick.DRIVER_PORT);
	private final GamepadJoystick controllerJoystick = new GamepadJoystick(GamepadJoystick.CONTROLLER_PORT);

	private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
	private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
	private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
	private final IntakeArmSubsystem intakeArmSubsystem = new IntakeArmSubsystem();

	private final SwerveDriveCmd swerveDriveCmd = new SwerveDriveCmd(swerveSubsystem, driverJoystick);
	private final ShooterCmd shooterCmd = new ShooterCmd(shooterSubsystem, controllerJoystick::isShooting);
	private final IntakeCmd intakeCmd = new IntakeCmd(intakeSubsystem, controllerJoystick::isIntake, controllerJoystick::isOuttake);
	private final IntakeArmCmd intakeArmCmd = new IntakeArmCmd(intakeArmSubsystem, controllerJoystick::turnIntakeArm);

	public RobotContainer() {
		this.swerveSubsystem.setDefaultCommand(this.swerveDriveCmd);
		this.shooterSubsystem.setDefaultCommand(this.shooterCmd);
		this.intakeSubsystem.setDefaultCommand(this.intakeCmd);
		this.intakeArmSubsystem.setDefaultCommand(this.intakeArmCmd);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}
