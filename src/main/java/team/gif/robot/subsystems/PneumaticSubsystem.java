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
    doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH,1,2); //dont know if revph or CAN id is correct

    doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    //since a double solenoid defaults to kOff, it has to be set before it is toggled
  }

  public void toggleSolenoid(){
    doubleSolenoid.toggle();
  }

}
