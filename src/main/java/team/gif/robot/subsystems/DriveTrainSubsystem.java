// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  private WPI_TalonSRX leaderLeftCIM;
  private WPI_TalonSRX followerLeftCIM;
  private WPI_TalonSRX leaderRightCIM;
  private WPI_TalonSRX followerRightCIM;
  private DifferentialDrive robotDrive;

  public DriveTrainSubsystem() {
    leaderLeftCIM = new WPI_TalonSRX(/*ID goes here*/);
    followerLeftCIM = new WPI_TalonSRX(/*ID goes here*/)
    leaderRightCIM = new WPI_TalonSRX(/*ID goes here*/);
    followerRightCIM = new WPI_TalonSRX(/*ID goes here*/);

    followerLeftCIM.follow(leaderLeftCIM);
    followerRightCIM.follow(leaderRightCIM);

    robotDrive = new DifferentialDrive(leaderLeftCIM, leaderRightCIM);
  }
//drive mode (unsure about this might need to adjust a couple of things)
  public void driveTank(double leftSpeed, double rightSpeed){
    robotDrive.tankDrive(leftSpeed, rightSpeed);
  }

}
