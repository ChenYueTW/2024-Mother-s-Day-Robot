package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public final class Constants {
	public static final class SwerveConstants {
		public static final double TRACK_WIDTH = 0.66; // 寬
		public static final double WHEEL_BASE = 0.66; // 長
		public static final double WHEEL_RADIUS = 0.0508; // 輪子半徑
		
		public static final double PHYSICAL_MAX_SPEED_METERS_PER_SECOND = 3.0; // 最大速度m/s
		public static final double PHYSICAL_MAX_ACCELERATION_METERS_PER_SECONE = 3.0; // 最大加速度m/s^2
		public static final double DRIVE_GEAR_RATIO = 1.0 / 8.14; // 齒輪比
		public static final double TURN_GEAR_RATIO = 7.0 / 150.0;
		public static final double MAX_VOLTAGE = 12.0;

		public static final double DRIVE_VELOCITY_CONVERSION_FACTOR = (1.0 / DRIVE_GEAR_RATIO / 2048) * WHEEL_RADIUS * Math.PI * 10;
		public static final double DRIVE_POSITION_CONVERSION_FACTOR = (1.0 / DRIVE_GEAR_RATIO / 2048) * WHEEL_RADIUS * Math.PI;
	}

	public static final class DeviceConstants {
		public static final double INTAKE = 0.4;
		public static final double INTAKE_RELEASE = -1;
		public static final double SHOOTER = 1.0;

		public static final double SHOOTER_ARM_MAX_LIMIT = 60.0;
		public static final double SHOOTER_ARM_MIN_LIMIT = 0.0;
		public static final double SHOOTER_ARM_ENCODER_OFFSET = 351.23;
		public static final double SHOOTER_ARM_GEAR_RATIO = 10.0 / 22.0;
		public static final double SHOOTER_ARM_COEFFIFIENT = 0.07;
		public static final boolean SHOOTER_ARM_REVERSE = true;

		public static final double INTAKE_ARM_MAX_TARGET = 173.0;
		public static final double INTAKE_ARM_MIN_TARGET = 13.0;
		public static final double INTAKE_ARM_OFFSET = 147.1;
		public static final double INTAKE_ARM_GEAR_RATIO = 18.0 / 22.0;
		public static final double INTAKE_ARM_COEFFIFIENT = 0.07;
		public static final boolean INTAKE_ARM_REVERSE = false;

		public static final double TELESCOPE_LIMIT = 1200.0;
		public static final double TELESCOPE_SPEED = 0.2;
	}
	
	public static final class MotorReverse {
		public static final boolean FRONT_LEFT_DRIVE = true;
		public static final boolean FRONT_RIGHT_DRIVE = false;
		public static final boolean BACK_LEFT_DRIVE = true;
		public static final boolean BACK_RIGHT_DRIVE = false;

		public static final boolean FRONT_LEFT_TURN = true;
		public static final boolean FRONT_RIGHT_TURN = true;
		public static final boolean BACK_LEFT_TURN = true;
		public static final boolean BACK_RIGHT_TURN = true;
	}

	public static final class EncoderOffset {
		public static final double FRONT_LEFT = -139.270751953125;
		public static final double FRONT_RIGHT = -59.5078125;
		public static final double BACK_LEFT = -78.949951171875;
		public static final double BACK_RIGHT = -146.015625;
	}

	public static final SwerveDriveKinematics swerveDriveKinematics = new SwerveDriveKinematics(
        new Translation2d(Constants.SwerveConstants.WHEEL_BASE / 2, Constants.SwerveConstants.TRACK_WIDTH / 2),
        new Translation2d(Constants.SwerveConstants.WHEEL_BASE / 2, -Constants.SwerveConstants.TRACK_WIDTH / 2),
        new Translation2d(-Constants.SwerveConstants.WHEEL_BASE / 2, Constants.SwerveConstants.TRACK_WIDTH / 2),
        new Translation2d(-Constants.SwerveConstants.WHEEL_BASE / 2, -Constants.SwerveConstants.TRACK_WIDTH / 2)
    );

	public static final class AutoConstants {
		public static final double PHYSICAL_MAX_SPEED_METERS_PER_SECOND = 4.2; // 最大速度m/s
		public static final double PHYSICAL_MAX_ACCELERATION_METERS_PER_SECONE = 0.5; // 最大加速度m/s^2
	}

	public static final class LimelightConstants {
		public static final double MOUNT_ANGLE_DEG = 0.0;
		public static final double LENS_HEIGHT_METERS = 0.42; // distance from the center of the Limelight lens to the floor
		public static final double GOAL_HEIGHT_METERS = 0.74; // distance from the target to the floor
		public static final double HORIZONTAL_OFFSET_METERS = 0;
		public static final double VERTICAL_MAX_SPEED = 1.3;
		public static final double HORIZONTAL_MAX_SPEED = 2.6;
		public static final boolean gyroField = false;
	}

	public static final class LimelightCamera {
		public static final double[] cameraPose = {
			-1, 1, -0.99, 1
		};
		public static final double ledMode = 3; // 1-off 2-blink 3-on
		public static final double camMode = 0; // 0-Vision 1-Driver
	}

    public static final double DEAD_BAND = 0.05;
	public static final double MAX_SPEED = 0.8;
	public static final double MAX_ANGULAR_SPEED = 1.3;
	public static final boolean gyroField = true;
}
