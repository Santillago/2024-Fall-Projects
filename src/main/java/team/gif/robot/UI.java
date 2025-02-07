package team.gif.robot;

/**
 *   Initialize the shuffleboard here.
 *   Shuffleboard is a modern looking driveteam focused dashboard. It displays network
 *    tables data using a variety of widgets that can be positioned and controlled with robot code.
 *   Helpful link: https://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/index.html

 *   Use the variable(shuffleboardTab) to add it to your shuffleboard.
 *   Example: shuffleboardTab.addBoolean("title of widget", Robot.arm::getPos());
 *   There is many more functions that you can use, example addString, addNumber, etc.
 */

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import team.gif.robot.subsystems.SparkMAXControlSubsystem;

public class UI {
    public UI() {
        ShuffleboardTab shuffleboardTab = Shuffleboard.getTab("BAB"); //tab name is BAB

        shuffleboardTab.addBoolean("Limit Switch", Robot.limitSwitchState::getLimitSwitchState);

        Robot.pigeon.addToShuffleboard("BAB", "Compass");

        shuffleboardTab.addDouble("Actual NEO RPM", Robot.sparkMAXControl::getSpeedinRPM);
    }
}
