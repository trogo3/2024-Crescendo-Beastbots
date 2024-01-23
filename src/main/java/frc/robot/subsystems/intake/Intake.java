package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.intake.IntakeIO.IntakeIOInputs;
import frc.robot.util.CANSpark;
import frc.robot.util.CANSpark.Controller;

public class Intake extends SubsystemBase {

    private double coolintakespeed = 0.0;
    private IntakeIO io;
    private final IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();
    public Intake() {
        
    }

    public void setIntakeSpeed(double speeed){
        coolintakespeed = speeed;
    }


    @Override
    public void periodic(){
        // coolintake.set(coolintakespeed);
        io.updateInputs(inputs);
        Logger.processInputs("coolintake", inputs);
        io.setIntakeSpeed(coolintakespeed);
    }
}
