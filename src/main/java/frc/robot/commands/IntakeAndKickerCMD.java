// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeAndKickerSubsystem;

public class IntakeAndKickerCMD extends Command {
  /** Creates a new IntakeAndKickerCMD. */
  private final IntakeAndKickerSubsystem intakeAndKickerSubsystem;
  private double kickerVolts;
  private double intakeVolts;
  public IntakeAndKickerCMD(IntakeAndKickerSubsystem intakeAndKickerSubsystem, double kickerVolts, double intakeVolts) {
    this.intakeAndKickerSubsystem = intakeAndKickerSubsystem;
    this.intakeVolts = intakeVolts;
    this.kickerVolts = kickerVolts;
    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(intakeAndKickerSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Intake and Kicker SYS started");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeAndKickerSubsystem.setIntakeSYSSpeed( intakeVolts,  kickerVolts);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeAndKickerSubsystem.setIntakeSYSSpeed(0, 0);
    System.out.println("Intake and Kicker SYS stop");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (intakeAndKickerSubsystem.getIntakeSensor()){
      return true;
    }
    else{return false;}
  }
}
