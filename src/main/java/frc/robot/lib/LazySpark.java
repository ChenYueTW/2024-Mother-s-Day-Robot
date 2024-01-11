package frc.robot.lib;

import com.revrobotics.CANSparkMax;

public class LazySpark extends CANSparkMax {
    public LazySpark(int port, boolean reverse) {
        super(port, MotorType.kBrushless);
        this.setIdleMode(IdleMode.kBrake);
        this.setInverted(reverse);
        this.setSmartCurrentLimit(12);
    }
}
