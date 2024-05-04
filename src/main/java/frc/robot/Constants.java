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
	
	public static final class MotorReverse {
		public static final boolean FRONT_LEFT_DRIVE = false;
		public static final boolean FRONT_RIGHT_DRIVE = true;
		public static final boolean BACK_LEFT_DRIVE = true;
		public static final boolean BACK_RIGHT_DRIVE = true;

		public static final boolean FRONT_LEFT_TURN = true;
		public static final boolean FRONT_RIGHT_TURN = true;
		public static final boolean BACK_LEFT_TURN = true;
		public static final boolean BACK_RIGHT_TURN = true;
	}

	public static final class EncoderOffset {
		public static final double FRONT_LEFT = 0.002685546875;
		public static final double FRONT_RIGHT = -0.000732421875;
		public static final double BACK_LEFT = 0.004150390625;
		public static final double BACK_RIGHT = 0.00341796875;
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

	public static final class LimitDegrees {
		// 228.74622610729202~360.0 0~105.71925127934492
		public static final double INTAKE_GEAR_RATIO = 18.0 / 22.0;
		public static final double INTAKE_DOWN = 228.74622610729202;
		public static final double INTAKE_UP = 105.71925127934492;
	}

    public static final double DEAD_BAND = 0.05;
	public static final double MAX_SPEED = 0.6;
	public static final double MAX_ANGULAR_SPEED = 0.8;
	public static final boolean gyroField = true;
}
