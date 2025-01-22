// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSubsystem extends SubsystemBase {
  private DoubleSolenoid doubleSolenoid; // rm

  public PneumaticSubsystem() {
    doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0,1);
    //channels might be wrong

    //doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    //since a double solenoid defaults to kOff, it has to be set before it is toggled
    //I don't think I have to include this anymore considering that I'm not using the toggle method anymore
  }

  public void toggleSolenoidForward(){
    doubleSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void toggleSolenoidReverse(){
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

}
