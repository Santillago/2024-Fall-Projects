// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import team.gif.lib.logging.EventFileLogger;
import team.gif.lib.logging.TelemetryFileLogger;
import team.gif.robot.commands.JoystickControl;
import team.gif.robot.subsystems.DriveTrainSubsystem;
import team.gif.robot.subsystems.PneumaticSubsystem;
import team.gif.robot.subsystems.SparkMAXControlSubsystem;
import team.gif.robot.subsystems.TalonSRXMotorControlSubsystem;
import team.gif.robot.subsystems.drivers.Pigeon;
import team.gif.robot.subsystems.LimitSwitchSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static Command autonomousCommand;
  private RobotContainer robotContainer;
  private static TelemetryFileLogger telemetryLogger;
  public static EventFileLogger eventLogger;

  public static Pigeon pigeon;

  public static UiSmartDashboard uiSmartDashboard;

  public static final boolean enableSwerveDebug = false;

  public static LimitSwitchSubsystem limitSwitchState;

  public static TalonSRXMotorControlSubsystem talonSRXMotorControl;

  public static SparkMAXControlSubsystem sparkMAXControl;

  public static UI ui;

  public static PneumaticSubsystem pneumatics;

  public static DriveTrainSubsystem driveTrain;

  public static OI oi;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    robotContainer = new RobotContainer();

    uiSmartDashboard = new UiSmartDashboard();

    talonSRXMotorControl = new TalonSRXMotorControlSubsystem();
    talonSRXMotorControl.setDefaultCommand(new JoystickControl());

    limitSwitchState = new LimitSwitchSubsystem();
    sparkMAXControl = new SparkMAXControlSubsystem();
    //if connected to TalonSRX: pigeon = new Pigeon(new TalonSRX(RobotMap.PIGEON_ID));
    //if connected to CAN:

    pigeon = new Pigeon(RobotMap.PIGEON_ID);

    ui = new UI();

    pneumatics = new PneumaticSubsystem();

    driveTrain = new DriveTrainSubsystem();

    oi = new OI();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    uiSmartDashboard.updateUI();

    //Call the new limit switch method and log to the driver station console (methods)
    System.out.println("Limit Switch" + limitSwitchState.getLimitSwitchState());
    //display pigeon heading every cycle as a number
    System.out.println("Pigeon Heading:" + pigeon.getCompassHeading());
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
