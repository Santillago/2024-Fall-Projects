// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class SparkMAXControlSubsystem extends SubsystemBase {

  private CANSparkMax neoMotor;

  public SparkMAXControlSubsystem() {
    neoMotor = new CANSparkMax(RobotMap.NEO_MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
    neoMotor.restoreFactoryDefaults();
    neoMotor.setIdleMode(CANSparkBase.IdleMode.kBrake);
  }
  //public void setPercent(double percentOutput){
    //neomotor.set(percentOutput);
 // } I don't think I need this
  public void setVoltage(double voltage){
    neoMotor.setVoltage(voltage);
  }
}

