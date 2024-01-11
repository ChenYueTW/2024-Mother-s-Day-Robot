package frc.robot.Auto;

import com.pathplanner.lib.commands.FollowPathHolonomic;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.SwerveConstants;
import frc.robot.subsystems.SwerveSubsystem;

public class PathPlannerCmd extends SequentialCommandGroup {
	private final SwerveSubsystem swerveSubsystem;
	private final PathPlannerPath path;
	private final PIDConstants translationPid;
	private final PIDConstants rotationPid;

	public PathPlannerCmd(SwerveSubsystem swerveSubsystem) {
		this.swerveSubsystem = swerveSubsystem;
		this.translationPid = new PIDConstants(0, 0, 0);
		this.rotationPid = new PIDConstants(0, 0, 0);
		this.path = PathPlannerPath.fromPathFile("Swerve");
		addCommands(this.followPath());
	}

	public Command followPath() {
		return new FollowPathHolonomic(
			this.path,
			this.swerveSubsystem::getPose,
			this.swerveSubsystem::getSpeeds,
			this.swerveSubsystem::setAutoModuleState,
			new HolonomicPathFollowerConfig(
				this.translationPid,
				this.rotationPid,
				SwerveConstants.PHYSICAL_MAX_SPEED_METERS_PER_SECOND,
				SwerveConstants.WHEEL_BASE / 2,
				new ReplanningConfig()
			),
			() -> {
				var alliance = DriverStation.getAlliance();
				if (alliance.isPresent()) {
					return alliance.get() == DriverStation.Alliance.Red;
				}
				return false;
			},
			this.swerveSubsystem
		);
	}
}