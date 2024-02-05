package frc.robot.lib;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.util.Units;

public class LazyTalon extends TalonFX {
    public LazyTalon(int port, boolean reverse, boolean neutralMode) {
        super(port);
        this.setInverted(reverse);
        this.setNeutralMode(neutralMode ? NeutralModeValue.Brake : NeutralModeValue.Coast);
    }

    public double getRadPosition() {
        return Units.rotationsToRadians(this.getPosition().getValue());
    }
}
