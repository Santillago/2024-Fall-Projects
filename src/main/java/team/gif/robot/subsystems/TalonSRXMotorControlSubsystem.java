// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

public class TalonSRXMotorControlSubsystem extends SubsystemBase {
  private static TalonSRX cimMotor;

  public TalonSRXMotorControlSubsystem() {
    cimMotor = new TalonSRX(RobotMap.CIM_MOTOR_ID);
    cimMotor.configFactoryDefault();
    cimMotor.setNeutralMode(NeutralMode.Brake);
  }

  public static void setSpeedPercent(Double percentOutput){
    if (Robot.limitSwitchState.getLimitSwitchState()){
      cimMotor.set(TalonSRXControlMode.PercentOutput, percentOutput/2);
    }
    else {
        cimMotor.set(TalonSRXControlMode.PercentOutput, percentOutput);
    }
  }

}
