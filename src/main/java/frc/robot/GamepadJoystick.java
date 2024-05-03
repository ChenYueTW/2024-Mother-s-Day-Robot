package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;

public class GamepadJoystick extends XboxController {
    public GamepadJoystick(int port) {
        super(port);
    }
    public static final int DRIVER_PORT = 0;
    public static final int CONTROLLER_PORT = 1;

    public boolean isShooting() {
        return this.getLeftBumper();
    }

    public boolean isIntake() {
        return this.getAButton();
    }

    public boolean isOuttake() {
        return this.getYButton();
    }

    public double turnIntakeArm() {
        return MathUtil.applyDeadband(this.getLeftY(), Constants.DEAD_BAND) * 0.3;
    }
}
