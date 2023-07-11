// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  public DriveSubsystem m_driveSubsystem;
  /** Creates a new DriveCommand. */
  public DriveCommand(DriveSubsystem driveSubsystemPara) {
    m_driveSubsystem = driveSubsystemPara;
    addRequirements(m_driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Drive command has started!!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.m_driveSubsystem.velocityControl(3000);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.m_driveSubsystem.velocityControl(0);
    System.out.println("Drive command has ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
