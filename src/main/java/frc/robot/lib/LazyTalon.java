package frc.robot.lib;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class LazyTalon extends TalonFX {
    public LazyTalon(int port, boolean reverse) {
        super(port);
        this.setInverted(reverse);
        this.setNeutralMode(NeutralModeValue.Brake);
    }
}
