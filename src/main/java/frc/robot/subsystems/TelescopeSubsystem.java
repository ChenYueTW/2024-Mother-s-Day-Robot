package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DeviceConstants;
import frc.robot.DeviceId.Telescope;
import frc.robot.lib.LazyTalon;

public class TelescopeSubsystem extends SubsystemBase {
    private final LazyTalon leftMotor;
    private final LazyTalon rightMotor;
    private final Follower follower;

    public TelescopeSubsystem() {
        this.leftMotor = new LazyTalon(Telescope.left, false, true);
        this.rightMotor = new LazyTalon(Telescope.right, true, true);
        this.follower = new Follower(Telescope.right, true);
        this.resetPosition();
    }

    public void move(boolean direction) {
        if (direction && this.rightMotor.getRadPosition() < DeviceConstants.TELESCOPE_LIMIT && this.leftMotor.getRadPosition() < DeviceConstants.TELESCOPE_LIMIT) {
            this.rightMotor.set(DeviceConstants.TELESCOPE_SPEED);
        } else if (!direction && this.rightMotor.getRadPosition() > 0 && this.leftMotor.getRadPosition() > 0) {
            this.rightMotor.set(-DeviceConstants.TELESCOPE_SPEED);
        } else {
            this.stopModules();
        }

        this.leftMotor.setControl(this.follower);
    }

    public void resetPosition() {
        this.leftMotor.setPosition(0.0);
        this.rightMotor.setPosition(0.0);
    }

    public void stopModules() {
        this.leftMotor.stopMotor();
        this.rightMotor.stopMotor();
    }
}
