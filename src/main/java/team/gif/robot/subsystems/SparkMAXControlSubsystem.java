// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class SparkMAXControlSubsystem extends SubsystemBase {

  private static CANSparkMax neoMotor;
  private final SparkPIDController neoPID;

  public SparkMAXControlSubsystem() {
    neoMotor = new CANSparkMax(RobotMap.NEO_MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
    neoMotor.restoreFactoryDefaults();
    neoMotor.setIdleMode(CANSparkBase.IdleMode.kBrake);
    neoPID = neoMotor.getPIDController();
    neoPID.setP(0.0004);
    neoPID.setFF(0.000280);
  }

  public void setVoltage(double voltage){
    neoMotor.setVoltage(voltage);
  }
  public void setNEORPM(double setpoint){
    neoPID.setReference(setpoint, CANSparkBase.ControlType.kVelocity);
  }

  public double getSpeedinRPM(){
    return neoMotor.getEncoder().getVelocity();
  }
}

